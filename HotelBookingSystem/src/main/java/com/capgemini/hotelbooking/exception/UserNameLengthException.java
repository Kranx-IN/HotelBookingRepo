package com.capgemini.hotelbooking.exception;

public class UserNameLengthException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public String getMessage() {
		return "Username should be 4 or more characters";
	}
}
