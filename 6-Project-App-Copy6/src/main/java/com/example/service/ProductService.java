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
		productRepo.save(new Product("AnarkaliSet"));
		productRepo.save(new Product("KurtaSet"));
		productRepo.save(new Product("CordSet"));
        return productRepo.findByNameContainingIgnoreCase(query);
    }
	
}
