package com.example.controller;

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
	public String loadForm(Model model) {
		Customer customerObj = new Customer();
		model.addAttribute("customer", customerObj);
		return "Register";
	}
	
	@ResponseBody
	@PostMapping("/customer")
	public String handleSubmit(@RequestParam("Upwd1") String Upwd1, @RequestParam("Upwd2") String Upwd2,  Customer customer, Model model) {
		
		if(Upwd1.equals(Upwd2)) {
			boolean savedCustomer = customerService.saveCustomer(customer);
			if(savedCustomer) 
				return "successfull.......";
			else
				return "failed.............";
		}
		
		/*
		 * boolean isSaved = customerService.saveCustomer(customer); if(isSaved) return
		 * "Successfull..........";
		 */
		
		
		/*if(isSaved) {
			 model.addAttribute("smsg", "User Saved");
		}
		else {
			model.addAttribute("emsg", "User not saved");
		}
		return "index";*/
		
		return "saved successfully........";
	}
}