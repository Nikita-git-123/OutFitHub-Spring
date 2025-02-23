package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.entity.AddCart;
import com.example.service.AddCartServiceImpl;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
public class AddCartController {

	@Autowired
	private AddCartServiceImpl addCartService;

	@GetMapping("/cart")
	public String getCartProducts(HttpServletRequest req, Model model) {
		HttpSession session = req.getSession();
		String username = (String) session.getAttribute("username");
		if (username == null) {
			model.addAttribute("emsg", "Please Login First");
		} else {
			List<AddCart> allCarts = addCartService.getProducts(username);
//			model.addAttribute("cart", new AddCart());
			model.addAttribute("carts", allCarts);
		}
		return "AddToCart";
	}

	@GetMapping("/anarkaliSubmit1")
	public String anarkali1(Model model, AddCart addCart, HttpServletRequest req) {
		HttpSession session = req.getSession(true);
		String username = (String) session.getAttribute("username");
		if (username != null) {
			addCartService.saveAnarkali1(username, addCart);
			model.addAttribute("smsg", "Product Added Successfully.........");// Save product associated with the user
			return "Clothes/Anarkali1";
		} else {
			model.addAttribute("emsg", "Please Login First");
			return "Clothes/Anarkali1";
		}
	}

	@GetMapping("/anarkaliSubmit2")
	public String anarkali2(Model model, AddCart addCart, HttpServletRequest req) {
		HttpSession session = req.getSession(true);
		String username = (String) session.getAttribute("username");
		if (username != null) {
			addCartService.saveAnarkali2(username, addCart);
			model.addAttribute("smsg", "Product Added Successfully.........");// Save product associated with the user
			return "Clothes/Anarkali2";
		} else {
			model.addAttribute("emsg", "Please Login First");
			return "Clothes/Anarkali2";
		}
	}

	@GetMapping("/anarkaliSubmit3")
	public String anarkali3(Model model, AddCart addCart, HttpServletRequest req) {
		HttpSession session = req.getSession(true);
		String username = (String) session.getAttribute("username");
		if (username != null) {
			addCartService.saveAnarkali3(username, addCart);
			model.addAttribute("smsg", "Product Added Successfully.........");// Save product associated with the user
			return "Clothes/Anarkali3";
		} else {
			model.addAttribute("emsg", "Please Login First");
			return "Clothes/Anarkali3";
		}
	}

	@GetMapping("/anarkaliSubmit4")
	public String anarkali4(Model model, AddCart addCart, HttpServletRequest req) {
		HttpSession session = req.getSession(true);
		String username = (String) session.getAttribute("username");
		if (username != null) {
			addCartService.saveAnarkali4(username, addCart);
			model.addAttribute("smsg", "Product Added Successfully.........");// Save product associated with the user
			return "Clothes/Anarkali4";
		} else {
			model.addAttribute("emsg", "Please Login First");
			return "Clothes/Anarkali4";
		}
	}
	
	@GetMapping("/anarkaliSubmit5")
	public String anarkali5(Model model, AddCart addCart, HttpServletRequest req) {
		HttpSession session = req.getSession(true);
		String username = (String) session.getAttribute("username");
		if (username != null) {
			addCartService.saveAnarkali5(username, addCart);
			model.addAttribute("smsg", "Product Added Successfully.........");// Save product associated with the user
			return "Clothes/Anarkali5";
		} else {
			model.addAttribute("emsg", "Please Login First");
			return "Clothes/Anarkali5";
		}
	}

	@GetMapping("/anarkaliSubmit6")
	public String anarkali6(Model model, AddCart addCart, HttpServletRequest req) {
		HttpSession session = req.getSession(true);
		String username = (String) session.getAttribute("username");
		if (username != null) {
			addCartService.saveAnarkali6(username, addCart);
			model.addAttribute("smsg", "Product Added Successfully.........");// Save product associated with the user
			return "Clothes/Anarkali6";
		} else {
			model.addAttribute("emsg", "Please Login First");
			return "Clothes/Anarkali6";
		}
	}
	
	@GetMapping("/anarkaliDupattaSubmit1")
	public String anarkaliDupatta1(Model model, AddCart addCart, HttpServletRequest req) {
		HttpSession session = req.getSession(true);
		String username = (String) session.getAttribute("username");
		if (username != null) {
			addCartService.saveAnarkaliDupatta1(username, addCart);
			model.addAttribute("smsg", "Product Added Successfully.........");// Save product associated with the user
			return "Clothes/AnarkaliDupatta1";
		} else {
			model.addAttribute("emsg", "Please Login First");
			return "Clothes/AnarkaliDupatta1";
		}
	}


