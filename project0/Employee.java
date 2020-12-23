package project0;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Employee extends User {
	String employeeNumber;
	
	public Employee(String user, String pass, String empNum) {
		super(user, pass);
		employeeNumber = empNum;
	}
	
	/**
	 * overrides the login of the user class
	 */
	@Override
	public void login() {
		Scanner sc = new Scanner(System.in);//sets up scanner

		do {//checks the username and password until they get them correct. Start of 'do-while' loop
			
			String name= userCheck();
			
			//Asks for password
			System.out.print("Enter password (password is case-sensitive): ");
			String pass = sc.nextLine();
			
			//Asks for Employee number
			System.out.print("Enter Employee number: ");
			String empNum = sc.nextLine();
			
			//if both are correct, user may now access rest of methods
			if(name.toLowerCase().equals(username.toLowerCase()) && pass.equals(password) && employeeNumber.equals(empNum)) {
				System.out.println("\nWelcome " + username + "\n");
				login = true;
			}
			else {//otherwise, the program tells them they are incorrect and lets them try again
				System.out.println("Username, password or Employee number was incorrect");
			}
		}
		while(login == false);//end of do-while loop
	}

	/**
	 * Creates an account with the given user input
	 */
	public static void createAccount() {
		Scanner sc = new Scanner(System.in);//sets up scanner
		String acctNum, type, user, tempVal;
		double val = 0;
		
		//makes sure the input is a number
		do {
			System.out.println("Enter an account number: ");
			acctNum = sc.nextLine();
			if(!acctNum.matches("[0-9]+")) {
				System.out.println("Please enter only numbers");
			}
		}while(!acctNum.matches("[0-9]+"));
		
		
		//makes sure the input is a number
		do {
			System.out.println("Enter an amount in the account: ");
			tempVal= sc.nextLine();
			if(!tempVal.matches("[0-9]+")) {
				System.out.println("Please enter only numbers");
			}
		}while(!tempVal.matches("[0-9]+"));
		val = Double.parseDouble(tempVal);
		
		
		//makes sure the input is either 'checking' or 'saving'
		do {
			System.out.println("Enter the type of account(checking/saving): ");
			type = sc.nextLine().toLowerCase();
		}
		while(!(type.equals("checking")||type.equals("saving")));
		
		
		//account username will need to be checked if it exists, but for now any username is allowed
		System.out.println("Enter the username this account will be associated with: ");
		user = sc.nextLine().toLowerCase();
		
		//once all the values are checked and safe, account is created
		Account test = createAccount(acctNum, val, type, user);
		System.out.println("Account:\n" + test + "\nhas been created\n");
		
		}
	
	/**
	 * creates a new bank account, this is where the database being implemented will be able to see whether or not the account number is already taken
	 * 
	 * @param acctNum ID number of the account
	 * @param val amount of money in the account
	 * @param type states whether account is saving or checking
	 * @param user the username the account is tied to
	 * 
	 */
	//
	private static Account createAccount(String acctNum, double val, String type, String user) {
		return new Account(acctNum, val, type, user);
	}
	}

