package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.entity.Product;
import com.example.service.ProductService;

@Controller
public class ProductController {

	@Autowired
	private ProductService productService;

	@GetMapping("/search")
	public String search(@RequestParam("query") String query, Model model) {

		List<Product> products = productService.searchProducts(query);

		if (query.equalsIgnoreCase("Anarkali")) {
			model.addAttribute("products", products);
			return "Clothes/Anarkali";
		}
		else if (query.equalsIgnoreCase("AnarkaliDupatta")) {
			model.addAttribute("products", products);
			return "Clothes/AnarkaliDupatta";
		}
		else if (query.equalsIgnoreCase("CordSet")) {
			model.addAttribute("products", products);
			return "Clothes/CordSet";
		}
		else if (query.equalsIgnoreCase("KurtaDupatta")) {
			model.addAttribute("products", products);
			return "Clothes/KurtaDupatta";
		}
		else if (query.equalsIgnoreCase("KurtaSet")) {
			model.addAttribute("products", products);
			return "Clothes/KurtaSet";
		}
		return "Code";

		/*
		 * model.addAttribute("message", "No such product found for: " + query); return
		 * "Code";
		 */
		 
	}
}
