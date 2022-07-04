package com.learning.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

import org.springframework.data.annotation.Id;

@Entity
public class Beneficiary {
	
	private enum Activity {
		YES, NO
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int beneficaryId;
	private int fromCustomer;
	private int beneficaryAcNo;
	private Date beneficiaryAddedDate;
	private String approved;
	private Activity activityStatus = Activity.YES;
	
	
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
	}
	public Activity getActivityStatus() {
		return activityStatus;
	}
	public void setActivityYes() {
		this.activityStatus = Activity.YES;
	}
	public void setActivityNo() {
		this.activityStatus = Activity.NO;
	}
	
	public Beneficiary(int fromCustomer, int beneficaryAcNo, Date beneficiaryAddedDate) {
		super();
		this.fromCustomer = fromCustomer;
		this.beneficaryAcNo = beneficaryAcNo;
		this.beneficiaryAddedDate = beneficiaryAddedDate;
		this.approved = "No";
	}
	
}
