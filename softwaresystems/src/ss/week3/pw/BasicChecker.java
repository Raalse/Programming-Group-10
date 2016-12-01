package ss.week3.pw;

public class BasicChecker implements Checker {

	private String pass = "password";
	
	public boolean acceptable(String word) {
		return !word.contains(" ") && word.length() > 6;
	}
	
	public String generatePassword() {
		return pass;
	}

}
