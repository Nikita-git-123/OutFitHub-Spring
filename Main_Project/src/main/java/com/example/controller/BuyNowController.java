package com.example.controller;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.entity.Customer;
import com.example.service.CustomerService;
import com.itextpdf.text.Document;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
public class BuyNowController {

	@Autowired
	private CustomerService customerService;

	@GetMapping("/codAnarkali1")
	public String codAnarkali1(HttpServletRequest req, Model model) {
		return "Bills/CodAnarkali1";
	}

	@GetMapping("/codAnarkali2")
	public String codAnarkali2(HttpServletRequest req, Model model) {
		return "Bills/CodAnarkali2";
	}

	@GetMapping("/codAnarkali3")
	public String codAnarkali3(HttpServletRequest req, Model model) {
		return "Bills/CodAnarkali3";
	}

	@GetMapping("/codAnarkali4")
	public String codAnarkali4(HttpServletRequest req, Model model) {
		return "Bills/CodAnarkali4";
	}

	@GetMapping("/codAnarkali5")
	public String codAnarkali5(HttpServletRequest req, Model model) {
		return "Bills/CodAnarkali5";
	}

	@GetMapping("/codAnarkali6")
	public String codAnarkali6(HttpServletRequest req, Model model) {
		return "Bills/CodAnarkali6";
	}

	@PostMapping("/billAnarkali1")
	public String billAnarkali1(@RequestParam String address, @RequestParam String name, @RequestParam String size,
			Model model, HttpServletRequest req) throws Exception {
		HttpSession session = req.getSession();
		String username = (String) session.getAttribute("username");
		String CustomerName = (String) session.getAttribute("CustomerName");
		Optional<Customer> byName = customerService.findByName(CustomerName);
		if (username == null) {
			model.addAttribute("emsg", "Please Login First...");
			System.out.println(username);
			System.out.println(byName);
		} else if (byName.isPresent()) {
			System.out.println(username);
			System.out.println(byName);
			model.addAttribute("smsg", "Product will be delivered soon...");
			ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
			Document document = new Document();
			PdfWriter.getInstance(document, byteArrayOutputStream);
			document.open();
			document.add(new Paragraph("Customer Details: "));
			document.add(new Paragraph("Customer Name: " + CustomerName)); // User name
			document.add(new Paragraph("Product Details: "));
			document.add(new Paragraph("Product Name:  Woman's Anarkali Set"));
			document.add(new Paragraph("Price: $314 "));
			document.add(new Paragraph("Product Size: " + size));
			document.add(new Paragraph("Shipping Address: " + address));
			document.close();
			ByteArrayInputStream bis = new ByteArrayInputStream(byteArrayOutputStream.toByteArray());
			InputStreamResource resource = new InputStreamResource(bis);
			session.setAttribute("pdfContent", byteArrayOutputStream);
			model.addAttribute("pdfGenerated", true);
		} else {
			System.out.println(username);
			System.out.println(byName);
			model.addAttribute("emsg", "User Not Found");

		}
		return "Bills/CodAnarkali1";
	}

	@GetMapping("/pdfAnarkali1")
	public ResponseEntity<InputStreamResource> pdfAnarkali1(HttpServletRequest req) throws Exception {

		// Retrieve the generated PDF from session or database
		ByteArrayOutputStream byteArrayOutputStream = (ByteArrayOutputStream) req.getSession()
				.getAttribute("pdfContent");
		if (byteArrayOutputStream == null) {
			// If no PDF content found, return a 404 Not Found error
			return ResponseEntity.status(404).body(null); // Not Found error
		}

		ByteArrayInputStream bis = new ByteArrayInputStream(byteArrayOutputStream.toByteArray());
		InputStreamResource resource = new InputStreamResource(bis);

		return ResponseEntity.ok().header("Content-Disposition", "attachment; filename=Bill.pdf")
				.contentType(org.springframework.http.MediaType.APPLICATION_PDF)
				.contentLength(byteArrayOutputStream.size()).body(resource);
	}

