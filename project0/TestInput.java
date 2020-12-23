package project0;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;


public class TestInput {
	
	public static void test(){
		
		
			WelcomeScreen.loginScreen();
			String user = WelcomeScreen.signInType();
			
			//creates two variables for testing
			Employee worker = new Employee("employee", "password", "123");
			Client steve = new Client("client","password");
			steve.setCreditScore("good");
			
			if(user.equals("1")) {//if the user is a Client we go to this
				steve.login();
				WelcomeScreen.clientScreen();
				
			}
			if(user.equals("2")) {//if the user is an Employee we go to this
				worker.login();
				WelcomeScreen.employeeScreen();
			}
			
			System.out.println("Goodbye");//prints once the program is finished
	}
}