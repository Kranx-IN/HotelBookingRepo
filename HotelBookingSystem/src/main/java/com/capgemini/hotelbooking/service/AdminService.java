package com.capgemini.hotelbooking.service;

import com.capgemini.hotelbooking.exception.HotelNotFoundException;

public interface AdminService {//sashank

	public boolean addHotels();
	public void hotelsInfo () throws HotelNotFoundException;
}
