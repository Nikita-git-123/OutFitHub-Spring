package com.example.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
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
	public String loadFormforLogin(Customer customer, Model model) {
		model.addAttribute("login", new Customer());
		return "Login";
	}

	@GetMapping("/logoutPage")
	public String loadFormforLogout(Customer customer, Model model) {
		model.addAttribute("logout", new Customer());
		return "Logout";
	}

	@PostMapping("/customer")
	public String handleSubmit(HttpServletRequest req, Customer customer, Model model) {
		boolean savedCustomer = customerService.saveCustomer(customer);
		model.addAttribute("login", new Customer());
		if (savedCustomer) {
			model.addAttribute("smsg", "User Registered Successfully....");
			HttpSession session = req.getSession();
			session.setAttribute("CustomerName", customer.getName()); // Store customer name
		}
		return "Register";
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

	@PostMapping("/login")
	public String login(@ModelAttribute("login") Customer login, BindingResult result, Model model, HttpServletRequest req, @RequestParam String username,
			@RequestParam String password1) {
		Optional<Customer> customer = customerService.findByUsernameAndPassword1(username, password1);
		if (customer.isPresent()) {
			HttpSession session = req.getSession();
			session.setAttribute("username", username);
			return "CodeLogout";
		} else {
			model.addAttribute("emsg", "Invalid Credentials");
			return "Login";
		}
	}

	/*
	 * @PostMapping("/login") public String login(Model model, HttpServletRequest
	 * req, @RequestParam String username, @RequestParam String password1) { // Step
	 * 1: Try to find the user by username Optional<Customer> customer =
	 * customerService.findByUsername(username);
	 * 
	 * if (customer.isPresent()) { // Step 2: If user is found, check if the
	 * password is correct Customer foundCustomer = customer.get();
	 * 
	 * // You should be using a secure password comparison (e.g., BCrypt check) if
	 * (password1.equals(foundCustomer.getPassword1())) { // Step 3: If password
	 * matches, create a session and redirect HttpSession session =
	 * req.getSession(); session.setAttribute("username", username); return
	 * "CodeLogout"; // Redirect to the dashboard or another page } else { // If
	 * password is incorrect model.addAttribute("emsg", "Incorrect password.");
	 * return "Login"; // Return to login page with error message } } else { // If
	 * user is not found model.addAttribute("emsg", "User not found."); return
	 * "Login"; // Return to login page with error message } }
	 */

	@GetMapping("/logout")
	public String logout(HttpServletRequest req, Model model) {
		HttpSession session = req.getSession(false);
		if (session == null) {
			model.addAttribute("smsg", "Please Login first..");
			return "Logout";
		} else {
			session.invalidate();
			return "Code";
		}
	}
}