	@GetMapping("/anarkaliDupattaSubmit2")
	public String anarkaliDupatta2(Model model, AddCart addCart, HttpServletRequest req) {
		HttpSession session = req.getSession(true);
		String username = (String) session.getAttribute("username");
		if (username != null) {
			addCartService.saveAnarkaliDupatta2(username, addCart);
			model.addAttribute("smsg", "Product Added Successfully.........");// Save product associated with the user
			return "Clothes/AnarkaliDupatta2";
		} else {
			model.addAttribute("emsg", "Please Login First");
			return "Clothes/AnarkaliDupatta2";
		}
	}

	@GetMapping("/anarkaliDupattaSubmit3")
	public String anarkaliDupatta3(Model model, AddCart addCart, HttpServletRequest req) {
		HttpSession session = req.getSession(true);
		String username = (String) session.getAttribute("username");
		if (username != null) {
			addCartService.saveAnarkaliDupatta3(username, addCart);
			model.addAttribute("smsg", "Product Added Successfully.........");// Save product associated with the user
			return "Clothes/AnarkaliDupatta3";
		} else {
			model.addAttribute("emsg", "Please Login First");
			return "Clothes/AnarkaliDupatta3";
		}
	}

	@GetMapping("/anarkaliDupattaSubmit4")
	public String anarkaliDupatta4(Model model, AddCart addCart, HttpServletRequest req) {
		HttpSession session = req.getSession(true);
		String username = (String) session.getAttribute("username");
		if (username != null) {
			addCartService.saveAnarkaliDupatta4(username, addCart);
			model.addAttribute("smsg", "Product Added Successfully.........");// Save product associated with the user
			return "Clothes/AnarkaliDupatta4";
		} else {
			model.addAttribute("emsg", "Please Login First");
			return "Clothes/AnarkaliDupatta4";
		}
	}

	@GetMapping("/anarkaliDupattaSubmit5")
	public String anarkaliDupatta5(Model model, AddCart addCart, HttpServletRequest req) {
		HttpSession session = req.getSession(true);
		String username = (String) session.getAttribute("username");
		if (username != null) {
			addCartService.saveAnarkaliDupatta5(username, addCart);
			model.addAttribute("smsg", "Product Added Successfully.........");// Save product associated with the user
			return "Clothes/AnarkaliDupatta5";
		} else {
			model.addAttribute("emsg", "Please Login First");
			return "Clothes/AnarkaliDupatta5";
		}
	}

	@GetMapping("/anarkaliDupattaSubmit6")
	public String anarkaliDupatta6(Model model, AddCart addCart, HttpServletRequest req) {
		HttpSession session = req.getSession(true);
		String username = (String) session.getAttribute("username");
		if (username != null) {
			addCartService.saveAnarkaliDupatta6(username, addCart);
			model.addAttribute("smsg", "Product Added Successfully.........");// Save product associated with the user
			return "Clothes/AnarkaliDupatta6";
		} else {
			model.addAttribute("emsg", "Please Login First");
			return "Clothes/AnarkaliDupatta6";
		}
	}

	@GetMapping("/anarkaliDupattaSubmit7")
	public String anarkaliDupatta7(Model model, AddCart addCart, HttpServletRequest req) {
		HttpSession session = req.getSession(true);
		String username = (String) session.getAttribute("username");
		if (username != null) {
			addCartService.saveAnarkaliDupatta7(username, addCart);
			model.addAttribute("smsg", "Product Added Successfully.........");// Save product associated with the user
			return "Clothes/AnarkaliDupatta7";
		} else {
			model.addAttribute("emsg", "Please Login First");
			return "Clothes/AnarkaliDupatta7";
		}
	}

	@GetMapping("/anarkaliDupattaSubmit8")
	public String anarkaliDupatta8(Model model, AddCart addCart, HttpServletRequest req) {
		HttpSession session = req.getSession(true);
		String username = (String) session.getAttribute("username");
		if (username != null) {
			addCartService.saveAnarkaliDupatta8(username, addCart);
			model.addAttribute("smsg", "Product Added Successfully.........");// Save product associated with the user
			return "Clothes/AnarkaliDupatta8";
		} else {
			model.addAttribute("emsg", "Please Login First");
			return "Clothes/AnarkaliDupatta8";
		}
	}
	
	@GetMapping("/cordSetSubmit1")
	public String cordSet1(Model model, AddCart addCart, HttpServletRequest req) {
		HttpSession session = req.getSession(true);
		String username = (String) session.getAttribute("username");
		if (username != null) {
			addCartService.saveCordSet1(username, addCart);
			model.addAttribute("smsg", "Product Added Successfully.........");// Save product associated with the user
			return "Clothes/CordSet1";
		} else {
			model.addAttribute("emsg", "Please Login First");
			return "Clothes/CordSet1";
		}
	}

