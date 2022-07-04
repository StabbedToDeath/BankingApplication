package com.learning.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.learning.entity.Beneficiary;

public interface BeneficiaryRepo extends JpaRepository<Beneficiary, Integer> {
	
	public List<Beneficiary> findAllByApprovedEquals(String approved);
}
