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
public class CordSetController {
	
	@Autowired
	private CustomerService customerService;

	@GetMapping("/codCordSet1")
	public String codCordSet1(HttpServletRequest req, Model model) {
		return "Bills/CodCordSet1";
	}

	@GetMapping("/codCordSet2")
	public String codCordSet2(HttpServletRequest req, Model model) {
		return "Bills/CodCordSet2";
	}

	@GetMapping("/codCordSet3")
	public String codCordSet3(HttpServletRequest req, Model model) {
		return "Bills/CodCordSet3";
	}

	@GetMapping("/codCordSet4")
	public String codCordSet4(HttpServletRequest req, Model model) {
		return "Bills/CodCordSet4";
	}

	@GetMapping("/codCordSet5")
	public String codCordSet5(HttpServletRequest req, Model model) {
		return "Bills/CodCordSet5";
	}

	@GetMapping("/codCordSet6")
	public String codCordSet6(HttpServletRequest req, Model model) {
		return "Bills/CodCordSet6";
	}

	@PostMapping("/billCordSet1")
	public String billCordSet1(@RequestParam String address, @RequestParam String name, @RequestParam String size,
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
			document.add(new Paragraph("Product Name:  Woman's Rayon Cord Set"));
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
		return "Bills/CodCordSet1";
	}

	@GetMapping("/pdfCordSet1")
	public ResponseEntity<InputStreamResource> pdfCordSet1(HttpServletRequest req) throws Exception {

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

	@PostMapping("/billCordSet2")
	public String billCordSet2(@RequestParam String address, @RequestParam String name, @RequestParam String size,
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
			document.add(new Paragraph("Product Name:  Woman's Crepe Cord Set"));
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
		return "Bills/CodCordSet2";
	}

	@GetMapping("/pdfCordSet2")
	public ResponseEntity<InputStreamResource> pdfCordSet2(HttpServletRequest req) throws Exception {

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

	@PostMapping("/billCordSet3")
	public String billCordSet3(@RequestParam String address, @RequestParam String name, @RequestParam String size,
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
			document.add(new Paragraph("Product Name:  Woman's  Cord Set"));
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
		return "Bills/CodCordSet3";
	}

	@GetMapping("/pdfCordSet3")
	public ResponseEntity<InputStreamResource> pdfCordSet3(HttpServletRequest req) throws Exception {

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

	@PostMapping("/billCordSet4")
	public String billCordSet4(@RequestParam String address, @RequestParam String name, @RequestParam String size,
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
			document.add(new Paragraph("Product Name:  Woman's Cord Set"));
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
		return "Bills/CodCordSet4";
	}

	@GetMapping("/pdfCordSet4")
	public ResponseEntity<InputStreamResource> pdfCordSet4(HttpServletRequest req) throws Exception {

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

	@PostMapping("/billCordSet5")
	public String billCordSet5(@RequestParam String address, @RequestParam String name, @RequestParam String size,
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
			document.add(new Paragraph("Product Name:  Woman's Khadi Cotton Cord Set"));
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
		return "Bills/CodCordSet5";
	}

	@GetMapping("/pdfCordSet5")
	public ResponseEntity<InputStreamResource> pdfCordSet5(HttpServletRequest req) throws Exception {

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

	@PostMapping("/billCordSet6")
	public String billCordSet6(@RequestParam String address, @RequestParam String name, @RequestParam String size,
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
			document.add(new Paragraph("Product Name:  Woman's Cotton Cord Set"));
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
		return "Bills/CodCordSet6";
	}

	@GetMapping("/pdfCordSet6")
	public ResponseEntity<InputStreamResource> pdfCordSet6(HttpServletRequest req) throws Exception {

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
