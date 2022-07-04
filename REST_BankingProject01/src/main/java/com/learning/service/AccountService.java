package com.learning.service;

import java.util.List;

import com.learning.entity.Account;
import com.learning.entity.Customer;

public interface AccountService {

	public Account getAccount(int id);
	
	public Account createAccount(Account account);
	
	public Account updateAccount(Account account);
	
	public String deleteAccount(int id);
	
	public List<Account> getAllAccount();
	
	public List<Account> getApprovedAccounts(String approved);
	
	
}
