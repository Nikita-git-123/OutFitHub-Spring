package com.example.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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

	@ManyToOne
	@JoinColumn(name = "id", referencedColumnName = "id") // Foreign key in AddToCart table to reference Customer
	private Customer customer;
}
