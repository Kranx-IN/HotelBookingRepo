package com.capgemini.hotelbooking.exception;

public class UserNameLengthException extends Exception{//Siddharth

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public String getMessage() {
		return "UsernameLengthIsViolated";
	}
}
