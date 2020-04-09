package com.capgemini.hotelbooking.service;

import java.util.Map;

import com.capgemini.hotelbooking.bean.User;

public interface UserBookingService {
	
	public String searchRooms(User user);
	public boolean bookRooms(User user,String hotelName);
	public Map<String,Integer> bookedRooms(User user);
	
	public boolean addHotels();
	public void viewHotels();
}
