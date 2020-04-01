package com.capgemini.service;

import java.util.HashMap;
import java.util.Map;

import com.capgemini.model.User;

public class UserVerifyImpl implements UserVerify {

	private static Map<String, String> usersList = new HashMap<String, String>();
	
	@Override
	public int checkUser(User user) 
	{	
		if(usersList.containsKey(user.getUserName()) && usersList.get(user.getUserName()).equals(user.getPassword())){
			return 1;
		}
		else if(user.getUserName().equals(user.getAdminUserName()) && (user.getPassword().equals(user.getAdminPassword()))) {
			return 2;
		}
		else 
		{
			return 0;
		}
	}

	@Override
	public boolean addUser(User user) 
	{
		if(usersList.containsKey(user.getUserName()) || user.getUserName().equals(user.getAdminUserName())) {
			return false;
		}
		else {
			usersList.put(user.getUserName(), user.getPassword());
			return true;
		}
	}
	
}
