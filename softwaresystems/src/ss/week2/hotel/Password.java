package ss.week2.hotel;

import ss.week3.pw.*;

public class Password {
	public static final String INITIAL = "password";
	private static String pass = INITIAL;
	private Password password;
	private Checker checker;
	private BasicChecker basicChecker;
	private String factoryPassword;
	
	public Password(Checker checker) {
		password = new Password();
		factoryPassword = checker.generatePassword();
	}
	public Password() {
		password = new Password(basicChecker);
		//factoryPassword = basicChecker.generatePassword();
	}

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