package com.capgemini.hotelbooking.dao;

import java.util.List;
import java.util.Map;

import com.capgemini.hotelbooking.exception.HotelNotFoundException;

public interface HotelsDao {

	public List<String> viewHotels() throws HotelNotFoundException;
	public int availableRooms(String hotel) throws HotelNotFoundException;
	public boolean modifyRooms(String hotel, int rooms);
	public boolean addHotels(String hotelName, int rooms);
	public Map<String,Integer> userRooms(); 
	
}
