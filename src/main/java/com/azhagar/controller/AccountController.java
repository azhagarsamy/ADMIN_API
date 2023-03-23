package com.azhagar.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.azhagar.binding.AccountBinding;
import com.azhagar.binding.AccountUpdateBinding;
import com.azhagar.service.IAccountService;

@RestController
@RequestMapping("/account")
public class AccountController {

	@Autowired
	private IAccountService service;

	@PostMapping("/save")
	public ResponseEntity<String> createAccount(@RequestBody AccountBinding accBinding) {
		String createAccount = service.createAccount(accBinding);
		return new ResponseEntity<String>(createAccount, HttpStatus.CREATED);
	}

	@GetMapping("/view")
	public ResponseEntity<List<AccountBinding>> viewAccounts() {
		List<AccountBinding> viewAccount = service.viewAccount();
		return new ResponseEntity<List<AccountBinding>>(viewAccount, HttpStatus.OK);
	}

	@PutMapping("/update/{accId}/{status}")
	public ResponseEntity<String> updateStatus(@PathVariable("accId") Integer acccId,
			@PathVariable("status") String status) {

		String updateActiveStatus = service.updateActiveStatus(acccId, status);
		return new ResponseEntity<String>(updateActiveStatus, HttpStatus.OK);
	}

	@DeleteMapping("/delete/{accId}")
	public ResponseEntity<String> deleteAccount(@PathVariable("accId") Integer accId) {
		String deleteAccount = service.deleteAccount(accId);
		return new ResponseEntity<String>(deleteAccount, HttpStatus.OK);
	}

	@PutMapping("/update")
	public ResponseEntity<String> updateAccount(@RequestBody AccountUpdateBinding accBinding) {
		String updateAccount = service.updateAccount(accBinding);
		return new ResponseEntity<String>(updateAccount, HttpStatus.OK);
	}

}
