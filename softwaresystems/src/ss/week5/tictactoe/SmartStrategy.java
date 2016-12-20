/**
 * 
 */
package ss.week5.tictactoe;

import java.util.Random;

/**
 * @author raalse
 *
 */
public class SmartStrategy implements Strategy {

	/**
	 * 
	 */
	public SmartStrategy() {
		// TODO Auto-generated constructor stub
	}

	/* (non-Javadoc)
	 * @see ss.week5.tictactoe.Strategy#getName()
	 */
	@Override
	public String getName() {
		return "Smart";
	}

	/* (non-Javadoc)
	 * @see ss.week5.tictactoe.Strategy#determineMove(ss.week5.tictactoe.Board, ss.week5.tictactoe.Mark)
	 */
	@Override
	public int determineMove(Board b, Mark m) {
		int dimensions = b.DIM * b.DIM;
		for (int i = 0; i < dimensions; i++) {
			if (b.isEmptyField(i)) {
				Board copy1 = b.deepCopy();
				copy1.setField(i, m);
				if (copy1.isWinner(m)) {
					return i;
				}
				
				Board copy2 = b.deepCopy();
				copy2.setField(i, m.other());
				if (copy2.isWinner(m.other())) {
					return i;
				}
			}
		}
		
		if (b.DIM % 2 != 0) {
			int middle = b.DIM / 2;
			if (b.isEmptyField(middle, middle)) {
				return b.index(middle, middle);
			}
		}
		
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
