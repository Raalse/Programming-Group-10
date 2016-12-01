package ss.week2.hotel;

import ss.week3.pw.*;

public class Password {
	public static final String INITIAL = "password";
	private static String pass = INITIAL;
	private Password password;
	private Checker checker;
	private String factoryPassword;
	
	public Password(Checker checker) {
		this.checker = checker;
		factoryPassword = checker.generatePassword();
	}
	public Password() {
		this(new BasicChecker());
	}

	public boolean testWord(String test) {
		return test.equals(checker.generatePassword());
	}
	
	public boolean acceptable(String suggestion) {
		return checker.acceptable(suggestion);
	}
	
	public boolean setWord(String oldpass, String newpass) {
		if (testWord(oldpass) && acceptable(newpass)) {
			pass = newpass;
			return true;
		}
		return false;
	}
	
	

}