	@PostMapping("/billAnarkali2")
	public String billAnarkali2(@RequestParam String address, @RequestParam String name, @RequestParam String size,
			Model model, HttpServletRequest req) throws Exception {
		HttpSession session = req.getSession();
		String username = (String) session.getAttribute("username");
		String CustomerName = (String) session.getAttribute("CustomerName");
		Optional<Customer> byName = customerService.findByName(CustomerName);
		if (username == null) {
			model.addAttribute("emsg", "Please Login First...");
			System.out.println(username);
			System.out.println(byName);
		} else if (byName.isPresent()) {
			System.out.println(username);
			System.out.println(byName);
			model.addAttribute("smsg", "Product will be delivered soon...");
			ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
			Document document = new Document();
			PdfWriter.getInstance(document, byteArrayOutputStream);
			document.open();
			document.add(new Paragraph("Bill Details: "));
			document.add(new Paragraph("Customer Details: "));
			document.add(new Paragraph("Customer Name: " + CustomerName)); // User name
			document.add(new Paragraph("Product Details: "));
			document.add(new Paragraph("Product Name:  Woman's Crepe Anarkali Set"));
			document.add(new Paragraph("Price: $429 "));
			document.add(new Paragraph("Product Size: " + size));
			document.add(new Paragraph("Shipping Address: " + address));
			document.add(new Paragraph("Thank You!......."));
			document.close();
			ByteArrayInputStream bis = new ByteArrayInputStream(byteArrayOutputStream.toByteArray());
			InputStreamResource resource = new InputStreamResource(bis);
			session.setAttribute("pdfContent", byteArrayOutputStream);
			model.addAttribute("pdfGenerated", true);
		} else {
			System.out.println(username);
			System.out.println(byName);
			model.addAttribute("emsg", "User Not Found");

		}
		return "Bills/CodAnarkali2";
	}

	@GetMapping("/pdfAnarkali2")
	public ResponseEntity<InputStreamResource> pdfAnarkali2(HttpServletRequest req) throws Exception {

		// Retrieve the generated PDF from session or database
		ByteArrayOutputStream byteArrayOutputStream = (ByteArrayOutputStream) req.getSession()
				.getAttribute("pdfContent");
		if (byteArrayOutputStream == null) {
			// If no PDF content found, return a 404 Not Found error
			return ResponseEntity.status(404).body(null); // Not Found error
		}

		ByteArrayInputStream bis = new ByteArrayInputStream(byteArrayOutputStream.toByteArray());
		InputStreamResource resource = new InputStreamResource(bis);

		return ResponseEntity.ok().header("Content-Disposition", "attachment; filename=Bill.pdf")
				.contentType(org.springframework.http.MediaType.APPLICATION_PDF)
				.contentLength(byteArrayOutputStream.size()).body(resource);
	}

	@PostMapping("/billAnarkali3")
	public String billAnarkali3(@RequestParam String address, @RequestParam String name, @RequestParam String size,
			Model model, HttpServletRequest req) throws Exception {
		HttpSession session = req.getSession();
		String username = (String) session.getAttribute("username");
		String CustomerName = (String) session.getAttribute("CustomerName");
		Optional<Customer> byName = customerService.findByName(CustomerName);
		if (username == null) {
			model.addAttribute("emsg", "Please Login First...");
			System.out.println(username);
			System.out.println(byName);
		} else if (byName.isPresent()) {
			System.out.println(username);
			System.out.println(byName);
			model.addAttribute("smsg", "Product will be delivered soon...");
			ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
			Document document = new Document();
			PdfWriter.getInstance(document, byteArrayOutputStream);
			document.open();
			document.add(new Paragraph("Bill Details: "));
			document.add(new Paragraph("Customer Details: "));
			document.add(new Paragraph("Customer Name: " + CustomerName)); // User name
			document.add(new Paragraph("Product Details: "));
			document.add(new Paragraph("Product Name:  Woman's Anarkali Set"));
			document.add(new Paragraph("Price: $623 "));
			document.add(new Paragraph("Product Size: " + size));
			document.add(new Paragraph("Shipping Address: " + address));
			document.add(new Paragraph("Thank You!......."));
			document.close();
			ByteArrayInputStream bis = new ByteArrayInputStream(byteArrayOutputStream.toByteArray());
			InputStreamResource resource = new InputStreamResource(bis);
			session.setAttribute("pdfContent", byteArrayOutputStream);
			model.addAttribute("pdfGenerated", true);
		} else {
			System.out.println(username);
			System.out.println(byName);
			model.addAttribute("emsg", "User Not Found");

		}
		return "Bills/CodAnarkali3";
	}

