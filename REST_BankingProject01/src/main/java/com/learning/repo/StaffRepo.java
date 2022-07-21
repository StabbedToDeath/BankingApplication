package com.learning.repo;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.learning.entity.Staff;

public interface StaffRepo extends JpaRepository<Staff, Integer>{
	
	Staff findByUsername(String username);
	Staff deleteByUsername(String username);
	
}
