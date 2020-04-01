package com.capgemini.service;

import java.util.Map;

import com.capgemini.model.User;

public interface UserBooking {
	
	public String searchRooms(User user);
	public boolean bookRooms(User user,String hotelName);
	public Map<String,Integer> bookedRooms(User user);
	
	public boolean addHotels();
	public void viewHotels();
}
