package com.example.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.entity.Customer;

public interface CustomerRepo extends JpaRepository<Customer, Integer>{
	
	Customer findByEmail(String email);
	
	Optional<Customer> findByUsernameAndPassword1(String username, String password1);
		
}
