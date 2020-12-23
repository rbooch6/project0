package project0;

import java.util.Scanner;

public class WelcomeScreen {
	
	public static void loginScreen() {
		System.out.println("Welcome to Bank Bank");
	}
	
	
	/**
	 * allows the user to select if they are a user or employee
	 * @return the input, once it is identified as 1 or 2
	 */
	
	public static String signInType() {//the value of this method can only be returned as the String "1" or "2"
		System.out.println("Please select a method of login by entering either 1 or 2");
		System.out.println("1: Client");
		System.out.println("2: Employee");
		Scanner sc = new Scanner(System.in);//I purposefully don't close it here because it throws an exception, as I use the scanner in another part of this code
		
		String input = null;
		
		do {//This loop makes sure the input is either 1 or 2 before ending
			if (input != null) {
				System.out.println("Please enter either 1 or 2");
			}
			input = sc.nextLine();//reads the input
		}while(!(input.equals("1")||input.equals("2")));//checks to see if the input is either 1 or 2
		
		return input;
	}
	
	/**
	 * This is the screen that the client will see
	 */
	public static void clientScreen() {
		
		//sets up scanner and variable for use with the scanner
		Scanner sc = new Scanner(System.in);
		String input = "";
		//client is used as the test client to make things run smooth, the end product would use objects from the database
		Client client = new Client("client","password");
		client.setCreditScore("good");
		//testAccount is used as the test client to make things run smooth, the end product would use objects from the database
		Account testAccount = new Account("1234", 100, "checking", "client");
		while(!(input.equals("0"))) {//the user will be asked what they want to do until they logout with 0
			
		
			//presents the options
			System.out.println("Please select an option");
			System.out.println("0: Logout");
			System.out.println("1: View my balance");
			System.out.println("2: Deposit");
			System.out.println("3: Withdraw");
			System.out.println("4: Transfer");
			System.out.println("5: View transaction history");
			System.out.println("6: Apply for line of credit");
			
			
			do {//This loop makes sure the input is either 0-6 before ending
				input = sc.nextLine();//reads the input
				
				if (!(input.equals("0")||input.equals("1")||input.equals("2")||input.equals("3")||input.equals("4")||input.equals("5")||input.equals("6"))) {//as long as input is not one of the specified values, the program reminds the user to enter a number 0-6 
					System.out.println("Please enter a number 0 through 6");
				}
				
				
			}while(!(input.equals("0")||input.equals("1")||input.equals("2")||input.equals("3")||input.equals("4")||input.equals("5")||input.equals("6")));//checks to see if the input is 0-6
			
			/*
			 * These methods need to be implemented non-static, once DB was connected I would pull data into user objects and would be able to non-staticly access the methods
			 */
			if(input.equals("1")) {//temporary method to have a useful-ish method
				do {
					System.out.println("Enter the account number: ");
					input = sc.nextLine();
				}
				while(!input.equals("1234"));
				
				System.out.println("Account number " + testAccount.getAcctNum() + " has $" + testAccount.viewBalance() + "\n");
			}
			
			//this is the option for depositing money
			else if(input.equals("2")) {
				String tempVal;
				do {
					System.out.println("Enter the account number: ");
					input = sc.nextLine();
				}
				while(!input.equals("1234"));
				
				do {
					System.out.println("Enter an amount to deposit: ");
					tempVal= sc.nextLine();
					if(!tempVal.matches("[0-9]+")) {
						System.out.println("Please enter only numbers");
					}
				}while(!tempVal.matches("[0-9]+"));
				Double val = Double.parseDouble(tempVal);
				
				System.out.println("Your old account balance was " + testAccount.viewBalance());
				testAccount.setValue(testAccount.viewBalance() + val);
				System.out.println("Your new account balance is " + testAccount.viewBalance() + "\n");
				
			}
			
			//this is the option for withdrawing money
			else if(input.equals("3")) {
				String tempVal;
				do {
					System.out.println("Enter the account number: ");
					input = sc.nextLine();
				}
				while(!input.equals("1234"));
				
				do {
					System.out.println("Enter an amount to withdraw: ");
					tempVal= sc.nextLine();
					if(!tempVal.matches("[0-9]+")) {
						System.out.println("Please enter only numbers");
					}
				}while(!tempVal.matches("[0-9]+"));
				Double val = Double.parseDouble(tempVal);
				
				if((testAccount.viewBalance() - val) < 0) {
					System.out.println("Error, cannot withdraw more than is in the account, your account balance is: " + testAccount.viewBalance());
				}
				else {
					System.out.println("Your old account balance was " + testAccount.viewBalance());
					testAccount.setValue(testAccount.viewBalance() - val);
					System.out.println("Your new account balance is " + testAccount.viewBalance() + "\n");
				}
			/*
			 * These two options have not been implemented
			 */
			}
			else if(input.equals("4")) {
				System.out.println("Needs to be implemented");
			}
			else if(input.equals("5")) {
				System.out.println("Needs to be implemented");
			}
			//this is the option for credit approval
			else if(input.equals("6")) {
				System.out.println(client.applyForLineOfCredit() + "\n");
			}
			
		}
	}
	
	/**
	 * This is the screen the employee will see
	 */
	public static void employeeScreen() {
		
		//sets up scanner and variable for use with the scanner
		Scanner sc = new Scanner(System.in);
		String input = "";
		while(!(input.equals("0"))) {//the user will be asked what they want to do until they logout with 0
			
		
			//presents the options
			System.out.println("Please select an option");
			System.out.println("0: Logout");
			System.out.println("1: Create account");
			System.out.println("2: Review credit request");
			
			
			do {//This loop makes sure the input is either 0-2 before ending
				
				input = sc.nextLine();//reads the input
				if (!(input.equals("0")||input.equals("1")||input.equals("2"))) {
					System.out.println("Please enter a number 0 through 2");
				}
				
			}while(!(input.equals("0")||input.equals("1")||input.equals("2")));//checks to see if the input is 0-2
			
			if(input.equals("1")) {
				Employee.createAccount();
			}
			else if(input.equals("2")) {
				System.out.println("needs to be implemented");
			}
		}
	}
}
