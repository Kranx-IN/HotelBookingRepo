package com.capgemini.hotelbooking.dao;

import com.capgemini.hotelbooking.bean.User;

public interface UserDao {
	
	public boolean addUser(User user);
	public boolean deleteUser(User user);
	
}
