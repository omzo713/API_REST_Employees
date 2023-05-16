package com.example.demo.model;

import jakarta.persistence.Column;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

import lombok.Data;



@Entity
@Table(name="employees")

 public @Data class Employee {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	
	private Long id;
	
	@Column (name="fisrt_name")
	private String firstName;
	
	@Column (name="last_name")
	private String lastName;
	
	private String mail;
	
	private String password;

	
}
