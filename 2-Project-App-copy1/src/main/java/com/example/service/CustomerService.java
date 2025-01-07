package com.example.service;

import java.util.Optional;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import com.example.entity.Customer;
import com.example.repo.CustomerRepo;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;

@Service
public class CustomerService {

	@Autowired
	private CustomerRepo customerRepo;

	@Autowired
	private JavaMailSender mailSender;

	public String generateVerificationCode() {
		return String.valueOf(new Random().nextInt(999999));
	}

	public void sendVerificationCode(String email) throws MessagingException {
		Customer byEmail = customerRepo.findByEmail(email);
		if(byEmail != null) {
			String verificationCode = generateVerificationCode();
			byEmail.setVerificationCode(verificationCode);
			customerRepo.save(byEmail);
			sendEmail(email, verificationCode);
		}
		/*
		 * if (customer == null) { throw new RuntimeException("User not found"); }
		 */

		// Send email
	}

	private void sendEmail(String email, String verificationCode) throws MessagingException {
		MimeMessage message = mailSender.createMimeMessage();
		MimeMessageHelper helper = new MimeMessageHelper(message, true);

		helper.setFrom("0.outfithub@gmail.com");
		helper.setTo(email);
		helper.setSubject("Password Reset Verification Code");
		helper.setText("Your verification code is: " + verificationCode);

		mailSender.send(message);
	}

	public boolean verifyCode(String email, String verificationCode) {
		Customer customer = customerRepo.findByEmail(email);
		return customer.getVerificationCode().equals(verificationCode);
	}

	public void updatePassword(String email, String password1) {
		Customer customer = customerRepo.findByEmail(email);
		if (customer != null) {
			customer.setPassword1(password1); // You should encode this password using BCrypt or another algorithm.
			customer.setVerificationCode(null); // Clear verification code after successful reset
			customerRepo.save(customer);
		}
	}
	
	
	
	

	public boolean saveCustomer(Customer customer) {
		Customer savedCustomer = customerRepo.save(customer);
		// System.out.println("Saved ...... " + savedCustomer);
		return savedCustomer.getId() != null;
	}

	/*
	 * public boolean findByEmail(String email) { Optional<Customer> byEmail =
	 * customerRepo.findByEmail(email);
	 * 
	 * if (bySecQn.isPresent()) { customer.setPassword1(secQn); Customer save =
	 * customerRepo.save(customer); System.out.println("Completed ...... " + save);
	 * }
	 * 
	 * return byEmail.map(securityQuestion ->
	 * securityQuestion.getEmail().equals(email)).orElse(false); }
	 */

	public Optional<Customer> findByUsernameAndPassword1(String username, String password1) {
		return customerRepo.findByUsernameAndPassword1(username, password1);
	}

}
