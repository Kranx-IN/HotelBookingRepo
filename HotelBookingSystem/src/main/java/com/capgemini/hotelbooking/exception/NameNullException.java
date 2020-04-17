package com.capgemini.hotelbooking.exception;

public class NameNullException extends Exception{

	private static final long serialVersionUID = 1L;

	@Override
	public String getMessage() {
		return "username can't be empty";
	}
	
}
