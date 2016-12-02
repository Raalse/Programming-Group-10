package ss.week3.pw;

import ss.week2.hotel.Password;
//import java.lang.System;

public class TimedPassword extends Password {

	private long validTime;
	private long startTime;
	private final long defaultDuration = 100000;
	public TimedPassword(int duration) {
		this.validTime = duration;
		startTime = System.currentTimeMillis();
	}

	public TimedPassword() {
		this.validTime = defaultDuration;
		startTime = System.currentTimeMillis();
	}
	
	public boolean isExpired() {
		if (System.currentTimeMillis() - startTime > validTime == true) {
			this.setWord(factoryPassword, this.getChecker().generatePassword());
			startTime = System.currentTimeMillis();
			return true;
		} else {
			return false;
		}
	}	
	
	public boolean setWord(String oldpass, String newpass) {
		startTime = System.currentTimeMillis();
		return super.setWord(oldpass, newpass);
	}
	
	/*public boolean testPassword(String test) {
		return test.equals(factoryPassword) && isExpired() == false;
	}*/

}

/*
 * Overwriting testPassword (testWord in Password) in the way described (false if expired)
 *  would make it impossible to change a password once it has expired.
 * We need testPassword to work even when the password has expired,
 *  in order to have a functional program.
 */