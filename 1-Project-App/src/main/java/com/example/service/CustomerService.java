package com.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entity.Customer;
import com.example.repo.CustomerRepo;

@Service
public class CustomerService {

	@Autowired
	private CustomerRepo customerRepo;
	
	public boolean saveCustomer(Customer customer) {
		
		/*
		 * Customer customer = new Customer(); customer.setName("Nikita");
		 * customer.setEmail("abc@gmail.com"); customer.setPassword("abc");
		 * customer.setPhno(124567l); customer.setSecQn("tommy");
		 * customer.setUsername("niku123");
		 */
		
		Customer savedCustomer = customerRepo.save(customer);	
		System.out.println("Saved ...... " + savedCustomer);
		return savedCustomer.getId() != null;

	}

}