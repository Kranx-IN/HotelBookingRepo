package com.capgemini.hotelbooking.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.capgemini.hotelbooking.exception.HotelNotFoundException;

public class HotelsDaoImpl implements HotelsDao{

	private static Map<String,Integer> hotelsList = new HashMap<String, Integer>();

	@Override
	public List<String> viewHotels() throws HotelNotFoundException{
		
		if(!hotelsList.isEmpty())
		{
			List<String> hotelNames = new ArrayList<String>();
			hotelNames.addAll(hotelsList.keySet());
			System.out.println("List of hotels :");
			for(int i =1;i<=hotelNames.size();i++) {
				System.out.println((i) + ". " + hotelNames.get(i-1));
			}
			return hotelNames;
		}
		else {
			throw new HotelNotFoundException();
		}
	}

	@Override
	public int availableRooms(String hotel) throws HotelNotFoundException {
		if(hotelsList.containsKey(hotel) && hotel != null) {
			return hotelsList.get(hotel);
		}
		else {
			throw new HotelNotFoundException();
		}
	}

	@Override
	public boolean modifyRooms(String hotel, int rooms){
		if(hotelsList.containsKey(hotel)) {
			hotelsList.replace(hotel, rooms);
			System.out.println(hotel + true);
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public boolean addHotels(String hotelName, int rooms) {
		if(hotelsList.containsKey(hotelName) || hotelName.isEmpty()) {
			System.out.println(hotelName + false);
			return false;
		}
		else {
			hotelsList.putIfAbsent(hotelName, rooms);
			return true;
		}
	}

	@Override
	public Map<String, Integer> userRooms() {
	
		return null;
	}


}
