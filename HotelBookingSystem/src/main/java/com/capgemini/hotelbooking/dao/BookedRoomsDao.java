package com.capgemini.hotelbooking.dao;

import java.util.Map;

import com.capgemini.hotelbooking.bean.User;
import com.capgemini.hotelbooking.exception.NoBookingException;

public interface BookedRoomsDao {	
	public boolean bookedRooms(User user, String hotel, int rooms);
	public Map<String,Integer> userRooms(User user) throws NoBookingException;
}
