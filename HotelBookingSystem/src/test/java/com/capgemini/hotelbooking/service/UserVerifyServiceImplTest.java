package com.capgemini.hotelbooking.service;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import com.capgemini.hotelbooking.bean.User;
import com.capgemini.hotelbooking.dao.UserDaoImpl;
import com.capgemini.hotelbooking.exception.NameNullException;

@RunWith(MockitoJUnitRunner.class)
public class UserVerifyServiceImplTest {

	
	private User user;
	private UserVerifyServiceImpl target;
	@Mock										//To create a mock object of UserDaoImpl class
	private UserDaoImpl userDao;
	
	@Before
	public void setup() {
		target = new UserVerifyServiceImpl();	
	}

	@Test(expected = NameNullException.class)
	public void checkUserShouldThrowNameNullExceptionWithNullUsername() throws NameNullException{
		user = new User("","abcd",1);
		target.checkUser(user);
	}
	
	@Test(expected = NameNullException.class)
	public void checkUserShouldThrowNameNullExceptionWithNullPassword() throws NameNullException {
		user = new User("user1","",1);
		target.checkUser(user);
	}
	
	@Test(expected = NameNullException.class)
	public void checkUserShouldThrowNameNullExceptionWithNullParameters() throws NameNullException {
		user = new User("","",1);
		target.checkUser(user);
	}
	
	@Test
	public void checkUserShouldReturnZero() throws NameNullException{
		user = new User("user1","abcd",1);
		Mockito.when(userDao.checkUser(user)).thenReturn(0);
		assertEquals(0, target.checkUser(user));
	}

	@Test
	public void checkUserShouldReturnTwo() throws NameNullException{
		user = new User("admin","1234",1);
		Mockito.when(userDao.checkUser(user)).thenReturn(2);
		assertEquals(2, target.checkUser(user));
	}
	

}