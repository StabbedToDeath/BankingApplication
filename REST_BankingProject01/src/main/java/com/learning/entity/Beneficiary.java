package com.learning.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

import org.springframework.data.annotation.Id;

@Entity
public class Beneficiary {

	//fromCustomer : number
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int beneficaryId;
	private int fromCustomer;				//Could also be a list of customers/??
	private int beneficaryAcNo;
	private Date beneficiaryAddedDate;
	private String approved;
	
	
	public int getBeneficaryId() {
		return beneficaryId;
	}
	public void setBeneficaryId(int beneficaryId) {
		this.beneficaryId = beneficaryId;
	}
	public int getFromCustomer() {
		return fromCustomer;
	}
	public void setFromCustomer(int fromCustomer) {
		this.fromCustomer = fromCustomer;
	}
	public int getBeneficaryAcNo() {
		return beneficaryAcNo;
	}
	public void setBeneficaryAcNo(int beneficaryAcNo) {
		this.beneficaryAcNo = beneficaryAcNo;
	}
	public Date getBeneficiaryAddedDate() {
		return beneficiaryAddedDate;
	}
	public void setBeneficiaryAddedDate(Date beneficiaryAddedDate) {
		this.beneficiaryAddedDate = beneficiaryAddedDate;
	}
	public String getApproved() {
		return approved;
	}
	public void setApproved(String approved) {
		this.approved = approved;
	}
	public Beneficiary() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Beneficiary(int fromCustomer, int beneficaryAcNo, Date beneficiaryAddedDate, String approved) {
		super();
		this.fromCustomer = fromCustomer;
		this.beneficaryAcNo = beneficaryAcNo;
		this.beneficiaryAddedDate = beneficiaryAddedDate;
		this.approved = approved;
	}
	
}
