package com.capgemini.hotelbooking.ui;

import java.util.Scanner;

import com.capgemini.hotelbooking.bean.User;
import com.capgemini.hotelbooking.service.UserBookingServiceImpl;
import com.capgemini.hotelbooking.service.UserVerifyServiceImpl;

public class HotelApp {

	public static void main(String[] args) {
		
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		boolean flag = true;
		UserVerifyServiceImpl service = new UserVerifyServiceImpl();
		User user = null;
		while(flag) {
			System.out.println("\tWelcome to hotel booking app!\n");
			System.out.println("1.Login");
			System.out.println("2.Register");
			System.out.println("3.Exit");
			System.out.print("Enter your choice:");
			String choice = sc.nextLine();
			switch(choice) {
				case "1":
					System.out.println("Logging you in...\n");
					System.out.println("Enter username:");
					String userName = sc.nextLine();
					System.out.println("Enter password:");
					String password = sc.nextLine();
					
					user = new User(userName,password);
					int verify = service.checkUser(user);
					if(verify == 1) {
						System.out.println("Successfully Logged in...\n");
						boolean flag2 = true;
						while(flag2) {
							UserBookingServiceImpl userBooking = new UserBookingServiceImpl(verify);
							System.out.println("1.Book a new Hotel Room");
							System.out.println("2.View My bookings");
							System.out.println("3.Back");
							System.out.println("Select an opiton");
							String option1 = sc.nextLine();
							switch(option1) {
								case "1":
									String hotel = userBooking.searchRooms(user);
									if(hotel != null) {
									userBooking.bookRooms(user, hotel);
									}break;
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
					else if(verify == 2) {
						System.out.println("Welcome , admin");
						boolean flag3 = true;
						while(flag3) {
							UserBookingServiceImpl userBooking = new UserBookingServiceImpl(verify);
							System.out.println("1. Add hotels");
							System.out.println("2. View hotels");
							System.out.println("3. Back");
							System.out.println("Select an option: ");
							String option2 = sc.nextLine();
							switch(option2) {
							case "1":
								if(userBooking.addHotels()) {
									System.out.println("Succesfully added a hotel!");
								}
								else {
									System.out.println("Failed to add the hotel or It already exists");
								}
								break;
							case "2":
								userBooking.viewHotels();
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
					else {
						System.out.println("\nInvalid credentials!\n");
					}
					break;
				case "2":
					System.out.println("Registering as a new user...\n");
					System.out.println("Enter a username:");
					userName = sc.nextLine();
					System.out.println("Enter a password:");
					password = sc.nextLine();
					
					user = new User(userName,password);
					boolean register = service.addUser(user);
					if(register) {
						System.out.println("Successfully added a new user\n");
					}
					else {
						System.out.println("User already exists\n");
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
