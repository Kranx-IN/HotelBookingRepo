package com.capgemini.hotelbooking.service;

import java.util.List;
import java.util.Map;
import java.util.Scanner;

import com.capgemini.hotelbooking.bean.User;
import com.capgemini.hotelbooking.dao.BookedRoomsDaoImpl;
import com.capgemini.hotelbooking.dao.HotelsDaoImpl;
import com.capgemini.hotelbooking.exception.HotelNotFoundException;

public class BookingServiceImpl implements BookingService {
	
	BookedRoomsDaoImpl bookedRoomsDao = null;
	HotelsDaoImpl hotelDao = null;
	
	private static Scanner sc = new Scanner(System.in);

	private int userStatus = 1;
	
	public BookingServiceImpl(int userStatus) {
		this.userStatus=userStatus;
	}
	
	public BookingServiceImpl(){
		
	}
	
	@Override
	public String searchRooms(User user) throws HotelNotFoundException 
	{	
		hotelDao = new HotelsDaoImpl();
		List<String> hotelNames = hotelDao.viewHotels();
		if(hotelNames != null) 
		{
			System.out.println("\nSelect a hotel from the above list:");
			int choice =  sc.nextInt();
			return hotelNames.get(choice);	
		}
		else
		{
			return "No hotel info available!";
		}
	}

	@Override
	public boolean bookRooms(User user,String hotel) throws HotelNotFoundException
	{
		hotelDao = new HotelsDaoImpl();
		bookedRoomsDao = new BookedRoomsDaoImpl(user,hotel);
		
		if(hotelDao.viewHotels().contains(hotel)) {
			int availRooms = hotelDao.availableRooms(hotel);
			if(availRooms>0) {
				System.out.println("\n\tRooms available: "+availRooms);
				System.out.println("Enter no of rooms to be booked: ");
				int selectRooms = sc.nextInt();
				if(selectRooms <= availRooms) {
					bookedRoomsDao.bookedRooms(user,hotel,selectRooms);				
					hotelDao.modifyRooms(hotel, availRooms-selectRooms);
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
		return bookedRoomsDao.userRooms(user);
	}	

}
