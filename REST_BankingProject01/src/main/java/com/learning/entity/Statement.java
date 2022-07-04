package com.learning.entity;

import java.util.Date;

import com.learning.entity.Transaction.TransactionType;

public class Statement {
	
	private Date date;
	private int reference;
	private double amount;
	private TransactionType type;
	
	public Statement(int reference, double amount, TransactionType type) {
		super();
		this.date = new Date();
		this.reference = reference;
		this.amount = amount;
		this.type = type;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public int getReference() {
		return reference;
	}

	public void setReference(int reference) {
		this.reference = reference;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public TransactionType getType() {
		return type;
	}

	public void setType(TransactionType type) {
		this.type = type;
	}
	
	
	
	
	
	
}
