package com.learning.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.learning.entity.Transaction.TransactionType;

@Entity
public class Statement {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int stmtId;
	
	private Date date;
	private int reference;
	private double amount;
	private TransactionType type;
	
	public Statement() {
		super();
		// TODO Auto-generated constructor stub
	}

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
