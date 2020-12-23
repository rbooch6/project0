package project0;

public class Client extends User {
	String credit;//you don't start with a credit score, so this comes in later
	
	public Client(String user, String pass) {
		super(user,pass);
	}
	
	//will return the String for the approved process. If credit score is not valid will return an error
	public String applyForLineOfCredit() {
		if(credit == null) {
			return ("Error: User has no credit score");
		}
			if(this.getCreditScore().equalsIgnoreCase("excellent")) {
				return ("Your credit score is excellent, automatic approval with low interest");
			}
			else if(this.getCreditScore().equalsIgnoreCase("good")) {
				return ("Your credit score is good, automatic approval with low-high interest");
			}
			else if(this.getCreditScore().equalsIgnoreCase("poor")) {
				return ("Your credit score is poor, requires review with high interest");
			}
			else if(this.getCreditScore().equalsIgnoreCase("bad")) {
				return("You credit score is bad, automatic denial");
			}
		return ("Something went wrong trying to retrieve credit score");
	}
	
	//getters and setters
	public void setCreditScore(String cred) {
		credit = cred;
	}
	public String getCreditScore() {
		return credit;
	}
}
