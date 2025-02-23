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
public class KurtaSetController {
	
	@Autowired
	private CustomerService customerService;

	@GetMapping("/codKurtaSet1")
	public String codKurtaSet1(HttpServletRequest req, Model model) {
		return "Bills/CodKurtaSet1";
	}

	@GetMapping("/codKurtaSet2")
	public String codKurtaSet2(HttpServletRequest req, Model model) {
		return "Bills/CodKurtaSet2";
	}

	@GetMapping("/codKurtaSet3")
	public String codKurtaSet3(HttpServletRequest req, Model model) {
		return "Bills/CodKurtaSet3";
	}

	@GetMapping("/codKurtaSet4")
	public String codKurtaSet4(HttpServletRequest req, Model model) {
		return "Bills/CodKurtaSet4";
	}

	@GetMapping("/codKurtaSet5")
	public String codKurtaSet5(HttpServletRequest req, Model model) {
		return "Bills/CodKurtaSet5";
	}

	@GetMapping("/codKurtaSet6")
	public String codKurtaSet6(HttpServletRequest req, Model model) {
		return "Bills/CodKurtaSet6";
	}

	@PostMapping("/billKurtaSet1")
	public String billKurtaSet1(@RequestParam String address, @RequestParam String name, @RequestParam String size,
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
			document.add(new Paragraph("Product Name:  Woman's Rayon Kurti With Plazzo"));
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
		return "Bills/CodKurtaSet1";
	}

	@GetMapping("/pdfKurtaSet1")
	public ResponseEntity<InputStreamResource> pdfKurtaSet1(HttpServletRequest req) throws Exception {

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

	@PostMapping("/billKurtaSet2")
	public String billKurtaSet2(@RequestParam String address, @RequestParam String name, @RequestParam String size,
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
			document.add(new Paragraph("Product Name:  Woman's Crepe Plazzo Set"));
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
		return "Bills/CodKurtaSet2";
	}

	@GetMapping("/pdfKurtaSet2")
	public ResponseEntity<InputStreamResource> pdfKurtaSet2(HttpServletRequest req) throws Exception {

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

	@PostMapping("/billKurtaSet3")
	public String billKurtaSet3(@RequestParam String address, @RequestParam String name, @RequestParam String size,
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
			document.add(new Paragraph("Product Name:  Woman's Cotton Kurti With Plazzo"));
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
		return "Bills/CodKurtaSet3";
	}

	@GetMapping("/pdfKurtaSet3")
	public ResponseEntity<InputStreamResource> pdfKurtaSet3(HttpServletRequest req) throws Exception {

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

	@PostMapping("/billKurtaSet4")
	public String billKurtaSet4(@RequestParam String address, @RequestParam String name, @RequestParam String size,
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
			document.add(new Paragraph("Product Name:  Woman's Cotton Kurti With Plazzo"));
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
		return "Bills/CodKurtaSet4";
	}

	@GetMapping("/pdfKurtaSet4")
	public ResponseEntity<InputStreamResource> pdfKurtaSet4(HttpServletRequest req) throws Exception {

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

	@PostMapping("/billKurtaSet5")
	public String billKurtaSet5(@RequestParam String address, @RequestParam String name, @RequestParam String size,
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
			document.add(new Paragraph("Product Name:  Woman's Khadi Cotton Kurti Set"));
			document.add(new Paragraph("Price: $365 "));
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
		return "Bills/CodKurtaSet5";
	}

	@GetMapping("/pdfKurtaSet5")
	public ResponseEntity<InputStreamResource> pdfKurtaSet5(HttpServletRequest req) throws Exception {

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

	@PostMapping("/billKurtaSet6")
	public String billKurtaSet6(@RequestParam String address, @RequestParam String name, @RequestParam String size,
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
			document.add(new Paragraph("Product Name:  Woman's Cotton Kurta Set"));
			document.add(new Paragraph("Price: $365 "));
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
		return "Bills/CodKurtaSet6";
	}

	@GetMapping("/pdfKurtaSet6")
	public ResponseEntity<InputStreamResource> pdfKurtaSet6(HttpServletRequest req) throws Exception {

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
