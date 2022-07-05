package com.learning.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class Staff {
	
	public enum Status{
		Enable,
		Disable
	}
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int staffId;
	private String staffFullName;
	private String staffUserName;
	private String staffPassword;
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
	public Staff(String staffFullName, String staffUserName, String staffPassword, Status status) {
		super();
		this.staffFullName = staffFullName;
		this.staffUserName = staffUserName;
		this.staffPassword = staffPassword;
		this.status = status;
	}
	
	
	
	
}
