package com.capgemini.hotelbooking.exception;

public class PasswordLengthException extends Exception{
	

	private static final long serialVersionUID = 1L;

	@Override
	public String getMessage() {
		return "Password should Be 4 or more characters";
	}
	
}
