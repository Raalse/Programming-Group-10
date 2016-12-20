/**
 * 
 */
package ss.week5.tictactoe;

import java.util.Random;

/**
 * @author raalse
 *
 */
public class NaiveStrategy implements Strategy {
	
	public NaiveStrategy() {
		// TODO Auto-generated constructor stub
	}

	/* (non-Javadoc)
	 * @see ss.week5.tictactoe.Strategy#getName()
	 */
	@Override
	public String getName() {
		return "Naive";
	}

	/* (non-Javadoc)
	 * @see ss.week5.tictactoe.Strategy#determineMove(ss.week5.tictactoe.Board, ss.week5.tictactoe.Mark)
	 */
	@Override
	public int determineMove(Board b, Mark m) {
		
		/*
		int random = 0;
	    while (true) {
	    	random = (int) (Math.random() * 10);
	    	//random = new Random().nextInt(9);
			if (b.isEmptyField(random)) {
				return random;
			}
		}
		*/
	    
		int dimensions = b.DIM * b.DIM;
		int[] arr = new int[dimensions];
		int j = -1;
		for (int i = 0; i < dimensions; i++) {
			if (b.isEmptyField(i)) {
				arr[++j] = i;
			}
		}
		return arr[new Random().nextInt(j + 1)];
	}

}
