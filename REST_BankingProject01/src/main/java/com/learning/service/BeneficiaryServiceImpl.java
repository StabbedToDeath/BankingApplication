package com.learning.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.learning.entity.Beneficiary;
import com.learning.repo.BeneficiaryRepo;

public class BeneficiaryServiceImpl implements BeneficiaryService {
	@Autowired
	BeneficiaryRepo bRepo;
	
	
	@Override
	public Beneficiary getBeneficiary(int id) {
		return bRepo.findById(id).get();
	}

	@Override
	public Beneficiary createBeneficiary(Beneficiary beneficiary) {
		return bRepo.save( beneficiary);
	}

	@Override
	public Beneficiary updateBeneficiary(Beneficiary beneficiary) {
		return bRepo.save( beneficiary);
	}

	@Override
	public String deleteBeneficiary(int id) {
		bRepo.deleteById(id);
		return "The account with Id #"+id+" has deleted" ;
	}

	@Override
	public List<Beneficiary> getAllBeneficiary() {
		return bRepo.findAll();
	}

}
