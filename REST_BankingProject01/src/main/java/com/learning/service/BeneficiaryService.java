package com.learning.service;

import java.util.List;

import com.learning.entity.Beneficiary;

public interface BeneficiaryService {
	
	public Beneficiary getBeneficiary(int id);
	
	public Beneficiary createBeneficiary(Beneficiary  beneficiary);
	
	public Beneficiary updateBeneficiary(Beneficiary  beneficiary);
	
	public void deleteBeneficiary(int id);
	
	public List<Beneficiary> getAllBeneficiary();
	
	public List<Beneficiary> getApprovedAccounts(String approved);
	
	

}
