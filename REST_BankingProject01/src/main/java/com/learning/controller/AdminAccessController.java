package com.learning.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import org.springframework.beans.factory.annotation.Autowired;
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
import com.learning.service.StaffService;

@RestController
@RequestMapping("/api/admin")
@CrossOrigin
public class AdminAccessController {

	@Autowired
	StaffService sService;

	// create Staff
	@PreAuthorize("hasRole('ADMIN')")
	@PostMapping("/staff")
	public ResponseEntity<Staff> createStaff(@RequestBody Staff staff) {
		boolean fake = false;
		List<Staff> allStaff = sService.getAllStaff();

		for(Staff employee : allStaff) {
			if (employee.getUsername().matches(staff.getUsername())) {
				fake = true;
				break;
			}
		}
		if (!fake) {
			//staff.setStatus(Status.Enable);
			staff.setRole("Staff");
			sService.addStaff(staff);
			return new ResponseEntity<Staff>(HttpStatus.CREATED);
		} else
			return new ResponseEntity<Staff>(HttpStatus.FORBIDDEN);
	}
			

	// list all staff
	@PreAuthorize("hasRole('ADMIN')")
	@GetMapping("/staff")
	public ResponseEntity<List<Staff>> getAllStaff() {
		try {
			return new ResponseEntity<List<Staff>>(sService.getAllStaff(), HttpStatus.OK);
		} catch (NoSuchElementException e) {
			return new ResponseEntity<List<Staff>>(new ArrayList<Staff>(), HttpStatus.NOT_FOUND);
		}
	}

	// enable/disable the staff
	@PreAuthorize("hasRole('ADMIN')")
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

	@PreAuthorize("hasRole('ADMIN')")
	@PostMapping("/authenticate")
	public ResponseEntity<String> authenticate(@RequestBody Customer customer) {
		if (customer.getUsername().matches("Pranav")) {
			if (customer.getPassword().matches("root"))
				return new ResponseEntity<String>("Authentication Successfull", HttpStatus.OK);
		}
		return new ResponseEntity<String>("Not registered", HttpStatus.FORBIDDEN);

	}
}
