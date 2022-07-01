package com.learning.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.learning.entity.Customer;

public class CustomerServiceImpl implements CustomerService {
	
	@Autowired
	CustomerRepo cRepo;
	
	@Override
	public Customer getCustomer(int id) {
		return cRepo.findBy;
	}

	@Override
	public Customer createCustomer(Customer customer) {
		return cRepo.save(customer);
	}

	@Override
	public Customer updateCustomer(Customer customer) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String deleteCustomer(int Customer) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Customer> getAllCustomer() {
		// TODO Auto-generated method stub
		return null;
	}

}
