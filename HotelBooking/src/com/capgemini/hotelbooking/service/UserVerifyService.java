package com.capgemini.hotelbooking.service;

import com.capgemini.hotelbooking.bean.User;

public interface UserVerifyService {

	public int checkUser(User user);
	public boolean addUser(User user);
	
}
