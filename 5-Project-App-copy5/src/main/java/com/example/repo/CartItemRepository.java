package com.example.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.entity.CartItem;

public interface CartItemRepository extends JpaRepository<CartItem, Long>{

	/*
	 * List<CartItem> findByUserId(Long userId); void
	 * deleteByUserIdAndProductId(Long userId, Long productId);
	 */
	 	 
}
