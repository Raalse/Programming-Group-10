package ss.week3.pw;

public class StrongChecker extends BasicChecker implements Checker {

	private String pass = "password123";
	
	public boolean acceptable(String word) {
		if (!word.contains(" ") && word.length() > 6 && !Character.isDigit(word.charAt(0)) && Character.isDigit(word.charAt(word.length() - 1))) {
			return true;
		} else {
			return false;
		}
	}
	
	public String generatePassword() {
		return pass;
	}

}
