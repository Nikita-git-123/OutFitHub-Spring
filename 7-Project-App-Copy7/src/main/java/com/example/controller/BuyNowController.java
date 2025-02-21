package com.example.controller;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.service.BuyNowService;
import com.itextpdf.text.Document;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

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
	public ResponseEntity<InputStreamResource> billAnarkali1(@RequestParam String address, Model model,
			HttpServletRequest req) throws Exception {
		HttpSession session = req.getSession();
		String username1 = (String) session.getAttribute("username");

		if (username1 == null) {
			model.addAttribute("emsg", "Please Login First");
		}

		model.addAttribute("smsg", "Product will be delivered soon...");
		ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();

		Document document = new Document();
		PdfWriter.getInstance(document, byteArrayOutputStream);

		document.open();
		document.add(new Paragraph("Product Details"));
		document.add(new Paragraph("Product Name:  Woman's Anarkali Set"));
		document.add(new Paragraph("Price: $314 "));
		document.add(new Paragraph("Shipping Address: " + address));
		document.close();

		ByteArrayInputStream bis = new ByteArrayInputStream(byteArrayOutputStream.toByteArray());

		InputStreamResource resource = new InputStreamResource(bis);

		return ResponseEntity.ok().header("Content-Disposition", "attachment;filename=Bill.pdf")
				.contentType(org.springframework.http.MediaType.APPLICATION_PDF)
				.contentLength(byteArrayOutputStream.size()).body(resource);

	}
}
