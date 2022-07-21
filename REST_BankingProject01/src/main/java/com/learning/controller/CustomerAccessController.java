package com.learning.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.ListIterator;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
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
import com.learning.entity.Statement;
import com.learning.entity.Transaction;
import com.learning.entity.Transaction.TransactionType;
import com.learning.service.AccountService;
import com.learning.service.BeneficiaryService;
import com.learning.service.CustomerService;
import com.learning.service.TransactionService;

@RestController
@RequestMapping("/api/customer")
@CrossOrigin
public class CustomerAccessController {

	@Autowired
	CustomerService cService;

	@Autowired
	BeneficiaryService bService;
	
	@Autowired
	AccountService aService;
	
	@Autowired
	TransactionService tService;
	
	//@PreAuthorize("hasRole('CUSTOMER')")
	@PostMapping("/register")
	public ResponseEntity<Customer> registerCustomer(@RequestBody Customer customer) {
		
		customer.setCreated(new Date());
		customer.setActive(true);
		customer.setRole("Customer");
		cService.createCustomer(customer);
		return new ResponseEntity<Customer>(customer, HttpStatus.valueOf(201));
	}

	@GetMapping("/{customerId}/account")
	public ResponseEntity<List<Account>> getAllAccountByCustomerId(
			@PathVariable(name = "customerId") Integer custId) {
		return new ResponseEntity<List<Account>>(cService.getCustomer(custId).getAccount(), HttpStatus.valueOf(200));

	}

	@GetMapping("{customerId}")
	public ResponseEntity<Customer> getCustomerById(@PathVariable(name = "customerId") Integer custId) {
		return new ResponseEntity<Customer>(cService.getCustomer(custId), HttpStatus.valueOf(200));
	}

	@PutMapping("/{customerId}")
	public ResponseEntity<Object> updateCustomer(@PathVariable(name = "customerId") Integer custId,
			@RequestBody Customer customer) {
		try {
			
			Customer toUpdate = cService.getCustomer(custId);
			toUpdate.setFullname(customer.getFullname());
			toUpdate.setPhone(customer.getPhone());
			
			// stuff to be uncommented later
			// toUpdate.setPan(customer.getPan());
			// toUpdate.setAadhar(customer.getAadhar());
			// toUpdate.setSecretQ(customer.getSecretQ());
			// toUpdate.setSecretA(customer.getSecretA());
			// toUpdate.setPanI(customer.getPanI());
			// toUpdate.setAadharI(customer.getAadharI());
			
			cService.updateCustomer(toUpdate);
			
			return new ResponseEntity<Object>(HttpStatus.valueOf(200));

		} catch (NoSuchElementException e) {
			return new ResponseEntity<Object>("Sorry customer with " + custId + " not found", HttpStatus.NOT_FOUND);
		}
	}

	@PostMapping("/{customerId}/account")
	public ResponseEntity<Object> createAccount(@PathVariable(name = "customerId") Integer custId,
			@RequestBody Account account) {

		try {
			Customer customer = cService.getCustomer(custId);
			account.setCustName(customer.getFullname());
			customer.addAccount(account);
			account.setCreationDate(new Date());
			account.setApproved("No");
			aService.createAccount(account);

			return new ResponseEntity<Object>(account, HttpStatus.valueOf(200));

		} catch (NoSuchElementException e) {
			return new ResponseEntity<Object>("Account cannot be created", HttpStatus.valueOf(403));
		}

	}

	@GetMapping("/{customerId}/account/{accountId}")
	public ResponseEntity<Object> getAccountById(@PathVariable(name = "customerId") Integer custId,
			@PathVariable(name = "accountId") Integer accountId) {

		try {

			List<Account> accounts = cService.getCustomer(custId).getAccount();

			ListIterator<Account> lt = accounts.listIterator();
			while (lt.hasNext()) {
				Account acc = lt.next();
				if (acc.getAccountNumber() == accountId) {
					return new ResponseEntity<Object>(acc, HttpStatus.OK);
				}
			}
			return new ResponseEntity<Object>("Sorry account with " + accountId + " not found", HttpStatus.NOT_FOUND);

		} catch (NoSuchElementException e) {
			return new ResponseEntity<Object>("Sorry account with " + accountId + " not found", HttpStatus.NOT_FOUND);
		}

	}

	@PostMapping("/{customerId}/beneficiary")
	public ResponseEntity<String> createBeneficiary(@PathVariable(name = "customerId") Integer custId,
			@RequestBody Account account) {
		try {
			
			Account ben = aService.getAccount(account.getAccountNumber());
			if (ben.getAccountType().equals(account.getAccountType())) {
				Customer customer = cService.getCustomer(custId);
				Beneficiary beneficiary = new Beneficiary(custId, ben.getAccountNumber(), new Date());
				beneficiary.setActivityYes();
				beneficiary.setBeneficiaryName(cService.getCustomer(custId).getFullname());
				customer.addBeneficiary(beneficiary);
				
				//update db
				bService.createBeneficiary(beneficiary);
				cService.updateCustomer(customer);
				
				return new ResponseEntity<String>("Beneficiary with " + account.getAccountNumber() + " added",
						HttpStatus.valueOf(200));
			}
			return new ResponseEntity<String>(
					"Sorry beneficiary with " + account.getAccountNumber() + " not added", HttpStatus.NOT_FOUND);

		} catch (NoSuchElementException e) {
			return new ResponseEntity<String>(
					"Sorry beneficiary with " + account.getAccountNumber() + " not added", HttpStatus.NOT_FOUND);
		}
	}

