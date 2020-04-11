package com.capgemini.hotelbooking.service;

import com.capgemini.hotelbooking.exception.HotelNotFoundException;

public interface AdminService {

	public boolean addHotels();
	public void hotelsInfo () throws HotelNotFoundException;
}
