package com.learning.service;

import java.util.List;

import com.learning.entity.Transaction;

public interface TransactionService {
	public Transaction createTransactions(Transaction transaction);
	public Transaction getTransactions(int id);
	public Transaction updateTransactions(Transaction transaction);
	public String deleteTransactions(int id);
	public List<Transaction> getallTransactions();

}
