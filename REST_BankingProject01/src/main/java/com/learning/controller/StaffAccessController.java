package com.learning.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.learning.entity.Customer;
import com.learning.service.CustomerService;

@RestController
@RequestMapping("/api/staff")
public class StaffAccessController {
	
	@Autowired
	CustomerService cService;
	
	@GetMapping("/customer")
	public ResponseEntity<List<Customer>> getAllCustomer(){
		return new ResponseEntity<List<Customer>>(cService.getAllCustomer(), HttpStatus.valueOf(200));
	}
	
	@PutMapping("/customer")
	public ResponseEntity<Object> changeStatus(@RequestBody Customer customer) {
		cService.getCustomer(customer.getCustomerId()).setStatus(customer.getStatus());
	}
	
}
