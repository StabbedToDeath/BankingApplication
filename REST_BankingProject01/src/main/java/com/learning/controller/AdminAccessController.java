package com.learning.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties.Admin;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.learning.entity.Customer;

import com.learning.entity.Staff;
import com.learning.entity.User;
import com.learning.service.StaffService;
import com.learning.service.UserService;

@RestController
@RequestMapping("/api/admin")
@CrossOrigin
public class AdminAccessController {

	@Autowired
	StaffService sService;
	
	@Autowired
	UserService service;

	// create Staff
	@PostMapping("/staff")
	public ResponseEntity<Staff> createStaff(@RequestBody Staff staff) {
		boolean fake = false;
		List<Staff> allStaff = sService.getAllStaff();
		System.out.println(staff.getUsername());
		for(Staff employee : allStaff) {
			if (employee.getUsername().matches(staff.getUsername())) {
				fake = true;
				System.out.println();
				break;
			}
		}
		if (!fake) {
			staff.setRole("Staff");
			sService.addStaff(staff);
			return new ResponseEntity<Staff>(HttpStatus.CREATED);
		} else
			return new ResponseEntity<Staff>(HttpStatus.FORBIDDEN);
	}
			

	// list all staff
	@GetMapping("/staff")
	public ResponseEntity<List<Staff>> getAllStaff() {
		try {
			return new ResponseEntity<List<Staff>>(sService.getAllStaff(), HttpStatus.OK);
		} catch (NoSuchElementException e) {
			return new ResponseEntity<List<Staff>>(new ArrayList<Staff>(), HttpStatus.NOT_FOUND);
		}
	}

	// enable/disable the staff
	@PutMapping("/staff")
	public ResponseEntity<String> changeStatus(@RequestBody Staff staff) {
		try {
			Staff toUpdate = sService.getStaffByID(staff.getUserId());
			//toUpdate.setStatus(staff.getStatus());
			toUpdate.setActive(staff.isActive());
			sService.updateStaff(toUpdate);
			return new ResponseEntity<String>("Staff status changed", HttpStatus.OK);
		} catch (NoSuchElementException e) {	
			return new ResponseEntity<String>("Staff status not changed", HttpStatus.NOT_FOUND);
		}
	}

	@PostMapping("/authenticate")
	public ResponseEntity<String> authenticate(@RequestBody Customer customer) {
		if (customer.getUsername().matches("Pranav")) {
			if (customer.getPassword().matches("root"))
				return new ResponseEntity<String>("Authentication Successfull", HttpStatus.OK);
		}
		return new ResponseEntity<String>("Not registered", HttpStatus.FORBIDDEN);

	}
	
	@GetMapping("/test")
	public User addAdmin() {
		User admin = new User("admin", "Pranav", "password", "Admin", true);
		service.addUser(admin);
		return admin;
	}
}
