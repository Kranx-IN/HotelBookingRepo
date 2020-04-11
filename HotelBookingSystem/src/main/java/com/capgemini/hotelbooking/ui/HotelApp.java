package com.capgemini.hotelbooking.ui;

import java.util.Scanner;

import com.capgemini.hotelbooking.bean.User;
import com.capgemini.hotelbooking.exception.HotelNotFoundException;
import com.capgemini.hotelbooking.exception.NameNullException;
import com.capgemini.hotelbooking.exception.PasswordLengthException;
import com.capgemini.hotelbooking.exception.UserNameLengthException;
import com.capgemini.hotelbooking.service.AdminServiceImpl;
import com.capgemini.hotelbooking.service.BookingServiceImpl;
import com.capgemini.hotelbooking.service.UserVerifyServiceImpl;

public class HotelApp {

	public static void main(String[] args) {//sashank
		
		Scanner sc = new Scanner(System.in);
		System.out.println("\tWelcome to hotel booking app!\n");
		boolean flag = true;
		UserVerifyServiceImpl verifyService = new UserVerifyServiceImpl();
		User user = null;
		while(flag) {
			System.out.println("1.Login");
			System.out.println("2.Register");
			System.out.println("3.Exit");
			System.out.print("Enter your choice:");
			String choice = sc.nextLine();
			switch(choice) {
				case "1":
					System.out.println("Logging as..\n 1.Customer\t 2. Employee");
					System.out.print("Select an option: ");
					int post = sc.nextInt();
					sc.nextLine();
					System.out.println("Logging you in...\n");
					System.out.println("Enter username:");
					String userName = sc.nextLine();
					System.out.println("Enter password:");
					String password = sc.nextLine();
					
					user = new User(userName, password,post);
					
				int status;
				try {
					status = verifyService.checkUser(user);
					if(status == 1) {
						System.out.println("Successfully Logged in...\n");
						boolean flag2 = true;
						while(flag2) {
							BookingServiceImpl userBooking = new BookingServiceImpl(status);
							System.out.println("1.Book a new Hotel Room");
							System.out.println("2.View My bookings");
							System.out.println("3.Back");
							System.out.println("Select an opiton");
							String option1 = sc.nextLine();
							switch(option1) {
								case "1":
								String hotel;
								try {
									hotel = userBooking.searchRooms(user);
									if(hotel != null) 
									{
										userBooking.bookRooms(user, hotel);
									}
								} catch (HotelNotFoundException e) {
									System.out.println("The hotels list is empty! Contact admin for assistance.");
								}
									break;
								case "2":
									userBooking.bookedRooms(user);
									break;
								case "3":
									flag2 = false;
									System.out.println("\n<-- Going back");
									break;
								default:
									System.out.println("\nInvalid selection!");
									break;
								}
							}
						}
					else if(status == 2) {
						System.out.println("Welcome , admin");
						boolean flag3 = true;
						while(flag3) {
							AdminServiceImpl adminService = new AdminServiceImpl();
							System.out.println("1. Add hotels");
							System.out.println("2. View hotels");
							System.out.println("3. Back");
							System.out.println("Select an option: ");
							String option2 = sc.nextLine();
							switch(option2) {
							case "1":
								if(adminService.addHotels()) {
									System.out.println("Succesfully added a hotel!");
								}
								else {
									System.out.println("Failed to add the hotel or It already exists");
								}
								break;
							case "2":
								try {
									adminService.hotelsInfo();									
								}catch (HotelNotFoundException e) {
									System.out.println("The hotels list is empty! Contact admin for assistance.");
								}

								break;
							case "3":
								flag3 = false;
								System.out.println("\n<-- Going back");
								break;
							default:
								System.out.println("\nInvalid selection!");
								break;
						}
						}	
					}
					else{
						System.out.println("\nInvalid credentials!  or User not found! \n");
					}
				}catch (NameNullException e1) {
					System.out.println("The username entered is invalid!");
				}
					break;
				case "2":
					System.out.println("Proceeding with Registration...\n");
					System.out.println("Enter a username:");
					userName = sc.nextLine();
					System.out.println("Enter a password:");
					password = sc.nextLine();
					System.out.println("Registering as..\n 1.Customer\t 2. Employee");
					System.out.print("Select an option: ");
					post = sc.nextInt();
					sc.next();
					if(post == 2) {
						System.out.println("Enter hotel name:");
						String hotelName = sc.nextLine();
						user = new User(userName, password,post,hotelName);
					}
					user = new User(userName, password,post);
				boolean register;
				try {
					register = verifyService.addUser(user);
					if(register) {
						System.out.println("Successfully added a new user\n");
					}
					else {
						System.out.println("User already exists\n");
					}
				} catch (PasswordLengthException e) {
					System.out.println("Password should me more than 4 characters!");
				} catch (UserNameLengthException e) {
					System.out.println("Username should be more tham 4 characters");
				}
					break;
				case "3":
					System.out.println("Closing app\n");
					flag = false;
					break;
				default:
					System.out.println("Invalid selection\n");
					break;
			}
			if(!flag) {
				System.out.println("App terminated!");
			}
		}
	}

}
