package com.learning.entity;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "transactions")
public class Transaction {
	
	public enum TransactionType{
		CR, DB
	}
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int transactionId;
	
	private double amount;
	private int fromAcc;
	private int toAcc;
	private String reason;
	private String executedBy;
	
	public Transaction() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Transaction(double amount, int fromAcc,
			int toAcc, String reason, String executedBy) {
		super();
		this.amount = amount;
		this.fromAcc = fromAcc;
		this.toAcc = toAcc;
		this.reason = reason;
		this.executedBy = executedBy;
	}

	public int getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(int transactionId) {
		this.transactionId = transactionId;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}
	public int getFromAcc() {
		return fromAcc;
	}

	public void setFromAcc(int fromAcc) {
		this.fromAcc = fromAcc;
	}

	public int getToAcc() {
		return toAcc;
	}

	public void setToAcc(int toAcc) {
		this.toAcc = toAcc;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public String getBy() {
		return executedBy;
	}

	public void setBy(String executedBy) {
		this.executedBy = executedBy;
	}
	
	
	
	

	
	
	

}
