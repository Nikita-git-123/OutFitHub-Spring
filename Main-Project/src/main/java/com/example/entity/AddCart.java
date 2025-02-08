package com.example.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="Cart_Details")
public class AddCart {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long srNo;
	private String name;
	private Double price;
	
}
