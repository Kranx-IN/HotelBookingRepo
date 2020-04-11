package com.capgemini.hotelbooking.dao;

import java.util.AbstractMap.SimpleEntry;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import com.capgemini.hotelbooking.bean.User;

public class UserDaoImpl implements UserDao{//sashank

	//Local Database:
	private static Map<String, String> customersList = new HashMap<String, String>();
	private static Map<String, Entry<String,String>> employeesList = new HashMap<String,Entry<String,String>>(); 
	
	@Override
	public int checkUser(User user) 
	{
		if(user.getUserName().equals(user.getAdminUserName()) && (user.getPassword().equals(user.getAdminPassword()))) {
			return 2;
		}
		else if(!user.isEmployee()) {
			if(customersList.containsKey(user.getUserName()) && customersList.get(user.getUserName()).equals(user.getPassword())) {
				return 1;
			}
		}
		else if(user.isEmployee() && employeesList.containsKey(user.getUserName())) {
			Entry<String,String> employeeEntry = employeesList.get(user.getUserName());
			if(employeeEntry.getKey().equals(user.getPassword()))
			{
				return 1;
			}
		}	
		return 0;
	}

	@Override
	public boolean createUser(User user) 
	{
		if(customersList.containsKey(user.getUserName()) || user.getUserName().equals(user.getAdminUserName()) || employeesList.containsKey(user.getUserName())) {
			return false;
		}
		else {
			if(user.isEmployee()) {
				employeesList.put(user.getUserName(), new SimpleEntry<String, String>(user.getPassword(), user.getHotelName()));
			}
			else {
				customersList.put(user.getUserName(), user.getPassword());
			}
			return true;
		}
	}

}
