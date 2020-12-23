package project0;

import org.junit.*;

public class Tests {
	
	static Client c = new Client("user", "password");//made for most passing tests
	static Client f = new Client("user","password");//made for more failing tests
	static Employee emp1 = new Employee("worker","pass","123");
	
	
	@BeforeClass
	public static void testUpdateCredit(){
		c.setCreditScore("bad");
	}
	
	@BeforeClass
	public static void testUpdateCreditFail(){
		f.setCreditScore("dsa");
	}
	
	@Test
	public void testLineOfCredit() {
		c.applyForLineOfCredit();
	}
	
	@Test
	public void testLineOfCreditFail() {
		f.applyForLineOfCredit();
	}
	
	@Test
	public void testEmployeeLogin() {
		System.out.println("Tests Employee login, user is 'worker' and password is 'pass' and employee number is 123");
		emp1.login();
	}
	
	@Test
	public void testClientLogin() {
		System.out.println("Tests client login, user is 'user' and password is 'password'");
		c.login();
	}
	
	@Test
	public void testInputClass(){
		System.out.println("Runs the test input class which tests many different parts of the code.");
		System.out.println("sign-in credentials for 1 are user:steverbeaver password:password");
		System.out.println("sign-in credentials for 2 are user:worker password:password employee number: 123\n");
		TestInput.test();
	}
}

