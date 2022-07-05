package com.learning.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;


@Entity
public class Account {
	
	public enum AccountType{
		SB,
		CA
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int accountNumber;
	private AccountType accountType;
	private double accountBalance;
	private String approved;
	private Date creationDate;
	private String custName;
	private String staffUser;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "acc_stmt_tbl", joinColumns = @JoinColumn(name="accountNumber"))
	private List<Statement> transactions;
	
	public Account() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Account(AccountType accountType, double accountBalance) {
		super();
		this.accountType = accountType;
		this.accountBalance = accountBalance;
		this.approved = "No";
		this.setCreationDate(new Date());
	}
	public int getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(int accountNumber) {
		this.accountNumber = accountNumber;
	}

	public AccountType getAccountType() {
		return accountType;
	}

	public void setAccountType(AccountType accountType) {
		this.accountType = accountType;
	}

	public double getAccountBalance() {
		return accountBalance;
	}

	public void setAccountBalance(double accountBalance) {
		this.accountBalance = accountBalance;
	}

	public String getApproved() {
		return approved;
	}

	public void setApproved(String approved) {
		this.approved = approved;
	}

	public List<Statement> getTransactions() {
		return transactions;
	}

	public void setTransactions(List<Statement> transactions) {
		this.transactions = transactions;
	}
	
	public void addTransaction(Statement transaction) {
		this.transactions.add(transaction);
	}

	public String getCustName() {
		return custName;
	}

	public void setCustName(String custName) {
		this.custName = custName;
	}

	public String getStaffUser() {
		return staffUser;
	}

	public void setStaffUser(String staffUser) {
		this.staffUser = staffUser;
	}

	public Date getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}
	
	
	

}
