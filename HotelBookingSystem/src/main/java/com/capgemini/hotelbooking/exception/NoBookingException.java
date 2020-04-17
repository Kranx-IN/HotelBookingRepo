package com.capgemini.hotelbooking.exception;

public class NoBookingException extends Exception{

	private static final long serialVersionUID = 1L;

	@Override
	public String getMessage() {
		return "User did not book any rooms";
	}
}
