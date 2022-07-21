package com.learning.entity;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;


@Entity
@PrimaryKeyJoinColumn(name = "userId")
public class Staff extends User{
	
	public enum Status{
		Enable,
		Disable
	}
	
	private Status status;
	
	public Staff() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Staff(String username, String fullname, String password, boolean isActive, Status status) {
		super(username, fullname, password, "Staff", isActive);
		this.status = status;
	}
	
	public Status getStatus() {
		return status;
	}
	public void setStatus(Status status) {
		this.status = status;
	}
	
	
	
	
}
