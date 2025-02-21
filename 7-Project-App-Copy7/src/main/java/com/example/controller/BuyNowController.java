package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.service.BuyNowService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
public class BuyNowController {
	
	@Autowired
	private BuyNowService buyNowService;
	
	@GetMapping("/codPage")
	public String anarkali1(HttpServletRequest req, Model model) {
		/*
		 * HttpSession session = req.getSession(); String username1 = (String)
		 * session.getAttribute("username"); if (username1 == null) {
		 * model.addAttribute("emsg", "Please Login First"); }
		 */
		return "CodPage";
	}

	@PostMapping("/generateBillPdf")
	public String billAnarkali1(@RequestParam String address, Model model,
			HttpServletRequest req) throws Exception {
		HttpSession session = req.getSession();
		String username1 = (String) session.getAttribute("username");
		if (username1 == null) {
			model.addAttribute("emsg", "Please Login First");
		}
		else {
			buyNowService.pdfAnarkali1(address, username1);
			model.addAttribute("smsg", "Product will be delivered soon...");
		}
		return "CodPage";
	}
}
