package com.example.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.entity.Customer;

public interface CustomerRepo extends JpaRepository<Customer, Integer>{
	
	Optional<Customer> findBySecQn(String secQn);
	
	Optional<Customer> findByUsernameAndPassword1(String username, String password1);
	
	Customer findByUsername(String username);
		
}
