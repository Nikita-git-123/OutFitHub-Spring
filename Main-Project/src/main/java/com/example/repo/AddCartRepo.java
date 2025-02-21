package com.example.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.entity.AddCart;
import com.example.entity.Customer;

public interface AddCartRepo extends JpaRepository<AddCart, Long>{
	
	
//	  @Query(value="SELECT * FROM cart_details WHERE customer_id = (SELECT id FROM user_registration WHERE username = 'Nikita1234');",
//	  nativeQuery = true)
	 
	List<AddCart> findByCustomerUsername(String username);
	
	 List<AddCart> findByCustomer(Customer customer);
	

}