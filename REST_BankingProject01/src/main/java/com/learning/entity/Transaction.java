package com.learning.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;

import org.hibernate.annotations.Cascade;

@Entity
public class Transaction {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int transactionId;
	
	
	@OneToMany
	@JoinTable(name = "transaction_account_tb1", joinColumns = @JoinColumn(name="fTransId"))
	private int fromAccNumber;
	private String transactionType;
	@OneToMany
	@JoinTable(name = "transaction_account_tb2", joinColumns = @JoinColumn(name="tTransId"))
	private int toAccNumber;
	private double amount;
	private String reason;
	private String date;
	private String reference;
	public int getTransactionId() {
		return transactionId;
	}
	public void setTransactionId(int transactionId) {
		this.transactionId = transactionId;
	}
	public int getFromAccNumber() {
		return fromAccNumber;
	}
	public void setFromAccNumber(int fromAccNumber) {
		this.fromAccNumber = fromAccNumber;
	}
	public String getTransactionType() {
		return transactionType;
	}
	public void setTransactionType(String transactionType) {
		this.transactionType = transactionType;
	}
	public int getToAccNumber() {
		return toAccNumber;
	}
	public void setToAccNumber(int toAccNumber) {
		this.toAccNumber = toAccNumber;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public String getReason() {
		return reason;
	}
	public void setReason(String reason) {
		this.reason = reason;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getReference() {
		return reference;
	}
	public void setReference(String reference) {
		this.reference = reference;
	}
	

	public Transaction(String transactionType, double amount, String reason, String date, String reference) {
		super();
		this.transactionType = transactionType;
		this.amount = amount;
		this.reason = reason;
		this.date = date;
		this.reference = reference;
	}
	public Transaction() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

}
