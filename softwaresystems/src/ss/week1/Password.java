package ss.week1;

public class Password {
	public static final String INITIAL = "password";
	private static String pass = INITIAL;

	public boolean testWord(String test) {
		return test.equals(pass);
	}
	
	public boolean acceptable(String suggestion) {
		if (suggestion.contains(" ") || suggestion.length() < 6 == true) {
			return false;
		} else {
			return true;
		}
			
	}
	
	public boolean setWord(String oldpass, String newpass) {
		if (testWord(oldpass) && acceptable(newpass)) {
			pass = newpass;
			return true;
		}
		return false;
	}

}