package com.capgemini.hotelbooking.service;

import com.capgemini.hotelbooking.bean.User;
import com.capgemini.hotelbooking.exception.NameNullException;
import com.capgemini.hotelbooking.exception.PasswordLengthException;
import com.capgemini.hotelbooking.exception.UserNameLengthException;

public interface UserVerifyService {//sashank

	public int checkUser(User user) throws NameNullException;
	public boolean addUser(User user) throws PasswordLengthException, UserNameLengthException;
	
}
