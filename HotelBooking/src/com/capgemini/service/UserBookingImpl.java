package com.capgemini.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

import com.capgemini.model.User;

public class UserBookingImpl implements UserBooking {

	private static Map<String,Integer> hotelsList = new HashMap<String, Integer>();
	private Map<String,Integer> bookedHotel = new HashMap<String, Integer>();
	private Map<User,Map<String,Integer>> bookedRoom = new HashMap<User, Map<String,Integer>>();
	private static Scanner sc = new Scanner(System.in);

	private int userStatus = 1;
	
	public UserBookingImpl(int userStatus) {
		this.userStatus=userStatus;
	}
	
	public UserBookingImpl(){
		
	}
	
	@Override
	public String searchRooms(User user) {
		if(!hotelsList.isEmpty()){
			List<String> hotelNames = new ArrayList<String>();
			hotelNames.addAll(hotelsList.keySet());
			System.out.println("List of hotels :");
			for(int i =1;i<=hotelNames.size();i++) {
				System.out.println((i) + ". " + hotelNames.get(i-1));
			}
			System.out.println("\nSelect a hotel from the above list:");
			int choice =  sc.nextInt();
			return hotelNames.get(choice);	
		}
		return "No hotel info available!";
	}

	@Override
	public boolean bookRooms(User user,String hotel) {
		
		if(hotelsList.containsKey(hotel)) {
			int availRooms = hotelsList.get(hotel);
			if(availRooms>0) {
				System.out.println("\n\tRooms available: "+availRooms);
				System.out.println("Enter no of rooms to be booked: ");
				int selectRooms = sc.nextInt();
				if(selectRooms <= availRooms) {
					bookedHotel.put(hotel, selectRooms);
					bookedRoom.put(user, bookedHotel);
					hotelsList.replace(hotel, availRooms-selectRooms);
					return true;
				}
				else {
					System.out.println("There are not enough available rooms in this hotel");
					return false;
				}
			}
		}
		return false;
	}

	@Override
	public Map<String, Integer> bookedRooms(User user) {	
		return bookedRoom.get(user);
	}

	@Override
	public boolean addHotels() {
		if(userStatus == 2) {
			System.out.println("Enter hotel name:");
			String hotelName = sc.nextLine();
			System.out.println("Enter number of rooms:");
			String roomString = sc.nextLine();
			int rooms = Integer.parseInt(roomString);
			
			Integer value = hotelsList.putIfAbsent(hotelName, rooms);
			if(value == null) {
				return true;
			}
			else {
				return false;
			}
		}
		return false;
	}

	@Override
	public void viewHotels() {
		Set<String> hotelNames = hotelsList.keySet();
		for(String name: hotelNames) {
			System.out.println("Hotel: "+name+", Rooms: "+hotelsList.get(name));
		}
		
	}
	

}
