package com.learning.entity;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;


@Entity
@PrimaryKeyJoinColumn(name = "userId")
public class Staff extends User{
	

	
	public Staff() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Staff(String username, String fullname, String password, boolean isActive ) {
		super(username, fullname, password, "Staff", isActive);

	}
	

	
	
	
}
