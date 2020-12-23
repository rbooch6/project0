package project0;

public class Account {
	
	private String acctNum;//the number associated for an account
	private double value;//the amount of money in the account
	private String type;//checking or saving
	private String username;//this ties the account to a user
	
	
	/**
	 * 
	 * @param aN account number
	 * @param val amount in the account
	 * @param t the type of the account (checking/saving)
	 * @param user the user name
	 */
	public Account(String aN, double val, String t, String user) {//an account must be set up with these four variables
		acctNum = aN;
		value = val;
		type = t;
		username = user;
	}
	
	//getters and setter for appropriate values
	public double viewBalance() {
		return value;
	}
	public String getAcctNum() {
		return acctNum;
	}
	public String getType() {
		return type;
	}
	public void setValue(Double in) {//value is the only thing that can change after everything's assigned
		value = in;
	}
	public String getUsername() {
		return username;
	}
	
	/**
	 * overrides the toString method from the string class so an account can be printed in an organized way
	 */
	@Override
	public String toString() {
		return ("Account number: " + getAcctNum() + 
				"\nValue: $" + viewBalance() + 
				"\nType: " + getType() + 
				"\nUsername associated with account: " + getUsername());
	}
}
