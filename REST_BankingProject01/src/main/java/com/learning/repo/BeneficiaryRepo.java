package com.learning.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.learning.entity.Beneficiary;

public interface BeneficiaryRepo extends JpaRepository<Beneficiary, Integer> {
	

}
