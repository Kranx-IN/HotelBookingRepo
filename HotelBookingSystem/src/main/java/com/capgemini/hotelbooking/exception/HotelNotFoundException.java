package com.capgemini.hotelbooking.exception;

public class HotelNotFoundException extends Exception{

	private static final long serialVersionUID = 1L;

	@Override
	public String getMessage() {
		return "Hotel not found";
	}
	
	
}
