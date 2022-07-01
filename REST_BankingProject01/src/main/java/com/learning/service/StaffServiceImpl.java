package com.learning.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.learning.entity.Staff;
import com.learning.repo.StaffRepo;

@Service
public class StaffServiceImpl implements StaffService {
	
	@Autowired
	StaffRepo sRepo;
	
	@Override
	public Staff addStaff(Staff staff) {
		return sRepo.save(staff);
	}

	@Override
	public Staff getStaffByID(int id) {
		return sRepo.findById(id).get();
	}

	@Override
	public List<Staff> getAllStaff() {
		return sRepo.findAll();
	}

	@Override
	public Staff updateStaff(Staff staff) {
		return sRepo.save(staff);
	}

	@Override
	public void deleteStaffByID(int id) {
		sRepo.deleteById(id);
	}

}