	@GetMapping("/{customerId}/beneficiary")
	public ResponseEntity<List<Beneficiary>> getBeneficiary(@PathVariable(name = "customerId") Integer custId) {
		try {
			return new ResponseEntity<List<Beneficiary>>(cService.getCustomer(custId).getBeneficiary(), HttpStatus.OK);

		} catch (NoSuchElementException e) {
			return new ResponseEntity<List<Beneficiary>>(new ArrayList(), HttpStatus.NOT_FOUND);
		}

	}

	@DeleteMapping("/{customerId}/beneficiary/{beneficiaryId}")
	public ResponseEntity<String> deleteBeneficiary(@PathVariable(name = "customerId") Integer custId,
			@PathVariable(name = "beneficiaryId") Integer benId) {

		try {
			Customer customer = cService.getCustomer(custId);
			List<Beneficiary> bens = customer.getBeneficiary();

			ListIterator<Beneficiary> lt = bens.listIterator();
			while (lt.hasNext()) {
				Beneficiary ben = lt.next();
				if (ben.getBeneficaryId() == benId) {
					bens.remove(ben);
					break;
				}
			}
			
			//update database
			bService.deleteBeneficiary(benId);
			cService.updateCustomer(customer);

			return new ResponseEntity<String>("Beneficiary successfully deleted", HttpStatus.OK);
		} catch (NoSuchElementException e) {
			return new ResponseEntity<String>("Beneficiary not deleted", HttpStatus.NOT_FOUND);
		}
	}

	@PutMapping("/transfer")
	public ResponseEntity<String> transfer(@RequestBody Transaction transaction) {
		try {
			
			transaction.setBy("Customer");
			
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
				//return new ResponseEntity<String>("Failure", HttpStatus.OK);
				throw new ArithmeticException("Dont cheat the bank! You fool!");
			}
		} catch (NoSuchElementException e) {
			return new ResponseEntity<String>("Doesn't exist!", HttpStatus.NOT_FOUND);
		}
	}
	
//	//authenticate
//	@PreAuthorize("hasRole('Customer')")
//	@PostMapping("/authenticate")
//	public ResponseEntity<String> authenticate(@RequestBody Customer customer) {
//		try {
//			Customer toCheck = cService.getCustomerByUsername(customer.getUsername());
//			if (toCheck.getPassword().matches(customer.getPassword())) {
//				if (toCheck.getStatus() == Status.Enable)
//					return new ResponseEntity<String>("Authentication Successfull", HttpStatus.OK);
//				else
//					return new ResponseEntity<String>("Failed to Authenticate. Check with Staff", HttpStatus.FORBIDDEN);
//			}				
//		} catch (NullPointerException e) {
//			return new ResponseEntity<String>("Not registered", HttpStatus.FORBIDDEN);
//		}
//		return new ResponseEntity<String>("Please check again", HttpStatus.FORBIDDEN);
//		
//	}
	
	//approve Account by id - Staff access only
	@PreAuthorize("hasRole('STAFF')")
	@PutMapping("/{customerId}/account/{accountId}")
	public ResponseEntity<Object> approveAccount(@PathVariable(name = "customerId") Integer custId,
			@PathVariable(name = "accountId") Integer accountId, @RequestBody Account account) {
		try {
			cService.getCustomer(custId);
			Account acc = aService.getAccount(accountId);
			acc.setApproved(account.getApproved());
			acc.setStaffUser("Jack");
			aService.updateAccount(acc);
			return new ResponseEntity<Object>(aService.getAccount(accountId), HttpStatus.OK);
		} catch (NoSuchElementException e) {
			return new ResponseEntity<Object>("Please Check Account Number", HttpStatus.NOT_FOUND);
		}
	}
	
	//change password
	@PutMapping("/{username}/forgot")
	public ResponseEntity<String> updatePassword(@PathVariable(name = "username") String userName, @RequestBody Customer customer) {
		try {
			Customer toBeUpdated = cService.getCustomerByUsername(userName);
			toBeUpdated.setPassword(customer.getPassword());
			cService.updateCustomer(toBeUpdated);
			return new ResponseEntity<String>("New Password updated", HttpStatus.OK);
		} catch (NoSuchElementException e) {
			return new ResponseEntity<String>("Sorry password was not updated", HttpStatus.FORBIDDEN);
		}
	}
	
	
}