	@GetMapping("/cordSetSubmit2")
	public String cordSet2(Model model, AddCart addCart, HttpServletRequest req) {
		HttpSession session = req.getSession(true);
		String username = (String) session.getAttribute("username");
		if (username != null) {
			addCartService.saveCordSet2(username, addCart);
			model.addAttribute("smsg", "Product Added Successfully.........");// Save product associated with the user
			return "Clothes/CordSet2";
		} else {
			model.addAttribute("emsg", "Please Login First");
			return "Clothes/CordSet2";
		}
	}

	@GetMapping("/cordSetSubmit3")
	public String cordSet3(Model model, AddCart addCart, HttpServletRequest req) {
		HttpSession session = req.getSession(true);
		String username = (String) session.getAttribute("username");
		if (username != null) {
			addCartService.saveCordSet3(username, addCart);
			model.addAttribute("smsg", "Product Added Successfully.........");// Save product associated with the user
			return "Clothes/CordSet3";
		} else {
			model.addAttribute("emsg", "Please Login First");
			return "Clothes/CordSet3";
		}
	}

	@GetMapping("/cordSetSubmit4")
	public String cordSet4(Model model, AddCart addCart, HttpServletRequest req) {
		HttpSession session = req.getSession(true);
		String username = (String) session.getAttribute("username");
		if (username != null) {
			addCartService.saveCordSet4(username, addCart);
			model.addAttribute("smsg", "Product Added Successfully.........");// Save product associated with the user
			return "Clothes/CordSet4";
		} else {
			model.addAttribute("emsg", "Please Login First");
			return "Clothes/CordSet4";
		}
	}

	@GetMapping("/cordSetSubmit5")
	public String cordSet5(Model model, AddCart addCart, HttpServletRequest req) {
		HttpSession session = req.getSession(true);
		String username = (String) session.getAttribute("username");
		if (username != null) {
			addCartService.saveCordSet5(username, addCart);
			model.addAttribute("smsg", "Product Added Successfully.........");// Save product associated with the user
			return "Clothes/CordSet5";
		} else {
			model.addAttribute("emsg", "Please Login First");
			return "Clothes/CordSet5";
		}
	}

	@GetMapping("/cordSetSubmit6")
	public String cordSet6(Model model, AddCart addCart, HttpServletRequest req) {
		HttpSession session = req.getSession(true);
		String username = (String) session.getAttribute("username");
		if (username != null) {
			addCartService.saveCordSet6(username, addCart);
			model.addAttribute("smsg", "Product Added Successfully.........");// Save product associated with the user
			return "Clothes/CordSet6";
		} else {
			model.addAttribute("emsg", "Please Login First");
			return "Clothes/CordSet6";
		}
	}
	
	@GetMapping("/kurtaDupattaSubmit1")
	public String kurtaDupattaa1(Model model, AddCart addCart, HttpServletRequest req) {
		HttpSession session = req.getSession(true);
		String username = (String) session.getAttribute("username");
		if (username != null) {
			addCartService.saveKurtaDupatta1(username, addCart);
			model.addAttribute("smsg", "Product Added Successfully.........");// Save product associated with the user
			return "Clothes/KurtaDupatta1";
		} else {
			model.addAttribute("emsg", "Please Login First");
			return "Clothes/KurtaDupatta1";
		}
	}

	@GetMapping("/kurtaDupattaSubmit2")
	public String kurtaDupattaa2(Model model, AddCart addCart, HttpServletRequest req) {
		HttpSession session = req.getSession(true);
		String username = (String) session.getAttribute("username");
		if (username != null) {
			addCartService.saveKurtaDupatta2(username, addCart);
			model.addAttribute("smsg", "Product Added Successfully.........");// Save product associated with the user
			return "Clothes/KurtaDupatta2";
		} else {
			model.addAttribute("emsg", "Please Login First");
			return "Clothes/KurtaDupatta2";
		}
	}

	@GetMapping("/kurtaDupattaSubmit3")
	public String kurtaDupattaa3(Model model, AddCart addCart, HttpServletRequest req) {
		HttpSession session = req.getSession(true);
		String username = (String) session.getAttribute("username");
		if (username != null) {
			addCartService.saveKurtaDupatta3(username, addCart);
			model.addAttribute("smsg", "Product Added Successfully.........");// Save product associated with the user
			return "Clothes/KurtaDupatta3";
		} else {
			model.addAttribute("emsg", "Please Login First");
			return "Clothes/KurtaDupatta3";
		}
	}

	@GetMapping("/kurtaDupattaSubmit4")
	public String kurtaDupattaa4(Model model, AddCart addCart, HttpServletRequest req) {
		HttpSession session = req.getSession(true);
		String username = (String) session.getAttribute("username");
		if (username != null) {
			addCartService.saveKurtaDupatta4(username, addCart);
			model.addAttribute("smsg", "Product Added Successfully.........");// Save product associated with the user
			return "Clothes/KurtaDupatta4";
		} else {
			model.addAttribute("emsg", "Please Login First");
			return "Clothes/KurtaDupatta4";
		}
	}

