package ss.week3.pw;

public class BasicChecker implements Checker {

	private static String INITPASS = "password";
	
	public boolean acceptable(String word) {
		return !word.contains(" ") && word.length() > 6;
	}
	
	public String generatePassword() {
		return INITPASS;
	}

}
