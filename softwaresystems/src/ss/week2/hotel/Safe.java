package ss.week2.hotel;

//import ss.week1.Password;

public class Safe {
	
	/*
	// ------------------ Main -----------------------------
	public static Safe n;
	public static void main(String[] args) { 
		n = new Safe("false");
	}
	*/
	
	// ------------------ Instance variables ----------------
	
	public static final String INITIAL = "password";
	private static Password pass;
	private boolean activated = false;
	private boolean opened = false;
	
	// ------------------ Constructor ------------------------

	/**
	 * @invariant getPassword() == pass || getPassword() == null
	 */
	
    /**
     * Creates a <code>Safe</code> with the given password.
     * @param n pass of the new <code>Safe</code>
     */
	/**
	 * @ensures !this.isActive();
	 * @ensures !this.isOpen();
	 * @requires password != null;
	 */
	
	public Safe(String password) {
		pass = new Password();
		assert password != null;
		pass.setWord(INITIAL, password);
	}
	
	// ------------------ Commands --------------------------
	
	/**
	 * Activates the safe if the given <code>password</code> is correct.
	 * @param password password for activating the safe
	 */
	/**
	 * @ensures pass.testWord(password) ==> isActive();
	 * @requires password != null;
	 */
	public void activate(String password) {
		assert password != null;
		if (pass.testWord(password)) {
			activated = true;
		}
	}
	

	// A command that deactivates the safe.
	/**
	 * @requires this.isActive();
	 */
	public void deactivate() {
		activated = false;
		opened = false;
	}
	
	/**
	 * Opens the safe if the given <code>password</code> is correct.
	 * @param password password for opening the safe
	 */
	/**
	 * @requires password != null;
	 * @ensures pass.testWord(password);
	 * @requires this.isActive();
	 */
	public void open(String password) {
		assert password != null;
		if (pass.testWord(password) && this.activated) {
			opened = true;
		}
	}
	
	
	// A command that closes the safe.
	/**
	 * @requires this.isOpen() && this.isActive();
	 */
	public void close() {
		opened = false;
	}
	
	// ------------------ Queries --------------------------
	
	/**
	 * A query that indicates whether or not the safe is active.
     * @return the state of this <code>Safe</code>;
     */
	/**@pure */
	public boolean isActive() {
		return activated;
	}
	
	/**
	 * A query that indicates whether or not the safe is open.
	 * @return if this <code>Safe</code> is open.
	 */
	/**@pure */
	public boolean isOpen() {
		return opened;
	}
	
	/** 
	 * A query that returns the password object.
	 * @return the password of this <code>Safe</code>.
	 */
	/**@pure */
	public Password getPassword() {
		return pass;
	}
}

/*P-2.12
 - Running it as usual gives no error whatsoever.
 - Running it with "-ea" in VM Arguments gives us:
 Exception in thread "main" java.lang.AssertionError
	at ss.week2.hotel.Safe.<init>(Safe.java:28)    (the assert line)
	at ss.week2.hotel.Safe.main(Safe.java:10)      (the erroneous call line)
	
 - "-ea" tells the Virtual Machine to not overlook (as is default) the "assert" statements,
  thus making sure to check the written code.

 */