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
	private Date created;
	private long phone;
	
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "customer_account_tabl", joinColumns = @JoinColumn(name="customerId"))
	List<Account> accounts;	
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "customer_beneficiary_table", joinColumns = @JoinColumn(name = "customerId"))
	List<Beneficiary> beneficiary;	
	
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
	public Date getCreated() {
		return created;
	}
	public void setCreated(Date created) {
		this.created = created;
	}
	public long getPhone() {
		return phone;
	}
	public void setPhone(long phone) {
		this.phone = phone;
	}
	
	public List<Beneficiary> getBeneficiary() {
		return beneficiary;
	}
	public void setBeneficiary(List<Beneficiary> beneficiary) {
		this.beneficiary = beneficiary;
	}
	public void addBeneficiary(Beneficiary beneficiary) {
		this.beneficiary.add(beneficiary);
	}
	
	public Customer(String username, String fullname, String password) {
		super();
		this.username = username;
		this.fullname = fullname;
		this.password = password;
		this.status = Status.Enable;
		this.created = new Date();
	}
	
	
	
}
