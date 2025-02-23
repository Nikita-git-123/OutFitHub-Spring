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
public class ADupattaController {

	@Autowired
	private CustomerService customerService;

	@GetMapping("/codAnarkaliDupatta1")
	public String codAnarkaliDupatta1(HttpServletRequest req, Model model) {
		return "Bills/CodAnarkaliDupatta1";
	}

	@GetMapping("/codAnarkaliDupatta2")
	public String codAnarkaliDupatta2(HttpServletRequest req, Model model) {
		return "Bills/CodAnarkaliDupatta2";
	}

	@GetMapping("/codAnarkaliDupatta3")
	public String codAnarkaliDupatta3(HttpServletRequest req, Model model) {
		return "Bills/CodAnarkaliDupatta3";
	}

	@GetMapping("/codAnarkaliDupatta4")
	public String codAnarkaliDupatta4(HttpServletRequest req, Model model) {
		return "Bills/CodAnarkaliDupatta4";
	}

	@GetMapping("/codAnarkaliDupatta5")
	public String codAnarkaliDupatta5(HttpServletRequest req, Model model) {
		return "Bills/CodAnarkaliDupatta5";
	}

	@GetMapping("/codAnarkaliDupatta6")
	public String codAnarkaliDupatta6(HttpServletRequest req, Model model) {
		return "Bills/CodAnarkaliDupatta6";
	}

	@GetMapping("/codAnarkaliDupatta7")
	public String codAnarkaliDupatta7(HttpServletRequest req, Model model) {
		return "Bills/CodAnarkaliDupatta7";
	}

	@GetMapping("/codAnarkaliDupatta8")
	public String codAnarkaliDupatta8(HttpServletRequest req, Model model) {
		return "Bills/CodAnarkaliDupatta8";
	}

	@PostMapping("/billAnarkaliDupatta1")
	public String billAnarkaliDupatta1(@RequestParam String address, @RequestParam String name,
			@RequestParam String size, Model model, HttpServletRequest req) throws Exception {
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
			document.add(new Paragraph("Price: $540 "));
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
		return "Bills/CodAnarkaliDupatta1";
	}

	@GetMapping("/pdfAnarkaliDupatta1")
	public ResponseEntity<InputStreamResource> pdfAnarkaliDupatta1(HttpServletRequest req) throws Exception {

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

	@PostMapping("/billAnarkaliDupatta2")
	public String billAnarkaliDupatta2(@RequestParam String address, @RequestParam String name,
			@RequestParam String size, Model model, HttpServletRequest req) throws Exception {
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
			document.add(new Paragraph("Price: $366 "));
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
		return "Bills/CodAnarkaliDupatta2";
	}

	@GetMapping("/pdfAnarkaliDupatta2")
	public ResponseEntity<InputStreamResource> pdfAnarkaliDupatta2(HttpServletRequest req) throws Exception {

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

	@PostMapping("/billAnarkaliDupatta3")
	public String billAnarkaliDupatta3(@RequestParam String address, @RequestParam String name,
			@RequestParam String size, Model model, HttpServletRequest req) throws Exception {
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
			document.add(new Paragraph("Price: $580 "));
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
		return "Bills/CodAnarkaliDupatta3";
	}

	@GetMapping("/pdfAnarkaliDupatta3")
	public ResponseEntity<InputStreamResource> pdfAnarkaliDupatta3(HttpServletRequest req) throws Exception {

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

	@PostMapping("/billAnarkaliDupatta4")
	public String billAnarkaliDupatta4(@RequestParam String address, @RequestParam String name,
			@RequestParam String size, Model model, HttpServletRequest req) throws Exception {
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
			document.add(new Paragraph("Price: $699 "));
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
		return "Bills/CodAnarkaliDupatta4";
	}

	@GetMapping("/pdfAnarkaliDupatta4")
	public ResponseEntity<InputStreamResource> pdfAnarkaliDupatta4(HttpServletRequest req) throws Exception {

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

	@PostMapping("/billAnarkaliDupatta5")
	public String billAnarkaliDupatta5(@RequestParam String address, @RequestParam String name,
			@RequestParam String size, Model model, HttpServletRequest req) throws Exception {
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
			document.add(new Paragraph("Product Name:  Woman's Organza Anarkali Set"));
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
		return "Bills/CodAnarkaliDupatta5";
	}

	@GetMapping("/pdfAnarkaliDupatta5")
	public ResponseEntity<InputStreamResource> pdfAnarkaliDupatta5(HttpServletRequest req) throws Exception {

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

	@PostMapping("/billAnarkaliDupatta6")
	public String billAnarkaliDupatta6(@RequestParam String address, @RequestParam String name,
			@RequestParam String size, Model model, HttpServletRequest req) throws Exception {
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
			document.add(new Paragraph("Product Name:  Woman's Party Wear Anarkali Set"));
			document.add(new Paragraph("Price: $666 "));
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
		return "Bills/CodAnarkaliDupatta6";
	}

	@GetMapping("/pdfAnarkaliDupatta6")
	public ResponseEntity<InputStreamResource> pdfAnarkaliDupatta6(HttpServletRequest req) throws Exception {

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

	@PostMapping("/billAnarkaliDupatta7")
	public String billAnarkaliDupatta7(@RequestParam String address, @RequestParam String name,
			@RequestParam String size, Model model, HttpServletRequest req) throws Exception {
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
			document.add(new Paragraph("Product Name:  Woman's Organza Anarkali Set"));
			document.add(new Paragraph("Price: $670 "));
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
		return "Bills/CodAnarkaliDupatta7";
	}

	@GetMapping("/pdfAnarkaliDupatta7")
	public ResponseEntity<InputStreamResource> pdfAnarkaliDupatta7(HttpServletRequest req) throws Exception {

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

	@PostMapping("/billAnarkaliDupatta8")
	public String billAnarkaliDupatta8(@RequestParam String address, @RequestParam String name,
			@RequestParam String size, Model model, HttpServletRequest req) throws Exception {
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
			document.add(new Paragraph("Product Name:  Woman's Party Wear Anarkali Set"));
			document.add(new Paragraph("Price: $780 "));
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
		return "Bills/CodAnarkaliDupatta8";
	}

	@GetMapping("/pdfAnarkaliDupatta8")
	public ResponseEntity<InputStreamResource> pdfAnarkaliDupatta8(HttpServletRequest req) throws Exception {

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
