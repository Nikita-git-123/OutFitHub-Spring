package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.entity.Customer;
import com.example.service.CustomerService;

@Controller
public class CustomerController {

	@Autowired
	private CustomerService customerService;

	@GetMapping("/")
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
		
		// return "Register";
	}

	@ResponseBody
	@PostMapping("/customer")
	public String handleSubmit(Customer customer, Model model) {
		boolean savedCustomer = customerService.saveCustomer(customer);
		if (savedCustomer)
			return "successfull.......";
		return "saved successfully........";
	}

	@ResponseBody
	@PostMapping("/secQnCustomer")
	public String handleForgotPwd(String secQn, Model model) {
		// String customerBySecQn = customerService.getCustomerBySecQn(secQn, model);
		// return "successfull......." + customerBySecQn ;
		
		 boolean isCorrect = customerService.findBySecQn(secQn);
	        if (isCorrect) {
	            return "successfull..........";  // Redirect to the next page if correct
	        } else {
	            return "not found ";  // Stay on the same page and show error message
	        }
	}

}