	@GetMapping("/pdfAnarkali3")
	public ResponseEntity<InputStreamResource> pdfAnarkali3(HttpServletRequest req) throws Exception {

		// Retrieve the generated PDF from session or database
		ByteArrayOutputStream byteArrayOutputStream = (ByteArrayOutputStream) req.getSession()
				.getAttribute("pdfContent");
		if (byteArrayOutputStream == null) {
			// If no PDF content found, return a 404 Not Found error
			return ResponseEntity.status(404).body(null); // Not Found error
		}

		ByteArrayInputStream bis = new ByteArrayInputStream(byteArrayOutputStream.toByteArray());
		InputStreamResource resource = new InputStreamResource(bis);

		return ResponseEntity.ok().header("Content-Disposition", "attachment; filename=Bill.pdf")
				.contentType(org.springframework.http.MediaType.APPLICATION_PDF)
				.contentLength(byteArrayOutputStream.size()).body(resource);
	}

	@PostMapping("/billAnarkali4")
	public String billAnarkali4(@RequestParam String address, @RequestParam String name, @RequestParam String size,
			Model model, HttpServletRequest req) throws Exception {
		HttpSession session = req.getSession();
		String username = (String) session.getAttribute("username");
		String CustomerName = (String) session.getAttribute("CustomerName");
		Optional<Customer> byName = customerService.findByName(CustomerName);
		if (username == null) {
			model.addAttribute("emsg", "Please Login First...");
			System.out.println(username);
			System.out.println(byName);
		} else if (byName.isPresent()) {
			System.out.println(username);
			System.out.println(byName);
			model.addAttribute("smsg", "Product will be delivered soon...");
			ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
			Document document = new Document();
			PdfWriter.getInstance(document, byteArrayOutputStream);
			document.open();
			document.add(new Paragraph("Bill Details: "));
			document.add(new Paragraph("Customer Details: "));
			document.add(new Paragraph("Customer Name: " + CustomerName)); // User name
			document.add(new Paragraph("Product Details: "));
			document.add(new Paragraph("Product Name:  Woman's Anarkali Set"));
			document.add(new Paragraph("Price: $899 "));
			document.add(new Paragraph("Product Size: " + size));
			document.add(new Paragraph("Shipping Address: " + address));
			document.add(new Paragraph("Thank You!......."));
			document.close();
			ByteArrayInputStream bis = new ByteArrayInputStream(byteArrayOutputStream.toByteArray());
			InputStreamResource resource = new InputStreamResource(bis);
			session.setAttribute("pdfContent", byteArrayOutputStream);
			model.addAttribute("pdfGenerated", true);
		} else {
			System.out.println(username);
			System.out.println(byName);
			model.addAttribute("emsg", "User Not Found");

		}
		return "Bills/CodAnarkali4";
	}

	@GetMapping("/pdfAnarkali4")
	public ResponseEntity<InputStreamResource> pdfAnarkali4(HttpServletRequest req) throws Exception {

		// Retrieve the generated PDF from session or database
		ByteArrayOutputStream byteArrayOutputStream = (ByteArrayOutputStream) req.getSession()
				.getAttribute("pdfContent");
		if (byteArrayOutputStream == null) {
			// If no PDF content found, return a 404 Not Found error
			return ResponseEntity.status(404).body(null); // Not Found error
		}

		ByteArrayInputStream bis = new ByteArrayInputStream(byteArrayOutputStream.toByteArray());
		InputStreamResource resource = new InputStreamResource(bis);

		return ResponseEntity.ok().header("Content-Disposition", "attachment; filename=Bill.pdf")
				.contentType(org.springframework.http.MediaType.APPLICATION_PDF)
				.contentLength(byteArrayOutputStream.size()).body(resource);
	}

	@PostMapping("/billAnarkali5")
	public String billAnarkali5(@RequestParam String address, @RequestParam String name, @RequestParam String size,
			Model model, HttpServletRequest req) throws Exception {
		HttpSession session = req.getSession();
		String username = (String) session.getAttribute("username");
		String CustomerName = (String) session.getAttribute("CustomerName");
		Optional<Customer> byName = customerService.findByName(CustomerName);
		if (username == null) {
			model.addAttribute("emsg", "Please Login First...");
			System.out.println(username);
			System.out.println(byName);
		} else if (byName.isPresent()) {
			System.out.println(username);
			System.out.println(byName);
			model.addAttribute("smsg", "Product will be delivered soon...");
			ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
			Document document = new Document();
			PdfWriter.getInstance(document, byteArrayOutputStream);
			document.open();
			document.add(new Paragraph("Bill Details: "));
			document.add(new Paragraph("Customer Details: "));
			document.add(new Paragraph("Customer Name: " + CustomerName)); // User name
			document.add(new Paragraph("Product Details: "));
			document.add(new Paragraph("Product Name:  Woman's Cotton Anarkali Set"));
			document.add(new Paragraph("Price: $532 "));
			document.add(new Paragraph("Product Size: " + size));
			document.add(new Paragraph("Shipping Address: " + address));
			document.add(new Paragraph("Thank You!......."));
			document.close();
			ByteArrayInputStream bis = new ByteArrayInputStream(byteArrayOutputStream.toByteArray());
			InputStreamResource resource = new InputStreamResource(bis);
			session.setAttribute("pdfContent", byteArrayOutputStream);
			model.addAttribute("pdfGenerated", true);
		} else {
			System.out.println(username);
			System.out.println(byName);
			model.addAttribute("emsg", "User Not Found");

		}
		return "Bills/CodAnarkali5";
	}

