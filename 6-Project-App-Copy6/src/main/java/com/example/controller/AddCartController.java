package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.entity.AddCart;
import com.example.service.AddCartServiceImpl;

import jakarta.servlet.http.HttpSession;

@Controller
public class AddCartController {
	
	@Autowired
	private AddCartServiceImpl addCartService;
	
	@GetMapping("/cart")
	public String getCartProducts(HttpSession session, Model model) {
		String username = (String) session.getAttribute("username");
		if(username == null) {
			return "Code";
		} 
		else {
			List<AddCart> allCarts = addCartService.getAllProducts(username);
			model.addAttribute("cart", new AddCart());
			model.addAttribute("carts", allCarts);
		}
		
		return "AddToCart";
	}
	
	@GetMapping("/deleteCart")
	public String deleteUser(@RequestParam("srNo") Long srNo, Model model) {
		boolean status = addCartService.deleteUserBySrNo(srNo);
		return "CodeLogin";
	}
	 
	
	@GetMapping("/anarkaliSubmit1")
    public String anarkali1(AddCart addCart, HttpSession session) {
		String username = (String)session.getAttribute("username");
		if(username == null) {
			return "Login";
		}
        addCartService.saveAnarkali1(addCart);
        return "CodeLogin";  
    }
	
	@GetMapping("/anarkaliSubmit2")
    public String anarkali2(AddCart addCart) {
        addCartService.saveAnarkali2(addCart);
        return "CodeLogin";  
    }
	
	@GetMapping("/anarkaliSubmit3")
    public String anarkali3(AddCart addCart) {
        addCartService.saveAnarkali3(addCart);
        return "CodeLogin";  
    }
	
	@GetMapping("/anarkaliSubmit4")
    public String anarkali4(AddCart addCart) {
        addCartService.saveAnarkali4(addCart);
        return "Code";  
    }
	
	@GetMapping("/anarkaliSubmit5")
    public String anarkali5(AddCart addCart) {
        addCartService.saveAnarkali5(addCart);
        return "Code";  
    }
	
	@GetMapping("/anarkaliSubmit6")
    public String anarkali6(AddCart addCart) {
        addCartService.saveAnarkali6(addCart);
        return "Code";  
    }
	
	@GetMapping("/anarkaliDupattaSubmit1")
    public String anarkaliDupatta1(AddCart addCart) {
        addCartService.saveAnarkaliDupatta1(addCart);
        return "Code";  
    }
	
	@GetMapping("/anarkaliDupattaSubmit2")
    public String anarkaliDupatta2(AddCart addCart) {
        addCartService.saveAnarkaliDupatta2(addCart);
        return "Code";  
    }
	
	@GetMapping("/anarkaliDupattaSubmit3")
    public String anarkaliDupatta3(AddCart addCart) {
        addCartService.saveAnarkaliDupatta3(addCart);
        return "Code";  
    }
	
	@GetMapping("/anarkaliDupattaSubmit4")
    public String anarkaliDupatta4(AddCart addCart) {
        addCartService.saveAnarkaliDupatta4(addCart);
        return "Code";  
    }
	
	@GetMapping("/anarkaliDupattaSubmit5")
    public String anarkaliDupatta5(AddCart addCart) {
        addCartService.saveAnarkaliDupatta5(addCart);
        return "Code";  
    }
	
	@GetMapping("/anarkaliDupattaSubmit6")
    public String anarkaliDupatta6(AddCart addCart) {
        addCartService.saveAnarkaliDupatta6(addCart);
        return "Code";  
    }
	
	@GetMapping("/anarkaliDupattaSubmit7")
    public String anarkaliDupatta7(AddCart addCart) {
        addCartService.saveAnarkaliDupatta7(addCart);
        return "Code";  
    }
	
	@GetMapping("/anarkaliDupattaSubmit8")
    public String anarkaliDupatta8(AddCart addCart) {
        addCartService.saveAnarkaliDupatta8(addCart);
        return "Code";  
    }
	
	@GetMapping("/cordSetSubmit1")
    public String cordSet1(HttpSession session, AddCart addCart) {
		String username = (String) session.getAttribute("username");
		if(username == null) {
			return "Login";
		}
        addCartService.saveCordSet1(addCart);
        return "Code";  
    }
	
	@GetMapping("/cordSetSubmit2")
    public String cordSet2(AddCart addCart) {
        addCartService.saveCordSet2(addCart);
        return "Code";  
    }
	
	@GetMapping("/cordSetSubmit3")
    public String cordSet3(AddCart addCart) {
        addCartService.saveCordSet3(addCart);
        return "Code";  
    }
	
	@GetMapping("/cordSetSubmit4")
    public String cordSet4(AddCart addCart) {
        addCartService.saveCordSet4(addCart);
        return "Code";  
    }
	
	@GetMapping("/cordSetSubmit5")
    public String cordSet5(AddCart addCart) {
        addCartService.saveCordSet5(addCart);
        return "Code";  
    }
	
	@GetMapping("/cordSetSubmit6")
    public String cordSet6(AddCart addCart) {
        addCartService.saveCordSet6(addCart);
        return "Code";  
    }
	
	@GetMapping("/kurtaDupattaSubmit1")
    public String kurtaDupattaa1(AddCart addCart) {
        addCartService.saveKurtaDupatta1(addCart);
        return "Code";  
    }
	
	@GetMapping("/kurtaDupattaSubmit2")
    public String kurtaDupattaa2(AddCart addCart) {
        addCartService.saveKurtaDupatta2(addCart);
        return "Code";  
    }
	
	@GetMapping("/kurtaDupattaSubmit3")
    public String kurtaDupattaa3(AddCart addCart) {
        addCartService.saveKurtaDupatta3(addCart);
        return "Code";  
    }
	
	@GetMapping("/kurtaDupattaSubmit4")
    public String kurtaDupattaa4(AddCart addCart) {
        addCartService.saveKurtaDupatta4(addCart);
        return "Code";  
    }
	
	@GetMapping("/kurtaDupattaSubmit5")
    public String kurtaDupattaa5(AddCart addCart) {
        addCartService.saveKurtaDupatta5(addCart);
        return "Code";  
    }
	
	@GetMapping("/kurtaDupattaSubmit6")
    public String kurtaDupattaa6(AddCart addCart) {
        addCartService.saveKurtaDupatta6(addCart);
        return "Code";  
    }
	
	@GetMapping("/kurtaSetSubmit1")
    public String kurtaSet1(AddCart addCart) {
        addCartService.saveKurtaSet1(addCart);
        return "Code";  
    }
	
	@GetMapping("/kurtaSetSubmit2")
    public String kurtaSet2(AddCart addCart) {
        addCartService.saveKurtaSet2(addCart);
        return "Code";  
    }
	
	@GetMapping("/kurtaSetSubmit3")
    public String kurtaSet3(AddCart addCart) {
        addCartService.saveKurtaSet3(addCart);
        return "Code";  
    }
	
	@GetMapping("/kurtaSetSubmit4")
    public String kurtaSet4(AddCart addCart) {
        addCartService.saveKurtaSet4(addCart);
        return "Code";  
    }
	
	@GetMapping("/kurtaSetSubmit5")
    public String kurtaSet5(AddCart addCart) {
        addCartService.saveKurtaSet5(addCart);
        return "Code";  
    }
	
	@GetMapping("/kurtaSetSubmit6")
    public String kurtaSet6(AddCart addCart) {
        addCartService.saveKurtaSet6(addCart);
        return "Code";  
    }
}
