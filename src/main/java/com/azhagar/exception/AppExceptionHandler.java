package com.azhagar.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class AppExceptionHandler {

	@ExceptionHandler(AccountIdNotFoundException.class)
	public ResponseEntity<ExceptionInfo> handleAccNFE(AccountIdNotFoundException ac) {

		String exMsg = ac.getMessage();
		ExceptionInfo info = new ExceptionInfo();
		info.setErrMsg(exMsg);
		info.setErrCode("");
		return new ResponseEntity<ExceptionInfo>(info, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(Exception.class)
	public ResponseEntity<ExceptionInfo> handleEx(Exception ex) {

		String message = ex.getMessage();
		ExceptionInfo info = new ExceptionInfo();
		info.setErrMsg(message);
		info.setErrCode("");
		return new ResponseEntity<ExceptionInfo>(info, HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@ExceptionHandler(NullPointerException.class)
	public ResponseEntity<ExceptionInfo> handleNPE(NullPointerException ne) {
		String message = ne.getMessage();
		ExceptionInfo info = new ExceptionInfo();
		info.setErrMsg(message);
		info.setErrCode("");
		return new ResponseEntity<ExceptionInfo>(info, HttpStatus.INTERNAL_SERVER_ERROR);
	}

}
