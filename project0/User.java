package project0;

import java.util.Scanner;

public class User {
	protected String username;
	protected String password;
	boolean login = false;//allows the user to access all methods once set to 'true' in the login() method
	
	public User(String uN, String pW) {//Constructor for the user class
		username = uN;
		this.setPassword(pW);
	}
	
	/**
	 * The purpose of the below method is to check the user name to make sure it exists within the database
	 * however, a data base has yet to be implemented so the comment within the method is where that implementaion shall go
	 */
	
	public static String userCheck() {
		Scanner sc = new Scanner(System.in);//sets up scanner
		//Asks for username
		System.out.print("Enter username: ");
		String name = sc.nextLine();
		
		//code for data base checking
		return name;
	}
	
	/**
	 * logs the user in and allows them to access the rest of the methods
	 */
	
	public void login() {
		Scanner sc = new Scanner(System.in);//sets up scanner

		do {//checks the username and password until they get them correct. Start of 'do-while' loop
			
			String name= userCheck();
			
			//Asks for password
			System.out.print("Enter password (password is case-sensitive): ");
			String pass = sc.nextLine();
			
			//if both are correct, user may now access rest of methods
			if(name.toLowerCase().equals(username.toLowerCase()) && pass.equals(password)) {
				
				System.out.println("\nWelcome " + username + "\n");
				login = true;
			}
			else {//otherwise, the program tells them they are incorrect and lets them try again
				System.out.println("Username or password was incorrect");
			}
		}
		while(login == false);//end of do-while loop
	}
	public String deposit(int actNum, double amount){//incomplete method
		if(login) {
			return("Success");
		}
		else {
			return("Error: you are not logged in");
		}
	}
	/**
	 * 
	 * @param actNum
	 * @param amount
	 * @return A string stating if the transaction was a success or not
	 */
	public String withdraw(int actNum, double amount) {//incomplete method
		if(login) {
			return("Success");
		}
		else {
			return("Error: you are not logged in");
		}
	}
	
	/**
	 * 
	 * @param actNumFrom
	 * @param actNumTo
	 * @param amount
	 * @return A string stating if the transaction was a success or not
	 */
	public String transfer(int actNumFrom, int actNumTo, int amount) {//incomplete method
		if(login) {
			this.withdraw(actNumFrom, amount);
			this.deposit(actNumTo, amount);
		return("Success");
		}
		else {
			return("Error: you are not logged in");
		}
	}
	
	/**
	 * 
	 * @param actNum
	 * @return A string stating if the transaction was a success or not
	 */
	public String viewTransactionHistory(int actNum) {//incomplete method

		if(login) {
			return("Success");
		}
		else {
			return("Error: you are not logged in");
		}
	}
	
	/**
	 * 
	 * @param newP new password
	 * 
	 * sets the password for the account
	 */
	public void setPassword(String newP) {//sets a new password and warns the user if the password is weak
		password = newP;
		if(password.length() < 8) {
			System.out.println("Warning: Password may be weak");
		}
	}
	public String getUsername() {
		return username;
	}
}
