package ss.week3.pw;

public class BasicChecker implements Checker {

	private String pass = "password";
	
	public boolean acceptable(String word) {
		if (!word.contains(" ") && word.length() > 6) {
			return true;
		} else {
			return false;
		}
	}
	
	public String generatePassword() {
		return pass;
	}

}
