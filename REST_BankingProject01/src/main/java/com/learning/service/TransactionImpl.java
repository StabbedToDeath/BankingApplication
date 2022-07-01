package com.learning.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.learning.entity.Transaction;
import com.learning.repo.TransactionRepo;


@Service

public class TransactionImpl implements TransactionService {
	
	@Autowired
	TransactionRepo tRepo;

	@Override
	public Transaction createTransactions(Transaction transaction) {
		return tRepo.save(transaction);
	}

	@Override
	public Transaction getTransactions(int id) {
		return tRepo.findById(id).get();
	}

	@Override
	public Transaction updateTransactions(Transaction transaction) {
		return tRepo.save(transaction);
	}

	@Override
	public String deleteTransactions(int id) {
		tRepo.deleteById(id);
		return "The transaction with the id of #" +id+", has been canceled";
	}

	@Override
	public List<Transaction> getallTransactions() {
		return tRepo.findAll();
	}

}