	@GetMapping("/pdfAnarkali5")
	public ResponseEntity<InputStreamResource> pdfAnarkali5(HttpServletRequest req) throws Exception {

		// Retrieve the generated PDF from session or database
		ByteArrayOutputStream byteArrayOutputStream = (ByteArrayOutputStream) req.getSession()
				.getAttribute("pdfContent");
		if (byteArrayOutputStream == null) {
			// If no PDF content found, return a 404 Not Found error
			return ResponseEntity.status(404).body(null); // Not Found error
		}

		ByteArrayInputStream bis = new ByteArrayInputStream(byteArrayOutputStream.toByteArray());
		InputStreamResource resource = new InputStreamResource(bis);

		return ResponseEntity.ok().header("Content-Disposition", "attachment; filename=Bill.pdf")
				.contentType(org.springframework.http.MediaType.APPLICATION_PDF)
				.contentLength(byteArrayOutputStream.size()).body(resource);
	}

	@PostMapping("/billAnarkali6")
	public String billAnarkali6(@RequestParam String address, @RequestParam String name, @RequestParam String size,
			Model model, HttpServletRequest req) throws Exception {
		HttpSession session = req.getSession();
		String username = (String) session.getAttribute("username");
		String CustomerName = (String) session.getAttribute("CustomerName");
		Optional<Customer> byName = customerService.findByName(CustomerName);
		if (username == null) {
			model.addAttribute("emsg", "Please Login First...");
			System.out.println(username);
			System.out.println(byName);
		} else if (byName.isPresent()) {
			System.out.println(username);
			System.out.println(byName);
			model.addAttribute("smsg", "Product will be delivered soon...");
			ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
			Document document = new Document();
			PdfWriter.getInstance(document, byteArrayOutputStream);
			document.open();
			document.add(new Paragraph("Bill Details: "));
			document.add(new Paragraph("Customer Details: "));
			document.add(new Paragraph("Customer Name: " + CustomerName)); // User name
			document.add(new Paragraph("Product Details: "));
			document.add(new Paragraph("Product Name:  Woman's Crepe Anarkali Set"));
			document.add(new Paragraph("Price: $429 "));
			document.add(new Paragraph("Product Size: " + size));
			document.add(new Paragraph("Shipping Address: " + address));
			document.add(new Paragraph("Thank You!......."));
			document.close();
			ByteArrayInputStream bis = new ByteArrayInputStream(byteArrayOutputStream.toByteArray());
			InputStreamResource resource = new InputStreamResource(bis);
			session.setAttribute("pdfContent", byteArrayOutputStream);
			model.addAttribute("pdfGenerated", true);
		} else {
			System.out.println(username);
			System.out.println(byName);
			model.addAttribute("emsg", "User Not Found");

		}
		return "Bills/CodAnarkali6";
	}

	@GetMapping("/pdfAnarkali6")
	public ResponseEntity<InputStreamResource> pdfAnarkali6(HttpServletRequest req) throws Exception {

		// Retrieve the generated PDF from session or database
		ByteArrayOutputStream byteArrayOutputStream = (ByteArrayOutputStream) req.getSession()
				.getAttribute("pdfContent");
		if (byteArrayOutputStream == null) {
			// If no PDF content found, return a 404 Not Found error
			return ResponseEntity.status(404).body(null); // Not Found error
		}

		ByteArrayInputStream bis = new ByteArrayInputStream(byteArrayOutputStream.toByteArray());
		InputStreamResource resource = new InputStreamResource(bis);

		return ResponseEntity.ok().header("Content-Disposition", "attachment; filename=Bill.pdf")
				.contentType(org.springframework.http.MediaType.APPLICATION_PDF)
				.contentLength(byteArrayOutputStream.size()).body(resource);
	}
}
