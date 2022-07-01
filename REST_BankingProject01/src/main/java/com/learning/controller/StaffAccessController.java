package com.learning.controller;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.MatrixVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.learning.entity.Customer;
import com.learning.service.CustomerService;

@RestController
@RequestMapping("/api/staff")
public class StaffAccessController {
	
	@Autowired
	CustomerService cService;
	
	//get all customers
	@GetMapping("/customer")
	public ResponseEntity<List<Customer>> getAllCustomer(){
		return new ResponseEntity<List<Customer>>(cService.getAllCustomer(), HttpStatus.valueOf(200));
	}
	
	//enable/disable status of Customer Login
	@PutMapping("/customer")
	public ResponseEntity<Object> changeStatus(@RequestBody Customer customer) {
		try {
			cService.getCustomer(customer.getCustomerId()).setStatus(customer.getStatus());
			return new ResponseEntity<Object>(cService.getCustomer(customer.getCustomerId()), HttpStatus.OK);
		} catch (NoSuchElementException e) {
			return new ResponseEntity<Object>("Customer status not changed", HttpStatus.NOT_FOUND);
		}
	}
	
	//get customer with id
	@GetMapping("/customer/{customerID}")
	public ResponseEntity<Object> getCustomer(@MatrixVariable(name = "customerID") Integer custID) {
		try {
			return new ResponseEntity<Object>(cService.getCustomer(custID), HttpStatus.OK);
		} catch (NoSuchElementException e) {
			return new ResponseEntity<Object>("Customer status not changed", HttpStatus.valueOf(403));
		}
	}
	
	//getStatement
	
	//approve beneficiary
	
	//list all accounts to be approved
	
	//list all accounts to be approved of specific customer
	
	//transaction
	
	
}
