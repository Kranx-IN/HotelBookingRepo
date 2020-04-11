package com.capgemini.hotelbooking.dao;

import com.capgemini.hotelbooking.bean.User;

public interface UserDao {//sashank
	
	public int checkUser(User user);
	public boolean createUser(User user);	
}
