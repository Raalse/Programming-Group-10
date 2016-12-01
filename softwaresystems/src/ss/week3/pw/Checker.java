package ss.week3.pw;

public interface Checker {
	
	/**
	 * Perform this verification for the specified word.
	 * Return true if the implementation of this method considers this word a valid password.
	 */
	boolean acceptable(String word);
	
	String generatePassword();
	
}
