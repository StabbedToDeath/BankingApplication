package com.learning.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.learning.entity.Customer;
import com.learning.service.CustomerService;

@RestController
@RequestMapping("/api/customer")
public class CustomerAccessController {
	
	@Autowired
	CustomerService cService;
	
	@PostMapping("/register")
	public ResponseEntity<Customer> registerCustomer(@RequestBody Customer customer){
		cService.createCustomer(customer);
		return new ResponseEntity<Customer>(customer, HttpStatus.valueOf(201));
	}
	
}
