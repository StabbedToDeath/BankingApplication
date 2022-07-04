package com.learning.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.learning.entity.Account;

public interface AccountRepo extends JpaRepository<Account, Integer> {
	
	public List<Account> findAllByApprovedEquals(String approved);
	
}
