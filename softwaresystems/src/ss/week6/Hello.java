package ss.week6;

import java.util.Scanner;

/**
 * @author raalse
 *
 */
public class Hello {
	
	/**
	 * 
	 */
	public Hello() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String name;
		while (in.hasNextLine() && !(name = in.nextLine()).equals("")) {
			System.out.println("Hello " + name);
		}
		in.close();
	}

}
