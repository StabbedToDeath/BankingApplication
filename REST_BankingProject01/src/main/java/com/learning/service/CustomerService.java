package com.learning.service;

import java.util.List;

import com.learning.entity.Customer;

public interface CustomerService {
	//simple interface
	public Customer getCustomer(int id);
	
	public Customer createCustomer(Customer customer);
	
	public Customer updateCustomer(Customer customer);
	
	public String deleteCustomer(int id);
	
	public List<Customer> getAllCustomer();
	
	public Customer getCustomerByUsername(String username);
}
