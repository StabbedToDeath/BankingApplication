package com.learning.service;

import java.util.List;

import com.learning.entity.Customer;

public interface CustomerService {
	//simple interface
	public Customer getCustomer(int customerId);
	public Customer createCustomer(Customer customer);
	public Customer updateCustomer(Customer customer);
	public String deleteCustomer(int customerId);
	public List<Customer> getAllCustomer();

}
