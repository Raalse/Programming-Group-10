/**
 * 
 */
package ss.week7.account;

/**
 * @author raalse
 *
 */
public class AccountSync {

	private static double amount = 5;
	private static int times = 5;
	private static Account account;
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		account = new Account();
		MyThread add = new MyThread(amount, times, account);
		MyThread remove = new MyThread(-amount, times, account);
		
		add.start();
		remove.start();
		/*
		Thread t1 = new Thread(add);
		Thread t2 = new Thread(remove);
		t1.start();
		t2.start();
		*/
		
		try {
			add.join();
			remove.join();
			/*
			t1.join();
			t2.join();
			*/
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("Balance = " + account.getBalance());
	}

}
