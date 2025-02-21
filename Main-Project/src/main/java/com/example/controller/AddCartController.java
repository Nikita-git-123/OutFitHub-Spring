package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.entity.AddCart;
import com.example.service.AddCartServiceImpl;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
public class AddCartController {

	@Autowired
	private AddCartServiceImpl addCartService;

	@GetMapping("/cart/{username}")
	public String getCartProducts(@PathVariable String username, HttpServletRequest req, Model model) {
		HttpSession session = req.getSession();
		String username1 = (String) session.getAttribute("username");
		if (username1 == null) {
			model.addAttribute("emsg", "Please Login First");
		} else {
			List<AddCart> allCarts = addCartService.getProducts(username1);
//			model.addAttribute("cart", new AddCart());
			model.addAttribute("carts", allCarts);
		}
		return "AddToCart";
	}

	@GetMapping("/deleteCart")
	public String deleteUser(@RequestParam Long srNo, Model model) {
		boolean status = addCartService.deleteUserBySrNo(srNo);
		return "Code";
	}

	@GetMapping("/anarkaliSubmit1")
	public String anarkali1(@RequestParam String username, Model model, AddCart addCart, HttpServletRequest req) {
		HttpSession session = req.getSession(true);
		String username1 = (String) session.getAttribute("username");
		if (username1 != null) {
			addCartService.saveAnarkali1(username, addCart); // Save product associated with the user
			return "AddToCart";
		}
		/*
		 * else { model.addAttribute("emsg", "Please Login First"); }
		 */

		return "Code";
	}

	@GetMapping("/anarkaliSubmit2")
	public String anarkali2(@RequestParam String username, AddCart addCart, HttpServletRequest req) {
		HttpSession session = req.getSession(true);
		String username1 = (String) session.getAttribute("username");
		if (username1 != null) {
			addCartService.saveAnarkali2(username, addCart); // Save product associated with the user
			return "AddToCart";
		}
		return "Code";
	}

	@GetMapping("/anarkaliSubmit3")
	public String anarkali3(@RequestParam String username, AddCart addCart, HttpServletRequest req) {
		HttpSession session = req.getSession(true);
		String username1 = (String) session.getAttribute("username");
		if (username1 != null) {
			addCartService.saveAnarkali3(username, addCart); // Save product associated with the user
			return "AddToCart";
		}
		return "Code";
	}

	@GetMapping("/anarkaliSubmit4")
	public String anarkali4(@RequestParam String username, AddCart addCart, HttpServletRequest req) {
		HttpSession session = req.getSession(true);
		String username1 = (String) session.getAttribute("username");
		if (username1 != null) {
			addCartService.saveAnarkali4(username, addCart); // Save product associated with the user
			return "AddToCart";
		}
		return "Code";
	}

	@GetMapping("/anarkaliSubmit5")
	public String anarkali5(@RequestParam String username, AddCart addCart, HttpServletRequest req) {
		HttpSession session = req.getSession(true);
		String username1 = (String) session.getAttribute("username");
		if (username1 != null) {
			addCartService.saveAnarkali5(username, addCart); // Save product associated with the user
			return "AddToCart";
		}
		return "Code";
	}

	@GetMapping("/anarkaliSubmit6")
	public String anarkali6(@RequestParam String username, AddCart addCart, HttpServletRequest req) {
		HttpSession session = req.getSession(true);
		String username1 = (String) session.getAttribute("username");
		if (username1 != null) {
			addCartService.saveAnarkali6(username, addCart); // Save product associated with the user
			return "AddToCart";
		}
		return "Code";
	}

	@GetMapping("/anarkaliDupattaSubmit1")
	public String anarkaliDupatta1(@RequestParam String username, AddCart addCart, HttpServletRequest req) {
		HttpSession session = req.getSession(true);
		String username1 = (String) session.getAttribute("username");
		if (username1 != null) {
			addCartService.saveAnarkaliDupatta1(username, addCart); // Save product associated with the user
			return "AddToCart";
		}
		return "Code";
	}

	@GetMapping("/anarkaliDupattaSubmit2")
	public String anarkaliDupatta2(@RequestParam String username, AddCart addCart, HttpServletRequest req) {
		HttpSession session = req.getSession(true);
		String username1 = (String) session.getAttribute("username");
		if (username1 != null) {
			addCartService.saveAnarkaliDupatta2(username, addCart); // Save product associated with the user
			return "AddToCart";
		}
		return "Code";
	}

	@GetMapping("/anarkaliDupattaSubmit3")
	public String anarkaliDupatta3(@RequestParam String username, AddCart addCart, HttpServletRequest req) {
		HttpSession session = req.getSession(true);
		String username1 = (String) session.getAttribute("username");
		if (username1 != null) {
			addCartService.saveAnarkaliDupatta3(username, addCart); // Save product associated with the user
			return "AddToCart";
		}
		return "Code";
	}

