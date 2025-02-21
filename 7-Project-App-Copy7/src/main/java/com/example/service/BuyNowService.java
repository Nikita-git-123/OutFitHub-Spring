package com.example.service;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.entity.Customer;
import com.example.repo.AddCartRepo;
import com.example.repo.CustomerRepo;
import com.itextpdf.text.Document;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

@Service
public class BuyNowService {
	
	@Autowired
	private AddCartRepo addCartRepo;

	@Autowired
	private CustomerRepo customerRepo;
	
	public ResponseEntity<InputStreamResource> pdfAnarkali1(@RequestParam String address, String username) throws Exception {
		Customer customer = customerRepo.findByUsername(username);

		ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
		Document document = new Document();
		PdfWriter.getInstance(document, byteArrayOutputStream);

		document.open();
		document.add(new Paragraph("Product Details"));
		document.add(new Paragraph("Product Name:  Woman's Anarkali Set" ));
        document.add(new Paragraph("Price: $314 " ));
		document.add(new Paragraph("Shipping Address: " + address));
		document.close();

		ByteArrayInputStream bis = new ByteArrayInputStream(byteArrayOutputStream.toByteArray());

		InputStreamResource resource = new InputStreamResource(bis);

		return ResponseEntity.ok().header("Content-Disposition", "attachment;filename=Bill.pdf")
				.contentType(org.springframework.http.MediaType.APPLICATION_PDF)
				.contentLength(byteArrayOutputStream.size()).body(resource);
	}

}
