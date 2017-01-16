/**
 * 
 */
package ss.week7.threads;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;


/**
 * @author raalse
 *
 */
public class FinegrainedIntCell implements IntCell {
	
	private final Lock lock = new ReentrantLock();
	private final Condition isEmpty = lock.newCondition();
	private final Condition isFull = lock.newCondition();
	private int value = 0;
	private boolean empty = true;
	
	/* (non-Javadoc)
	 * @see ss.week7.threads.IntCell#setValue(int)
	 */
	@Override
	public void setValue(int val) {
		lock.lock();
		while (!empty) {
			try {
				isEmpty.await();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		this.value = val;
		empty = false;
		isFull.signalAll();
		lock.unlock();
	}

	/* (non-Javadoc)
	 * @see ss.week7.threads.IntCell#getValue()
	 */
	@Override
	public int getValue() {
		lock.lock();
		while (empty) {
			try {
				isFull.await();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		empty = true;
		isEmpty.signalAll();
		lock.unlock();
		return value;
	}


}
