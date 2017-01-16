package ss.week7.account;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Account {
	protected double balance = 0.0;
	private Lock lock = new ReentrantLock();
	private Condition tooLow = lock.newCondition();

	public synchronized void transaction(double amount) {
		lock.lock();
		try {
			if (balance + amount < -1000) {
				tooLow.await();
			}
			if (amount > 0) {
				balance = balance + amount;
				tooLow.signal();
			}
			else {
				balance = balance + amount;
			}
		}
		catch (InterruptedException e) {
			e.printStackTrace();
		}
		finally {
			lock.unlock();
		}
	}
	public double getBalance() {
		return balance;

	}
}
