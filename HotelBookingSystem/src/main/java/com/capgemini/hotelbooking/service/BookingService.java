package com.capgemini.hotelbooking.service;

import java.util.Map;

import com.capgemini.hotelbooking.bean.User;
import com.capgemini.hotelbooking.exception.HotelNotFoundException;

public interface BookingService {//sashank
	
	public String searchRooms(User user) throws HotelNotFoundException;
	public boolean bookRooms(User user,String hotelName) throws HotelNotFoundException;
	public Map<String,Integer> bookedRooms(User user);

}
