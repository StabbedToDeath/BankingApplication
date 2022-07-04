package com.learning.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.learning.entity.Staff;
import com.learning.service.StaffService;

@RestController
@RequestMapping("/admin")
public class AdminAccessController {
	
	@Autowired
	StaffService sService;
	
	//create Staff
	@PreAuthorize("hasRole('ADMIN')")
	@PostMapping("/staff")
	public ResponseEntity<Staff> createStaff(@RequestBody Staff staff) {
		try {
			sService.getStaffByUser(staff.getStaffUserName());
			sService.addStaff(staff);
			return new ResponseEntity<Staff>(HttpStatus.CREATED);
		} catch(NoSuchElementException e) {
			return new ResponseEntity<Staff>(HttpStatus.FORBIDDEN);
		}
		
	}

	//list all staff
	@PreAuthorize("hasRole('ADMIN')")
	@GetMapping("/staff")
	public ResponseEntity<List<Staff>> getAllStaff(){
		try {
			return new ResponseEntity<List<Staff>>(sService.getAllStaff(), HttpStatus.OK);
		} catch (NoSuchElementException e) {
			return new ResponseEntity<List<Staff>>(new ArrayList<Staff>() , HttpStatus.NOT_FOUND);
		}
	}

	//enable/disable the staff
	@PreAuthorize("hasRole('ADMIN')")
	@PutMapping("/staff")
	public ResponseEntity<String> changeStatus(@RequestBody Staff staff) {
		try {
			sService.getStaffByID(staff.getStaffId()).setStatus(staff.getStatus());
			return new ResponseEntity<String>("Staff status changed", HttpStatus.OK);
		} catch (NoSuchElementException e) {
			return new ResponseEntity<String>("Staff status not changed", HttpStatus.NOT_FOUND);
		}
	}
}
