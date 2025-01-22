package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entity.Product;
import com.example.repo.ProductRepository;

@Service
public class ProductService {

	@Autowired
	private ProductRepository productRepo;
	
	public List<Product> searchProducts(String query) {
		
		
		/*
		 * Product p1 = new Product(); p1.setName("Anarkali");
		 * 
		 * Product p2 = new Product(); p2.setName("AnarkaliDupatta");
		 * 
		 * Product p3 = new Product(); p3.setName("CordSet");
		 * 
		 * Product p4 = new Product(); p4.setName("KurtaDupatta");
		 * 
		 * Product p5 = new Product(); p5.setName("KurtaSet");
		 * 
		 * List<Product> asList = Arrays.asList(p1, p2, p3, p4, p5);
		 * productRepo.saveAll(asList);
		 */
		
        return productRepo.findByNameContainingIgnoreCase(query);
    }
	
}
