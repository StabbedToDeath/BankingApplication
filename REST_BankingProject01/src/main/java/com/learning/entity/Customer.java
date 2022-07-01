package com.learning.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;

import org.springframework.data.annotation.Id;

@Entity
public class Customer {
	
	enum Status
	{
		Enable,
		Disable
	}
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int customerId;
	private String username;
	private String fullname;
	private String password;
	private Status status;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "customer_account_tabl", joinColumns = @JoinColumn(name="custId"))
	List<Account> accounts;				
	
	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getFullname() {
		return fullname;
	}
	public void setFullname(String fullname) {
		this.fullname = fullname;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Status getStatus() {
		return status;
	}
	public void setStatus(Status status) {
		this.status = status;
	}
	public List<Account> getAccount() {
		return accounts;
	}
	public void setAccount(List<Account> accounts) {
		this.accounts = accounts;
	}
	public void addAccount(Account account) {
		this.accounts.add(account);
	}
	public Customer(String username, String fullname, String password) {
		super();
		this.username = username;
		this.fullname = fullname;
		this.password = password;
		this.status = Status.Enable;
	}
	
	
}
