package com.learning.repo;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.learning.entity.Staff;

public interface StaffRepo extends JpaRepository<Staff, Integer>{
	
	@Query("select s from Staff s where s.staffUserName = ?1")
	Staff findByStaffUserName(String staffUserName);
	
}
