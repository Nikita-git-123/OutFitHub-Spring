package com.example.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.entity.Customer;
import com.example.repo.CustomerRepo;

@Service
public class CustomerService {
	
	@Autowired
	private CustomerRepo customerRepo;

	public boolean saveCustomer(Customer customer) {
		Customer savedCustomer = customerRepo.save(customer);
		return savedCustomer.getId() != null;
	}

	public boolean findBySecQn(String secQn) {
		Optional<Customer> bySecQn = customerRepo.findBySecQn(secQn);
		return bySecQn.map(securityQuestion -> securityQuestion.getSecQn().equals(secQn)).orElse(false);
	}
	
	public Optional<Customer> findByUsernameAndPassword1(String username, String password1) {
		return customerRepo.findByUsernameAndPassword1(username, password1);
	}
	
	public Optional<Customer> findByName(String name) {
		return customerRepo.findByName(name);
	}
	
}
