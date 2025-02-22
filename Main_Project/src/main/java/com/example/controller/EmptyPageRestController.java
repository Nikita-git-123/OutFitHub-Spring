package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class EmptyPageRestController {

	@GetMapping("/")
	public String loadCode() {
		return "CodeLogin";
	}
	
	@GetMapping("/clothes")
	public String allClothes() {
		return "AllClothes";
	}
	
	@GetMapping("/aboutus")
	public String aboutUS() {
		return "AboutUs";
	}
	
	@GetMapping("/contactus")
	public String contactUS() {
		return "ContactUs";
	}
	
	
}
