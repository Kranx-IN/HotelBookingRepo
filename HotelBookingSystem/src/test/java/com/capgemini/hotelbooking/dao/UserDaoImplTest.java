package com.capgemini.hotelbooking.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import com.capgemini.hotelbooking.bean.User;

public class UserDaoImplTest {//Sashank

	private User user;

	@Before
	public void userClass(){
		user = new User();
	}
	
	@Test
	public void checkUserShouldReturnTwoForCorrectAdminCredentials() {
		user.setUserName("admin");
		user.setPassword("1234");
		UserDaoImpl target = new UserDaoImpl();
		assertEquals(2,target.checkUser(user));
	}
	
	@Test
	public void checkUserShouldReturnOneForCorrectCutomerCredentials() {
		user.setEmployee(false);
		user.setUserName("user1");
		user.setPassword("abcd");
		UserDaoImpl target = new UserDaoImpl();
		target.createUser(user);
		assertEquals(1, target.checkUser(user));
	}
	
	@Test
	public void checkUserShouldReturnOneForCorrectEmployeeCredentials() {
		user.setEmployee(false);
		user.setUserName("user1");
		user.setPassword("abcd");
		UserDaoImpl target = new UserDaoImpl();
		target.createUser(user);
		assertEquals(1, target.checkUser(user));
	}
	
	@Test
	public void checkUserShouldReturnZeroForInvalidAdminUsername() {
		user.setUserName("admin123");
		user.setPassword("1234");
		UserDaoImpl target = new UserDaoImpl();
		assertEquals(0, target.checkUser(user));
	}
	
	@Test
	public void checkUserShouldReturnZeroForInvalidAdminPassword() {
		user.setUserName("admin");
		user.setPassword("aaaa");
		UserDaoImpl target = new UserDaoImpl();
		assertEquals(0, target.checkUser(user));
	}
	
	@Test
	public void checkUserShouldReturnZeroForInorrectEmployeePassword() {
		user.setEmployee(false);
		user.setUserName("user1");
		user.setPassword("abcd");
		UserDaoImpl target = new UserDaoImpl();
		target.createUser(user);
		user.setUserName("user1");
		user.setPassword("4568");
		
		assertEquals(0, target.checkUser(user));
	}

	@Test
	public void checkUserShouldReturnZeroForInorrectEmployeeUsername() {
		user.setEmployee(false);
		user.setUserName("user1");
		user.setPassword("abcd");
		UserDaoImpl target = new UserDaoImpl();
		target.createUser(user);
		user.setUserName("user2");
		user.setPassword("abcd");
		
		assertEquals(0, target.checkUser(user));
	}
	
	@Test
	public void checkUserShouldReturnZeroForIncorrectCustomerPassword() {
		user.setEmployee(false);
		user.setUserName("user1");
		user.setPassword("abcd");
		UserDaoImpl target = new UserDaoImpl();
		target.createUser(user);
		user.setUserName("user1");
		user.setPassword("4444");
		assertEquals(0, target.checkUser(user));
	}
	
	@Test
	public void checkUserShouldReturnZeroForIncorrectCustomerUsername() {
		user.setEmployee(false);
		user.setUserName("user1");
		user.setPassword("abcd");
		UserDaoImpl target = new UserDaoImpl();
		target.createUser(user);
		user.setUserName("user2");
		user.setPassword("abcd");
		assertEquals(0, target.checkUser(user));
	}
	
	@Test
	public void createUserShouldReturnTrue() {
		user.setUserName("user5");
		user.setPassword("abcd");
		UserDaoImpl target = new UserDaoImpl();
		assertTrue(target.createUser(user));
	}
	
	@Test
	public void createUserShouldReturnFalse() {
		user.setUserName("user5");
		user.setPassword("abcd");
		UserDaoImpl target = new UserDaoImpl();
		assertFalse(target.createUser(user));
	}
}
