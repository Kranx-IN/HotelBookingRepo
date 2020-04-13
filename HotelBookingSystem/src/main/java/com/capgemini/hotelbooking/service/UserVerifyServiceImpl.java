package com.capgemini.hotelbooking.service;

import com.capgemini.hotelbooking.bean.User;
import com.capgemini.hotelbooking.dao.UserDaoImpl;
import com.capgemini.hotelbooking.exception.NameNullException;
import com.capgemini.hotelbooking.exception.PasswordLengthException;
import com.capgemini.hotelbooking.exception.UserNameLengthException;

public class UserVerifyServiceImpl implements UserVerifyService {

	UserDaoImpl userDao = new UserDaoImpl();
	
	@Override
	public int checkUser(User user) throws NameNullException 
	{
		if(user.getUserName().isEmpty() || user.getPassword().isEmpty()) {
			throw new NameNullException();
		}
		else 
		{
			int result = userDao.checkUser(user);
			return result;
		}
	}

	@Override
	public boolean addUser(User user) throws PasswordLengthException, UserNameLengthException 
	{	
		if(user.getPassword().length() < 4) {
			throw new PasswordLengthException();
		}
		else if(user.getUserName().length() < 4) {
			throw new UserNameLengthException();
		}
		boolean result = userDao.createUser(user);
		return result;
	}
	
}
