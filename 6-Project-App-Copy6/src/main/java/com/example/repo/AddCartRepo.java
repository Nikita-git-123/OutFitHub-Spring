package com.example.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.entity.AddCart;

public interface AddCartRepo extends JpaRepository<AddCart, Long>{
	
	/*
	 * @Query(value="select * from Cart_Details where username = :username",
	 * nativeQuery = true)
	 */
	List<AddCart> findByCustomerUsername(String username);

}
