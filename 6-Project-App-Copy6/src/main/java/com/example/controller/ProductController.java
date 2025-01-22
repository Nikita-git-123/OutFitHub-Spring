package com.example.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.entity.Product;
import com.example.service.ProductService;

@Controller
public class ProductController {

	@Autowired
	private ProductService productService;
	
	@GetMapping("/search")
    public String search(@RequestParam("query") String query, Model model) {
		
		System.out.println("Search Query: " + query);

        // Search for products based on the query
        List<Product> products = productService.searchProducts(query);

        // Check if products are found for the given query
//        if (! products.isEmpty()) {
            // If products are found for "AnarkaliSet", show the "Anarkali" page
            if (query.equalsIgnoreCase("AnarkaliSet")) {
                model.addAttribute("products", products);
                return "Clothes/Anarkali";
            }
            // If products are found for "KurtaSet", show the "Register" page
            else if (query.equalsIgnoreCase("KurtaSet")) {
                model.addAttribute("products", products);
                return "Register";
            }
//        }
        
        return "AllClothes";

        // If no products were found, redirect to "Code" page or show a no-results message
		/*
		 * model.addAttribute("message", "No such product found for: " + query); return
		 * "Code";
		 */
    }

//	@GetMapping("/search")
	public String search1(@RequestParam("query") String query, Model model) {
		List<Product> products = productService.searchProducts(query);

		return null;
		/*
		 * if (products.isEmpty()) { model.addAttribute("message",
		 * "No products found for"); return "Code"; // No matching products, show
		 * message } else { model.addAttribute("products", products); return "Register";
		 * // Found matching products, show them }
		 */	}

	@GetMapping("/anarkaliSearch")
	public String anarkali(Model model) {
		List<Product> products = productService.searchProducts("AnarkaliSet");
		/*
		 * if (! products.isEmpty()) { model.addAttribute("message",
		 * "No Anarkali products found."); } else { model.addAttribute("products",
		 * products); }
		 */
		return "Anarkali";
	}
}
