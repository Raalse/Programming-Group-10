/**
 * 
 */
package ss.week7.threads;

/**
 * @author raalse
 *
 */
public class SynchronizedCell implements IntCell {
	private int value = 0;
	private boolean empty = true;
	
	/* (non-Javadoc)
	 * @see ss.week7.threads.IntCell#setValue(int)
	 */
	@Override
	public synchronized void setValue(int val) {
		while (!empty) {
			try {
				this.wait();
				
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		this.value = val;
		empty = false;
		this.notifyAll();
	}

	/* (non-Javadoc)
	 * @see ss.week7.threads.IntCell#getValue()
	 */
	@Override
	public synchronized int getValue() {
		while (empty) {
			try {
				this.wait();
				
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		empty = true;
		this.notifyAll();
		return value;
	}

}
