package com.learning.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.learning.entity.Beneficiary;
import com.learning.repo.BeneficiaryRepo;

@Service
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
	public void deleteBeneficiary(int id) {
		bRepo.deleteById(id);
	}

	@Override
	public List<Beneficiary> getAllBeneficiary() {
		return bRepo.findAll();
	}

	@Override
	public List<Beneficiary> getApprovedAccounts(String approved) {
		return bRepo.findAllByApprovedEquals(approved);
	}

}
