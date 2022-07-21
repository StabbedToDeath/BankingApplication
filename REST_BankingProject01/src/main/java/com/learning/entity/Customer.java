package com.learning.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;


@Entity
@PrimaryKeyJoinColumn(name = "userId")
public class Customer extends User{
	
	private Date created;
	private long phone;
	
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "customer_account_tabl", joinColumns = @JoinColumn(name="customerId"))
	List<Account> accounts;	
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "customer_beneficiary_table", joinColumns = @JoinColumn(name = "customerId"))
	List<Beneficiary> beneficiary;	
	
	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Customer(String username, String fullname, String password, boolean isActive, Date created, long phone, List<Account> accounts,
			List<Beneficiary> beneficiary) {
		super(username, fullname, password, "Customer", isActive);
		this.created = created;
		this.phone = phone;
		this.accounts = accounts;
		this.beneficiary = beneficiary;
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
	
	
}
