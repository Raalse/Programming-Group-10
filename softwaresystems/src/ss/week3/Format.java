package ss.week3;

public class Format {
	
	public static void main(String[] args) {
		printLine("text1", 1.00);
		printLine("other text", -12.12);
		printLine("something", 0.20);
	}

	public static void printLine(String text, double amount) {
		System.out.format("%-20s %10.2f \n", text, amount);
	}

}