	@GetMapping("/kurtaDupattaSubmit5")
	public String kurtaDupattaa5(Model model, AddCart addCart, HttpServletRequest req) {
		HttpSession session = req.getSession(true);
		String username = (String) session.getAttribute("username");
		if (username != null) {
			addCartService.saveKurtaDupatta5(username, addCart);
			model.addAttribute("smsg", "Product Added Successfully.........");// Save product associated with the user
			return "Clothes/KurtaDupatta5";
		} else {
			model.addAttribute("emsg", "Please Login First");
			return "Clothes/KurtaDupatta5";
		}
	}

	@GetMapping("/kurtaDupattaSubmit6")
	public String kurtaDupattaa6(Model model, AddCart addCart, HttpServletRequest req) {
		HttpSession session = req.getSession(true);
		String username = (String) session.getAttribute("username");
		if (username != null) {
			addCartService.saveKurtaDupatta6(username, addCart);
			model.addAttribute("smsg", "Product Added Successfully.........");// Save product associated with the user
			return "Clothes/KurtaDupatta6";
		} else {
			model.addAttribute("emsg", "Please Login First");
			return "Clothes/KurtaDupatta6";
		}
	}
	
	@GetMapping("/kurtaSetSubmit1")
	public String kurtaSet1(Model model, AddCart addCart, HttpServletRequest req) {
		HttpSession session = req.getSession(true);
		String username = (String) session.getAttribute("username");
		if (username != null) {
			addCartService.saveKurtaSet1(username, addCart);
			model.addAttribute("smsg", "Product Added Successfully.........");// Save product associated with the user
			return "Clothes/KurtaSet1";
		} else {
			model.addAttribute("emsg", "Please Login First");
			return "Clothes/KurtaSet1";
		}
	}

	@GetMapping("/kurtaSetSubmit2")
	public String kurtaSet2(Model model, AddCart addCart, HttpServletRequest req) {
		HttpSession session = req.getSession(true);
		String username = (String) session.getAttribute("username");
		if (username != null) {
			addCartService.saveKurtaSet2(username, addCart);
			model.addAttribute("smsg", "Product Added Successfully.........");// Save product associated with the user
			return "Clothes/KurtaSet2";
		} else {
			model.addAttribute("emsg", "Please Login First");
			return "Clothes/KurtaSet2";
		}
	}

	@GetMapping("/kurtaSetSubmit3")
	public String kurtaSet3(Model model, AddCart addCart, HttpServletRequest req) {
		HttpSession session = req.getSession(true);
		String username = (String) session.getAttribute("username");
		if (username != null) {
			addCartService.saveKurtaSet3(username, addCart);
			model.addAttribute("smsg", "Product Added Successfully.........");// Save product associated with the user
			return "Clothes/KurtaSet3";
		} else {
			model.addAttribute("emsg", "Please Login First");
			return "Clothes/KurtaSet3";
		}
	}

	@GetMapping("/kurtaSetSubmit4")
	public String kurtaSet4(Model model, AddCart addCart, HttpServletRequest req) {
		HttpSession session = req.getSession(true);
		String username = (String) session.getAttribute("username");
		if (username != null) {
			addCartService.saveKurtaSet4(username, addCart);
			model.addAttribute("smsg", "Product Added Successfully.........");// Save product associated with the user
			return "Clothes/KurtaSet4";
		} else {
			model.addAttribute("emsg", "Please Login First");
			return "Clothes/KurtaSet4";
		}
	}

	@GetMapping("/kurtaSetSubmit5")
	public String kurtaSet5(Model model, AddCart addCart, HttpServletRequest req) {
		HttpSession session = req.getSession(true);
		String username = (String) session.getAttribute("username");
		if (username != null) {
			addCartService.saveKurtaSet5(username, addCart);
			model.addAttribute("smsg", "Product Added Successfully.........");// Save product associated with the user
			return "Clothes/KurtaSet5";
		} else {
			model.addAttribute("emsg", "Please Login First");
			return "Clothes/KurtaSet5";
		}
	}

	@GetMapping("/kurtaSetSubmit6")
	public String kurtaSet6(Model model, AddCart addCart, HttpServletRequest req) {
		HttpSession session = req.getSession(true);
		String username = (String) session.getAttribute("username");
		if (username != null) {
			addCartService.saveKurtaSet6(username, addCart);
			model.addAttribute("smsg", "Product Added Successfully.........");// Save product associated with the user
			return "Clothes/KurtaSet6";
		} else {
			model.addAttribute("emsg", "Please Login First");
			return "Clothes/KurtaSet6";
		}
	}
}
