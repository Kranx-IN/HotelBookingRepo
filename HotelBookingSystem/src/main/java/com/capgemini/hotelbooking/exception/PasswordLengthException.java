package com.capgemini.hotelbooking.exception;

public class PasswordLengthException extends Exception{//Avinash
	

	private static final long serialVersionUID = 1L;

	@Override
	public String getMessage() {
		return "PasswordLengthIsViolated";
	}
	
}
