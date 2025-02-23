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
public class KurtaDupattaController {
	
	@Autowired
	private CustomerService customerService;

	@GetMapping("/codKurtaDupatta1")
	public String codKurtaDupatta1(HttpServletRequest req, Model model) {
		return "Bills/CodKurtaDupatta1";
	}

	@GetMapping("/codKurtaDupatta2")
	public String codKurtaDupatta2(HttpServletRequest req, Model model) {
		return "Bills/CodKurtaDupatta2";
	}

	@GetMapping("/codKurtaDupatta3")
	public String codKurtaDupatta3(HttpServletRequest req, Model model) {
		return "Bills/CodKurtaDupatta3";
	}

	@GetMapping("/codKurtaDupatta4")
	public String codKurtaDupatta4(HttpServletRequest req, Model model) {
		return "Bills/CodKurtaDupatta4";
	}

	@GetMapping("/codKurtaDupatta5")
	public String codKurtaDupatta5(HttpServletRequest req, Model model) {
		return "Bills/CodKurtaDupatta5";
	}

	@GetMapping("/codKurtaDupatta6")
	public String codKurtaDupatta6(HttpServletRequest req, Model model) {
		return "Bills/CodKurtaDupatta6";
	}

	@PostMapping("/billKurtaDupatta1")
	public String billKurtaDupatta1(@RequestParam String address, @RequestParam String name, @RequestParam String size,
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
			document.add(new Paragraph("Product Name:  Woman's Rayon Kurti With Dupatta"));
			document.add(new Paragraph("Price: $365 "));
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
		return "Bills/CodKurtaDupatta1";
	}

	@GetMapping("/pdfKurtaDupatta1")
	public ResponseEntity<InputStreamResource> pdfKurtaDupatta1(HttpServletRequest req) throws Exception {

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

	@PostMapping("/billKurtaDupatta2")
	public String billKurtaDupatta2(@RequestParam String address, @RequestParam String name, @RequestParam String size,
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
			document.add(new Paragraph("Product Name:  Woman's Crepe Kurti With Dupatta"));
			document.add(new Paragraph("Price: $299 "));
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
		return "Bills/CodKurtaDupatta2";
	}

	@GetMapping("/pdfKurtaDupatta2")
	public ResponseEntity<InputStreamResource> pdfKurtaDupatta2(HttpServletRequest req) throws Exception {

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

	@PostMapping("/billKurtaDupatta3")
	public String billKurtaDupatta3(@RequestParam String address, @RequestParam String name, @RequestParam String size,
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
			document.add(new Paragraph("Product Name:  Woman's Cotton Kurti Set"));
			document.add(new Paragraph("Price: $319 "));
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
		return "Bills/CodKurtaDupatta3";
	}

	@GetMapping("/pdfKurtaDupatta3")
	public ResponseEntity<InputStreamResource> pdfKurtaDupatta3(HttpServletRequest req) throws Exception {

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

	@PostMapping("/billKurtaDupatta4")
	public String billKurtaDupatta4(@RequestParam String address, @RequestParam String name, @RequestParam String size,
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
			document.add(new Paragraph("Product Name:  Woman's Kurti With Dupatta"));
			document.add(new Paragraph("Price: $423 "));
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
		return "Bills/CodKurtaDupatta4";
	}

	@GetMapping("/pdfKurtaDupatta4")
	public ResponseEntity<InputStreamResource> pdfKurtaDupatta4(HttpServletRequest req) throws Exception {

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

	@PostMapping("/billKurtaDupatta5")
	public String billKurtaDupatta5(@RequestParam String address, @RequestParam String name, @RequestParam String size,
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
			document.add(new Paragraph("Product Name:  Woman's Khadi Cotton Set"));
			document.add(new Paragraph("Price: $308 "));
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
		return "Bills/CodKurtaDupatta5";
	}

	@GetMapping("/pdfKurtaDupatta5")
	public ResponseEntity<InputStreamResource> pdfKurtaDupatta5(HttpServletRequest req) throws Exception {

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

	@PostMapping("/billKurtaDupatta6")
	public String billKurtaDupatta6(@RequestParam String address, @RequestParam String name, @RequestParam String size,
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
			document.add(new Paragraph("Product Name:  Woman's Cotton Dupatta Set"));
			document.add(new Paragraph("Price: $408 "));
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
		return "Bills/CodKurtaDupatta6";
	}

	@GetMapping("/pdfKurtaDupatta6")
	public ResponseEntity<InputStreamResource> pdfKurtaDupatta6(HttpServletRequest req) throws Exception {

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
