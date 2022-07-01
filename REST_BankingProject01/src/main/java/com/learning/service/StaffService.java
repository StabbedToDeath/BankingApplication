package com.learning.service;

import java.util.List;

import com.learning.entity.Staff;

public interface StaffService {
	
	public Staff addStaff(Staff staff);
	
	public Staff getStaffByID(int id);
	
	public List<Staff> getAllStaff();
	
	public Staff updateStaff(Staff staff);
	
	public void deleteStaffByID(int id);
	
	
}
