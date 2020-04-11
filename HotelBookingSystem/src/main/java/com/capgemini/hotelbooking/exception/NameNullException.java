package com.capgemini.hotelbooking.exception;

public class NameNullException extends Exception{//sashank

	private static final long serialVersionUID = 1L;

	@Override
	public String getMessage() {
		return "NameIsNull";
	}
	
}
