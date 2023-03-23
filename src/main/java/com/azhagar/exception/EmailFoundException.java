package com.azhagar.exception;

public class EmailFoundException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public EmailFoundException() {
	}
	
	public EmailFoundException(String msg) {
		super(msg);
	}

}
