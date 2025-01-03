package com.example.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.entity.Customer;

public interface CustomerRepo extends JpaRepository<Customer, Integer>{

	// public boolean secQnExists(String secQn);
	
	 Optional<Customer> findBySecQn(String secQn);
	
}
