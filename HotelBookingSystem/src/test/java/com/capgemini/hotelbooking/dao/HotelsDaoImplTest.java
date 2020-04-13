package com.capgemini.hotelbooking.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import com.capgemini.hotelbooking.exception.HotelNotFoundException;

public class HotelsDaoImplTest {

	HotelsDaoImpl target = null;
	@Before
	public void before() {
		target = new HotelsDaoImpl();
	}

	@Test(expected = HotelNotFoundException.class)
	public void viewHotelsShouldThrowHotelNotFoundException() throws HotelNotFoundException{
		target.viewHotels();
	}
	
	@Test
	public void viewHotelsShouldReturnList() throws HotelNotFoundException {
		target.addHotels("hotel1", 23);
		assertNotNull(target.viewHotels());
	}
	
	@Test(expected = HotelNotFoundException.class)
	public void availableRoomsShouldThrowHotelNotFoundException() throws HotelNotFoundException {
		target.availableRooms("hotel9");
	}
	
	@Test
	public void availableRoomsShouldReturnNumberOfRooms() throws HotelNotFoundException {
		target.addHotels("hotel4", 34);
		assertEquals(34, target.availableRooms("hotel4"));
	}
	
	@Test
	public void addHotelsShouldReturnTrue() {
		assertTrue(target.addHotels("hotel45", 34));
	}
	
	@Test
	public void modifyRoomsShouldReturnTrue() throws HotelNotFoundException {
		assertTrue(target.modifyRooms("hotel675", 14));
	}
	
	@Test
	public void addHotelsShouldReturnFalse() {
		assertFalse(target.addHotels("hotel1", 55));
	}
}