	@GetMapping("/anarkaliDupattaSubmit4")
	public String anarkaliDupatta4(@RequestParam String username, AddCart addCart, HttpServletRequest req) {
		HttpSession session = req.getSession(true);
		String username1 = (String) session.getAttribute("username");
		if (username1 != null) {
			addCartService.saveAnarkaliDupatta4(username, addCart); // Save product associated with the user
			return "AddToCart";
		}
		return "Code";
	}

	@GetMapping("/anarkaliDupattaSubmit5")
	public String anarkaliDupatta5(@RequestParam String username, AddCart addCart, HttpServletRequest req) {
		HttpSession session = req.getSession(true);
		String username1 = (String) session.getAttribute("username");
		if (username1 != null) {
			addCartService.saveAnarkaliDupatta5(username, addCart); // Save product associated with the user
			return "AddToCart";
		}
		return "Code";
	}

	@GetMapping("/anarkaliDupattaSubmit6")
	public String anarkaliDupatta6(@RequestParam String username, AddCart addCart, HttpServletRequest req) {
		HttpSession session = req.getSession(true);
		String username1 = (String) session.getAttribute("username");
		if (username1 != null) {
			addCartService.saveAnarkaliDupatta6(username, addCart); // Save product associated with the user
			return "AddToCart";
		}
		return "Code";
	}

	@GetMapping("/anarkaliDupattaSubmit7")
	public String anarkaliDupatta7(@RequestParam String username, AddCart addCart, HttpServletRequest req) {
		HttpSession session = req.getSession(true);
		String username1 = (String) session.getAttribute("username");
		if (username1 != null) {
			addCartService.saveAnarkaliDupatta7(username, addCart); // Save product associated with the user
			return "AddToCart";
		}
		return "Code";
	}

	@GetMapping("/anarkaliDupattaSubmit8")
	public String anarkaliDupatta8(@RequestParam String username, AddCart addCart, HttpServletRequest req) {
		HttpSession session = req.getSession(true);
		String username1 = (String) session.getAttribute("username");
		if (username1 != null) {
			addCartService.saveAnarkaliDupatta8(username, addCart); // Save product associated with the user
			return "AddToCart";
		}
		return "Code";
	}
	
	@GetMapping("/cordSetSubmit1")
	public String cordSet1(@RequestParam String username, AddCart addCart, HttpServletRequest req) {
		HttpSession session = req.getSession(true);
		String username1 = (String) session.getAttribute("username");
		if (username1 != null) {
			addCartService.saveCordSet1(username, addCart); // Save product associated with the user
			return "AddToCart";
		}
		return "Code";
	}

	@GetMapping("/cordSetSubmit2")
	public String cordSet2(@RequestParam String username, AddCart addCart, HttpServletRequest req) {
		HttpSession session = req.getSession(true);
		String username1 = (String) session.getAttribute("username");
		if (username1 != null) {
			addCartService.saveCordSet2(username, addCart); // Save product associated with the user
			return "AddToCart";
		}
		return "Code";
	}

	@GetMapping("/cordSetSubmit3")
	public String cordSet3(@RequestParam String username, AddCart addCart, HttpServletRequest req) {
		HttpSession session = req.getSession(true);
		String username1 = (String) session.getAttribute("username");
		if (username1 != null) {
			addCartService.saveCordSet3(username, addCart); // Save product associated with the user
			return "AddToCart";
		}
		return "Code";
	}

	@GetMapping("/cordSetSubmit4")
	public String cordSet4(@RequestParam String username, AddCart addCart, HttpServletRequest req) {
		HttpSession session = req.getSession(true);
		String username1 = (String) session.getAttribute("username");
		if (username1 != null) {
			addCartService.saveCordSet4(username, addCart); // Save product associated with the user
			return "AddToCart";
		}
		return "Code";
	}

	@GetMapping("/cordSetSubmit5")
	public String cordSet5(@RequestParam String username, AddCart addCart, HttpServletRequest req) {
		HttpSession session = req.getSession(true);
		String username1 = (String) session.getAttribute("username");
		if (username1 != null) {
			addCartService.saveCordSet5(username, addCart); // Save product associated with the user
			return "AddToCart";
		}
		return "Code";
	}
	
	@GetMapping("/cordSetSubmit6")
	public String cordSet6(@RequestParam String username, AddCart addCart, HttpServletRequest req) {
		HttpSession session = req.getSession(true);
		String username1 = (String) session.getAttribute("username");
		if (username1 != null) {
			addCartService.saveCordSet6(username, addCart); // Save product associated with the user
			return "AddToCart";
		}
		return "Code";
	}
	
	@GetMapping("/kurtaDupattaSubmit1")
	public String kurtaDupattaa1(@RequestParam String username, AddCart addCart, HttpServletRequest req) {
		HttpSession session = req.getSession(true);
		String username1 = (String) session.getAttribute("username");
		if (username1 != null) {
			addCartService.saveKurtaDupatta1(username, addCart); // Save product associated with the user
			return "AddToCart";
		}
		return "Code";
	}

