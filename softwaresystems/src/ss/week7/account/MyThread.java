/**
 * 
 */
package ss.week7.account;

/**
 * @author raalse
 *
 */
public class MyThread extends Thread {
//public class MyThread implements Runnable {
	
	double theAmount;
	int theFrequency;
	Account theAccount;
	
	public MyThread(double amount, int frequency, Account account) {
		this.theAmount = amount;
		this.theFrequency = frequency;
		this.theAccount = account;
	}
	
	public void run() {
		for (int i = 1; i <= theFrequency; i++) {
			theAccount.transaction(theAmount);
		}
	}
}
