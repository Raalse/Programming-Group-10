/**
 * 
 */
package ss.week7.threads;

/**
 * @author raalse
 *
 */
public class TestConsole extends Thread {
	
	public TestConsole(String name) {
		super(name);
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		new TestConsole("Thread A").start();
		new TestConsole("Thread B").start();
	}
	
	private void sum() {
		int a = Console.readInt("get number 1?");
		int b = Console.readInt("get number 2?");
		int sum = a + b;
		
		Console.println(a + " + " + b + " = " + sum);
	}
	
	public void run() {
		sum();
	}
}
