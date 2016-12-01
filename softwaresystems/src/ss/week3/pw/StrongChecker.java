package ss.week3.pw;

public class StrongChecker extends BasicChecker implements Checker {

	private String pass = "password123";
	
	public boolean acceptable(String word) {
		return super.acceptable(word) && !Character.isDigit(word.charAt(0)) && Character.isDigit(word.charAt(word.length() - 1));
	}
	
	public String generatePassword() {
		return pass;
	}

}
