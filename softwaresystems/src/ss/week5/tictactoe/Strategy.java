/**
 * 
 */
package ss.week5.tictactoe;

/**
 * @author raalse
 *
 */
public interface Strategy {

	public String getName();
	
	public int determineMove(Board b, Mark m);
	
}
