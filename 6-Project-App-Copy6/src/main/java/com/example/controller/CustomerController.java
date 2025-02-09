package com.example.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.entity.Customer;
import com.example.service.CustomerService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
public class CustomerController {

	@Autowired
	private CustomerService customerService; 
	
	
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
	
	@GetMapping("/logoutPage")
	public String loadFormforLogout(Customer customer,Model model) {
		model.addAttribute("logout", new Customer());
		return "Logout";
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
	public String handleForgotPwd(@RequestParam String secQn, Model model) {

		boolean isCorrect = customerService.findBySecQn(secQn);
		model.addAttribute("updatePwd", new Customer());
		if (isCorrect) {
			return "PwdSet"; // Redirect to the next page if correct
		} else {
			return "PwdMismatch"; // Stay on the same page and show error message
		}
	}

	@PostMapping("/setPwd")
	public String setNewForgotPwd(Customer customer, String password1, String password2, Model model) {
		if (password1.equals(password2)) {
			 customer.setPassword1(password1);
			 customerService.saveCustomer(customer);
			 
			return "Login "; // executing successfully
		}
		return "failed...";
	}

	@GetMapping("/login")
	public String login(HttpServletRequest req, @RequestParam String username, @RequestParam String password1) {
		Optional<Customer> customer = customerService.findByUsernameAndPassword1(username, password1);
		if (customer.isPresent()) {
			HttpSession session = req.getSession(true);
			session.setAttribute("username", username);
				return "CodeLogout";
		}
		return "Login";
	}
	
	@GetMapping("/logout")
	public String logout(HttpServletRequest req) {
		HttpSession session = req.getSession(false);
		session.invalidate();
		return "CodeLogin";
	}
}
