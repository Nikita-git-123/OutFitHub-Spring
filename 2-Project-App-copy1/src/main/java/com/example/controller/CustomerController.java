package com.example.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.entity.Customer;
import com.example.service.CustomerService;

import jakarta.mail.MessagingException;

@Controller
public class CustomerController {

	@Autowired
	private CustomerService customerService;

	@GetMapping("/")
	public String loadCode() {
		return "Code";
	}

	@GetMapping("/clothes")
	public String allClothes() {
		return "AllClothes";
	}

	@GetMapping("/aboutus")
	public String aboutUS() {
		return "AboutUs";
	}

	@GetMapping("/register")
	public String loadForm(Model model) {
		Customer customerObj = new Customer();
		model.addAttribute("customer", customerObj);
		return "Register";
	}

	@GetMapping("/email")
	public String loadFormforSecQn(Model model) {
		model.addAttribute("secQn", new Customer());
		return "Email";
	}

	@GetMapping("/loginPage")
	public String loadFormforLogin(Customer customer, Model model) {
		model.addAttribute("login", new Customer());
		return "Login";
	}

	@PostMapping("/customer")
	public String handleSubmit(Customer customer, Model model) {
		boolean savedCustomer = customerService.saveCustomer(customer);
		model.addAttribute("login", new Customer());
		if (savedCustomer)
			return "Login";
		return "Registration";
	}

	@PostMapping("/emailCustomer")
	public String sendVerificationCode(@RequestParam String email, Model model) throws MessagingException {
		customerService.sendVerificationCode(email);
		model.addAttribute("verificationCode", new Customer());
		return "VerificationCode";
	}

	@PostMapping("/vCodeCustomer")
	public String verifyCode(@RequestParam String email, @RequestParam String verificationCode) {
		boolean isValid = customerService.verifyCode(email, verificationCode);
		if (isValid) {
			return "PwdSet";
		}
		return "VerificationCode";
	}

	@PostMapping("/setPwd")
	@ResponseBody
	public String resetPassword(@RequestParam String email, @RequestParam String password1,
			@RequestParam String password2) {
		if (password1.equals(password2)) {
			return "matched";
		}
		return "failed";
	}

	/*
	 * @PostMapping("/emailCustomer") public String handleForgotPwdEmail(String
	 * email, Model model) {
	 * 
	 * boolean isCorrect = customerService.findByEmail(email);
	 * model.addAttribute("verificationCode", new Customer()); if (isCorrect) {
	 * return "VerificationCode"; // Redirect to the next page if correct } else {
	 * return "PwdMismatch"; // Stay on the same page and show error message } }
	 */

	/*
	 * @PostMapping("/vCodeCustomer") public String
	 * handleForgotPwdVerificationCode(String email, Model model) {
	 * 
	 * // write here a method to go PwdSet.html page from verification code page
	 * model.addAttribute("updatePwd", new Customer()); return "PwdSet"; }
	 */
	/*
	 * @PostMapping("/setPwd")
	 * 
	 * @ResponseBody public String setNewForgotPwd(Customer customer, String
	 * password1, String password2, Model model) { if (password1.equals(password2))
	 * {
	 * 
	 * customer.setPassword1(password1); Customer save =
	 * customerRepo.save(customer); System.out.println(save + "==========");
	 * 
	 * return "matched "; // executing successfully } return "failed..."; }
	 */

	@GetMapping("/login")
	public String login(@RequestParam String username, @RequestParam String password1) {
		Optional<Customer> customer = customerService.findByUsernameAndPassword1(username, password1);
		if (customer.isPresent()) {
			return "Code";
		}
		return "Login";
	}
}
