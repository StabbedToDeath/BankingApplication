package com.leraning.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

import org.springframework.data.annotation.Id;

@Entity
public class Staff {
	
	enum Status{
		Enable,
		Disable
	}
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int staffId;
	private String staffFullName;
	private String staffUserName;
	private String staffPassword;
	private String staffName;				//?????
	private Status status;
	
	
	public int getStaffId() {
		return staffId;
	}
	public void setStaffId(int staffId) {
		this.staffId = staffId;
	}
	public String getStaffFullName() {
		return staffFullName;
	}
	public void setStaffFullName(String staffFullName) {
		this.staffFullName = staffFullName;
	}
	public String getStaffUserName() {
		return staffUserName;
	}
	public void setStaffUserName(String staffUserName) {
		this.staffUserName = staffUserName;
	}
	public String getStaffPassword() {
		return staffPassword;
	}
	public void setStaffPassword(String staffPassword) {
		this.staffPassword = staffPassword;
	}
	public String getStaffName() {
		return staffName;
	}
	public void setStaffName(String staffName) {
		this.staffName = staffName;
	}
	public Status getStatus() {
		return status;
	}
	public void setStatus(Status status) {
		this.status = status;
	}
	public Staff() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Staff(String staffFullName, String staffUserName, String staffPassword, String staffName, Status status) {
		super();
		this.staffFullName = staffFullName;
		this.staffUserName = staffUserName;
		this.staffPassword = staffPassword;
		this.staffName = staffName;
		this.status = status;
	}
	
	
	
	
}
