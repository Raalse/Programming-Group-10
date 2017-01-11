package ss.week6;

import java.util.Scanner;

/**
 * @author raalse
 *
 */
public class Words {

	/**
	 * 
	 */
	public Words() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int i = 0;
		Scanner in = new Scanner(System.in);
		String sentence;
		String firstWord;
		System.out.println("Please write a sentence (or 'end' to terminate):");
		while (in.hasNextLine()) {
			firstWord = in.next();
			i++;
			if (firstWord.equals("end")) {
				in.close();
				break;
			} else {
				sentence = in.nextLine();
				System.out.print(firstWord);
				System.out.println(sentence.replaceAll("\\s+", "\n") + "\n");
			}
			System.out.println("Please write a sentence (or 'end' to terminate):");
		}
		in.close();

	}

}

//The quick brown fox jumps over the lazy dog.