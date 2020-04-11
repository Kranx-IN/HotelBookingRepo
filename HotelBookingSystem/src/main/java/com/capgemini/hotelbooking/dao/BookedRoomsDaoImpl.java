package com.capgemini.hotelbooking.dao;

import java.util.HashMap;
import java.util.Map;

import com.capgemini.hotelbooking.bean.User;

public class BookedRoomsDaoImpl implements BookedRoomsDao{//sashank
	
	private Map<String,Integer> bookedRooms = new HashMap<String, Integer>();
	private static Map<User,Map<String,Integer>> bookedHotels = new HashMap<User, Map<String,Integer>>();
	
	private User user;
	private String hotel;
	
	public BookedRoomsDaoImpl() {	
		
	}	
	
	public BookedRoomsDaoImpl(User user, String hotel){
		this.user = user;
		this.hotel=hotel;
	}

	@Override
	public boolean bookedRooms(User user, String hotel, int rooms) {
		if(bookedRooms.containsKey(hotel)) {
			int prevRooms = bookedRooms.get(hotel);
			bookedRooms.replace(hotel, (prevRooms+rooms));
		}
		else {
			bookedRooms.put(hotel, rooms);
		}
		bookedHotels.put(user, bookedRooms);
		return true;
	}

	@Override
	public Map<String, Integer> userRooms(User user) {	
		return bookedHotels.get(user);
	}
	
}
