package com.azhagar.service;

import java.util.List;

import com.azhagar.binding.AccountBinding;
import com.azhagar.binding.AccountUpdateBinding;

public interface IAccountService {

	String createAccount(AccountBinding accBinding);

	List<AccountBinding> viewAccount();

	String updateActiveStatus(Integer accId,String status);

	String deleteAccount(Integer accId);
	
	String updateAccount(AccountUpdateBinding accBinding);
	
	

}
