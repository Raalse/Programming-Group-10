package ss.week7.threads;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class TestSyncConsole extends Thread {
	
	private int sum;
	static final Lock lock = new ReentrantLock();
	
	public TestSyncConsole(String name) {
		super(name);
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		new TestSyncConsole("Thread A").start();
		new TestSyncConsole("Thread B").start();
	}
	
	private synchronized void sum() {
		int a = SyncConsole.readInt("get number 1?");
		int b = SyncConsole.readInt("get number 2?");
		sum = a + b;
		
		SyncConsole.println(a + " + " + b + " = " + sum);
	}
	
	public void run() {
		lock.lock();
		try {
			sum();
		} finally {
			lock.unlock();
		}
	}

}
