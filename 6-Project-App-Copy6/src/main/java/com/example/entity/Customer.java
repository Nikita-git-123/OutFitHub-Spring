package com.example.entity;

import java.time.LocalDate;
import java.util.List;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
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
	
	@OneToMany(mappedBy = "customer")
	private List<AddCart> addCart;
	

}
