package ss.week3.hotel;

import ss.week3.pw.*;

public class Password {
	public static final String INITIAL = "password";
	//private static String pass = INITIAL;
	private Checker checker;
	protected static String factoryPassword;
	
	public Password(Checker checker) {
		this.checker = checker;
		factoryPassword = checker.generatePassword();
	}
	public Password() {
		this(new BasicChecker());
	}

	public boolean testWord(String test) {
		return test.equals(factoryPassword);
	}
	
	public boolean acceptable(String suggestion) {
		return checker.acceptable(suggestion);
	}
	
	public boolean setWord(String oldpass, String newpass) {
		if (testWord(oldpass) && acceptable(newpass)) {
			factoryPassword = newpass;
			return true;
		}
		return false;
	}
	
	public Checker getChecker() {
		return this.checker;
	}
	
	public String factoryPassword() {
		return factoryPassword;
	}
	
	

}