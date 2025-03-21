package com.example.entity;

import java.time.LocalDate;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name="User_Registration")
public class Customer {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String name;
	private String email;
	private Long phno;
	private String secQn;
	private String username;
	private String password1;
	private String password2;
	
	@CreationTimestamp
	@Column(updatable = false)
	private LocalDate registeredAt;
	
	@UpdateTimestamp
	@Column(insertable = false)
	private LocalDate updatedAt;
	

}
