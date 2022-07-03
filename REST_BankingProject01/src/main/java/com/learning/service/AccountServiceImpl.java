package com.learning.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.learning.entity.Account;
import com.learning.repo.AccountRepo;


@Service
public class AccountServiceImpl implements AccountService {
	@Autowired
	AccountRepo aRepo;

	@Override
	public Account getAccount(int id) {
		return aRepo.findById(id).get();
	}

	@Override
	public Account createAccount(Account account) {
		aRepo.save(account);
		return null;
	}

	@Override
	public Account updateAccount(Account account) {
		aRepo.save(account);
		return null;
	}

	@Override
	public String deleteAccount(int id) {
		aRepo.deleteById(id);
		return "Account with the id #"+id+" has been deleted";
	}

	@Override
	public List<Account> getAllAccount() {
		aRepo.findAll();
		return null;
	}




}
