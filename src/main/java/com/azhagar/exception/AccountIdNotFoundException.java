package com.azhagar.exception;

public class AccountIdNotFoundException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public AccountIdNotFoundException() {
	}
	
	public AccountIdNotFoundException(String message){
		super(message);
	}

}
