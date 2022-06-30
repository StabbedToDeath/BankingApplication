package com.leraning.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;

import org.springframework.data.annotation.Id;


public class Account {
	
	enum AccountType{			//Savings?? and Checking account??
		SB,
		CA
	}
	
	enum AccountStatus
	{
		Enable,
		Disable
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int accountId;
	private int accountNumber;
	private AccountType accountType;
	private double accountBalance;
	private AccountStatus accountStatus;
	

	

}
