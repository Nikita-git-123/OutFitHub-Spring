package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.entity.AddCart;
import com.example.service.AddCartService;

import jakarta.validation.Valid;

@Controller
public class AddCartController {
	
	@Autowired
	private AddCartService addCartService;

	@GetMapping("/cart")
	public String loadForm(Model model) {
		model.addAttribute("cart", new AddCart());
		return "AddToCart";
	}
	
	/*
	 * @GetMapping("/getCarts") public String getUsers(Model model) { List<AddCart>
	 * allUsers = addCartService.getAllUsers(); model.addAttribute("carts",
	 * allUsers); return "AddToCart"; }
	 */
	
	@PostMapping("/anarkaliSubmit1")
    public String anarkali1(AddCart addCart) {
        addCartService.saveAnarkali1(addCart);
        return "Code";  
    }
	
	@PostMapping("/anarkaliSubmit2")
    public String anarkali2(AddCart addCart) {
        addCartService.saveAnarkali2(addCart);
        return "Code";  
    }
	
	@PostMapping("/anarkaliSubmit3")
    public String anarkali3(AddCart addCart) {
        addCartService.saveAnarkali3(addCart);
        return "Code";  
    }
	
	@PostMapping("/anarkaliSubmit4")
    public String anarkali4(AddCart addCart) {
        addCartService.saveAnarkali4(addCart);
        return "Code";  
    }
	
	@PostMapping("/anarkaliSubmit5")
    public String anarkali5(AddCart addCart) {
        addCartService.saveAnarkali5(addCart);
        return "Code";  
    }
	
	@PostMapping("/anarkaliSubmit6")
    public String anarkali6(AddCart addCart) {
        addCartService.saveAnarkali6(addCart);
        return "Code";  
    }
}
