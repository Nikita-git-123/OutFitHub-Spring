package com.example.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.entity.Customer;
import com.example.service.CustomerService;

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

	@GetMapping("/secqn")
	public String loadFormforSecQn(Model model) {
		Customer customerObj = new Customer();
		model.addAttribute("secQn", customerObj);
		return "SecQn";
	}
	
	@GetMapping("/loginPage")
	public String loadFormforLogin(Customer customer,Model model) {
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

	@PostMapping("/secQnCustomer")
	public String handleForgotPwd(String secQn, Model model) {

		boolean isCorrect = customerService.findBySecQn(secQn);
		model.addAttribute("updatePwd", new Customer());
		if (isCorrect) {
			return "PwdSet"; // Redirect to the next page if correct
		} else {
			return "PwdMismatch"; // Stay on the same page and show error message
		}
	}

	@PostMapping("/setPwd")
	@ResponseBody
	public String setNewForgotPwd(Customer customer, String password1, String password2, Model model) {
		if (password1.equals(password2)) {
			/*
			 * customer.setPassword1(password1); Customer save =
			 * customerRepo.save(customer); System.out.println(save + "==========");
			 */
			return "matched "; // executing successfully
		}
		return "failed...";
	}

	@GetMapping("/login")
	public String login(@RequestParam String username, @RequestParam String password1) {
		Optional<Customer> customer = customerService.findByUsernameAndPassword1(username, password1);
		if (customer.isPresent()) {
			return "Code";
		}
		return "Login";
	}
}
