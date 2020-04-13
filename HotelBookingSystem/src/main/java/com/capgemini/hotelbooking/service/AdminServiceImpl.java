package com.capgemini.hotelbooking.service;

import java.util.Scanner;

import com.capgemini.hotelbooking.dao.HotelsDaoImpl;
import com.capgemini.hotelbooking.exception.HotelNotFoundException;

public class AdminServiceImpl implements AdminService{

	private static Scanner sc = new Scanner(System.in);
	HotelsDaoImpl hotelDao = new HotelsDaoImpl();
	
	@Override
	public boolean addHotels() 
	{
		System.out.println("Enter hotel name:");
		String hotelName = sc.nextLine();
		System.out.println("Enter number of rooms:");
		String roomString = sc.nextLine();
		int rooms = Integer.parseInt(roomString);
		return hotelDao.addHotels(hotelName, rooms);
	}

	@Override
	public void hotelsInfo() throws HotelNotFoundException {
		for(String s : hotelDao.viewHotels()) {
			System.out.println(s);
		}
	}

	
}
