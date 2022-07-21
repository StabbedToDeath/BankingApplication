package com.learning.controller;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.learning.entity.Account;
import com.learning.entity.Beneficiary;
import com.learning.entity.Customer;
import com.learning.entity.Staff;
import com.learning.entity.Statement;
import com.learning.entity.Transaction;
import com.learning.entity.Transaction.TransactionType;
import com.learning.exceptions.ResourceNotFoundException;
import com.learning.service.AccountService;
import com.learning.service.BeneficiaryService;
import com.learning.service.CustomerService;
import com.learning.service.StaffService;
import com.learning.service.TransactionService;

@RestController
@RequestMapping("/api/staff")
@CrossOrigin
public class StaffAccessController {
	
	@Autowired
	CustomerService cService;
	
	@Autowired
	AccountService aService;
	
	@Autowired
	BeneficiaryService bService;
	
	@Autowired
	StaffService sService;
	
	@Autowired
	TransactionService tService;	
	
	
	//get all customers
	@GetMapping("/customer")
	public ResponseEntity<List<Customer>> getAllCustomer(){
		return new ResponseEntity<List<Customer>>(cService.getAllCustomer(), HttpStatus.valueOf(200));
	}
	
	//enable/disable status of Customer Login
	@PutMapping("/customer")
	public ResponseEntity<Object> changeStatus(@RequestBody Customer customer) {
		try {
			Customer toUpdate = cService.getCustomer(customer.getUserId());
			toUpdate.setActive(customer.isActive());
			cService.updateCustomer(toUpdate);
			return new ResponseEntity<Object>(cService.getCustomer(customer.getUserId()), HttpStatus.OK);
		} catch (NoSuchElementException e) {
			return new ResponseEntity<Object>("Customer status not changed", HttpStatus.NOT_FOUND);
		}
	}
	
	//get customer with id
	@GetMapping("/customer/{customerID}")
	public ResponseEntity<Object> getCustomer(@PathVariable(name = "customerID") Integer custID) {
		try {
			return new ResponseEntity<Object>(cService.getCustomer(custID), HttpStatus.OK);
		} catch (NoSuchElementException e) {
			return new ResponseEntity<Object>("Customer not found", HttpStatus.valueOf(403));
		}
	}
	
	//getStatement
	@GetMapping("/account/{accNo}")
	public Account getStatement(@PathVariable("accNo") int accNo) {
		Account statement = null;
		
		try {
			statement = aService.getAccount(accNo);
		}catch(NoSuchElementException exc) {
			throw new ResourceNotFoundException("account not found");
		}
		
		return statement;
	}
	
	//list all bens to be approved
	@GetMapping("/beneficiary")
	public List<Beneficiary> getNotApprovedBens() {
		return bService.getApprovedAccounts("No");
	}
	
	//approve beneficiary
	@PutMapping("/beneficiary")
	public ResponseEntity<String> approveBeneficiary(@RequestBody Beneficiary beneficiary) {
		try {
			aService.getAccount(beneficiary.getBeneficaryAcNo());
			bService.updateBeneficiary(beneficiary);
			return new ResponseEntity<String>(HttpStatus.OK);
		} catch (NoSuchElementException e) {
			return new ResponseEntity<String>("Approving of account was not successfull", HttpStatus.NOT_FOUND);
		}
		
		
	}
	
	//list all accounts to be approved
	@GetMapping("/accounts/approve")
	public List<Account> getNotApprovedAccounts() {
		return aService.getApprovedAccounts("No");
	}
	
	//list accounts to be approved of specific customer
	@PutMapping("/accounts/approve")
	public ResponseEntity<String> approveAccount(@RequestBody Account account) {
		try {
			Account toUpdate = aService.getAccount(account.getAccountNumber());
			toUpdate.setApproved("Yes");
			aService.updateAccount(toUpdate);
			// add Staff Username
			//
			return new ResponseEntity<String>(HttpStatus.OK);
		} catch (NoSuchElementException e) {
			return new ResponseEntity<String>("Approving of account was not successfull", HttpStatus.NOT_FOUND);
		}
		
		
	}
	
	//transaction
	@PutMapping("/transfer")
	public ResponseEntity<String> transfer(@RequestBody Transaction transaction) {
		try {
			
			transaction.setBy("Staff");
			
			Account debitor = aService.getAccount(transaction.getFromAcc());
			Account creditor = aService.getAccount(transaction.getToAcc());

			if (debitor.getAccountBalance() > transaction.getAmount() && debitor.getApproved().equalsIgnoreCase("yes")
					&& creditor.getApproved().equalsIgnoreCase("yes")) {
				
				tService.createTransactions(transaction);
				
				debitor.setAccountBalance(debitor.getAccountBalance() - transaction.getAmount());
				creditor.setAccountBalance(creditor.getAccountBalance() + transaction.getAmount());
				
				Statement stmtD = new Statement(transaction.getTransactionId(),transaction.getAmount(), TransactionType.DB);
				debitor.addTransaction(stmtD);
				
				Statement stmtC = new Statement(transaction.getTransactionId(),transaction.getAmount(), TransactionType.CR);
				creditor.addTransaction(stmtC);
				
				//update database
				aService.updateAccount(creditor);
				aService.updateAccount(debitor);
				
				return new ResponseEntity<String>("Success", HttpStatus.OK);
			} else {
				throw new ArithmeticException("Dont cheat the bank! You fool!");
			}
		} catch (NoSuchElementException e) {
			return new ResponseEntity<String>("Doesn't exist!", HttpStatus.NOT_FOUND);
		}
	}
	
	/*
	 * @PostMapping("/authenticate") public ResponseEntity<String>
	 * authenticate(@RequestBody Staff staff) {
	 * 
	 * List<Staff> allStaff = sService.getAllStaff();
	 * 
	 * for(Staff employee : allStaff) { if
	 * (employee.getUsername().matches(staff.getUsername()) &&
	 * employee.getPassword().matches(staff.getPassword())) { if
	 * (employee.getStatus() == Status.Enable) return new
	 * ResponseEntity<String>("Authentication Successfull", HttpStatus.OK); else
	 * return new ResponseEntity<String>("Failed to Authenticate. Check with Admin",
	 * HttpStatus.FORBIDDEN); } } return new
	 * ResponseEntity<String>("Not registered", HttpStatus.FORBIDDEN); }
	 */
}
