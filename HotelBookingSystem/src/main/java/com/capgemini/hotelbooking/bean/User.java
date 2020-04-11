package com.capgemini.hotelbooking.bean;

public class User {
	protected String userName;
	protected String password;
	private String adminUserName = "admin";
	private String adminPassword = "1234";
	private boolean employee;
	private String hotelName;
	
	public User() {
		
	}
	
	public User(String userName, String password,int post) {
		super();
		this.userName = userName;
		this.password = password;
		if(post == 1) {
			this.employee = false;
		}
		else if(post == 2) {
			this.employee=true;
		}
	}
	public User(String userName, String password,int post,String hotelName) {
		super();
		this.userName = userName;
		this.password = password;
		if(post == 1) {
			this.employee = false;
		}
		else if(post == 2) {
			this.employee=true;
		}
		this.hotelName=hotelName;
	}
	

	public String getHotelName() {
		return hotelName;
	}

	public void setHotelName(String hotelName) {
		this.hotelName = hotelName;
	}

	public boolean isEmployee() {
		return employee;
	}

	public void setEmployee(boolean employee) {
		this.employee = employee;
	}

	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getAdminUserName() {
		return adminUserName;
	}

	public void setAdminUserName(String adminUserName) {
		this.adminUserName = adminUserName;
	}

	public String getAdminPassword() {
		return adminPassword;
	}

	public void setAdminPassword(String adminPassword) {
		this.adminPassword = adminPassword;
	}

	@Override
	public String toString() {
		return "User [userName=" + userName + ", password=" + password + "employee: " + employee +"]";
	}
	
	
}
