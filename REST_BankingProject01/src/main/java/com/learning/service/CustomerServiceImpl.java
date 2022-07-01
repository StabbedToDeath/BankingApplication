package com.learning.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.learning.entity.Customer;
import com.learning.repo.CustomerRepo;

public class CustomerServiceImpl implements CustomerService {
	
	@Autowired
	CustomerRepo cRepo;
	
	@Override
	public Customer getCustomer(int customerId) {
		return cRepo.findById(customerId).get();
	}

	@Override
	public Customer createCustomer(Customer customer) {
		return cRepo.save(customer);
	}

	@Override
	public Customer updateCustomer(Customer customer) {
		return cRepo.save(customer);
	}

	@Override
	public String deleteCustomer(int Customer) {
		return null; //cRepo.deleteById(Customer);;
	}

	@Override
	public List<Customer> getAllCustomer() {
		// TODO Auto-generated method stub
		return null;
	}

}