	@GetMapping("/kurtaDupattaSubmit2")
	public String kurtaDupattaa2(@RequestParam String username, AddCart addCart, HttpServletRequest req) {
		HttpSession session = req.getSession(true);
		String username1 = (String) session.getAttribute("username");
		if (username1 != null) {
			addCartService.saveKurtaDupatta2(username, addCart); // Save product associated with the user
			return "AddToCart";
		}
		return "Code";
	}

	@GetMapping("/kurtaDupattaSubmit3")
	public String kurtaDupattaa3(@RequestParam String username, AddCart addCart, HttpServletRequest req) {
		HttpSession session = req.getSession(true);
		String username1 = (String) session.getAttribute("username");
		if (username1 != null) {
			addCartService.saveKurtaDupatta3(username, addCart); // Save product associated with the user
			return "AddToCart";
		}
		return "Code";
	}

	@GetMapping("/kurtaDupattaSubmit4")
	public String kurtaDupattaa4(@RequestParam String username, AddCart addCart, HttpServletRequest req) {
		HttpSession session = req.getSession(true);
		String username1 = (String) session.getAttribute("username");
		if (username1 != null) {
			addCartService.saveKurtaDupatta4(username, addCart); // Save product associated with the user
			return "AddToCart";
		}
		return "Code";
	}

	@GetMapping("/kurtaDupattaSubmit5")
	public String kurtaDupattaa5(@RequestParam String username, AddCart addCart, HttpServletRequest req) {
		HttpSession session = req.getSession(true);
		String username1 = (String) session.getAttribute("username");
		if (username1 != null) {
			addCartService.saveKurtaDupatta5(username, addCart); // Save product associated with the user
			return "AddToCart";
		}
		return "Code";
	}

	@GetMapping("/kurtaDupattaSubmit6")
	public String kurtaDupattaa6(@RequestParam String username, AddCart addCart, HttpServletRequest req) {
		HttpSession session = req.getSession(true);
		String username1 = (String) session.getAttribute("username");
		if (username1 != null) {
			addCartService.saveKurtaDupatta6(username, addCart); // Save product associated with the user
			return "AddToCart";
		}
		return "Code";
	}
	
	@GetMapping("/kurtaSetSubmit1")
	public String kurtaSet1(@RequestParam String username, AddCart addCart, HttpServletRequest req) {
		HttpSession session = req.getSession(true);
		String username1 = (String) session.getAttribute("username");
		if (username1 != null) {
			addCartService.saveKurtaSet1(username, addCart); // Save product associated with the user
			return "AddToCart";
		}
		return "Code";
	}

	@GetMapping("/kurtaSetSubmit2")
	public String kurtaSet2(@RequestParam String username, AddCart addCart, HttpServletRequest req) {
		HttpSession session = req.getSession(true);
		String username1 = (String) session.getAttribute("username");
		if (username1 != null) {
			addCartService.saveKurtaSet2(username, addCart); // Save product associated with the user
			return "AddToCart";
		}
		return "Code";
	}

	@GetMapping("/kurtaSetSubmit3")
	public String kurtaSet3(@RequestParam String username, AddCart addCart, HttpServletRequest req) {
		HttpSession session = req.getSession(true);
		String username1 = (String) session.getAttribute("username");
		if (username1 != null) {
			addCartService.saveKurtaSet3(username, addCart); // Save product associated with the user
			return "AddToCart";
		}
		return "Code";
	}

	@GetMapping("/kurtaSetSubmit4")
	public String kurtaSet4(@RequestParam String username, AddCart addCart, HttpServletRequest req) {
		HttpSession session = req.getSession(true);
		String username1 = (String) session.getAttribute("username");
		if (username1 != null) {
			addCartService.saveKurtaSet4(username, addCart); // Save product associated with the user
			return "AddToCart";
		}
		return "Code";
	}

	@GetMapping("/kurtaSetSubmit5")
	public String kurtaSet5(@RequestParam String username, AddCart addCart, HttpServletRequest req) {
		HttpSession session = req.getSession(true);
		String username1 = (String) session.getAttribute("username");
		if (username1 != null) {
			addCartService.saveKurtaSet5(username, addCart); // Save product associated with the user
			return "AddToCart";
		}
		return "Code";
	}

	@GetMapping("/kurtaSetSubmit6")
	public String kurtaSet6(@RequestParam String username, AddCart addCart, HttpServletRequest req) {
		HttpSession session = req.getSession(true);
		String username1 = (String) session.getAttribute("username");
		if (username1 != null) {
			addCartService.saveKurtaSet6(username, addCart); // Save product associated with the user
			return "AddToCart";
		}
		return "Code";
	}
}
