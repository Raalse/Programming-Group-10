/**
 * 
 */
package ss.week5.tictactoe;

/**
 * @author raalse
 *
 */
public class ComputerPlayer extends Player {

	/**
	 * @param name
	 * @param mark
	 */
	private String name = "Naive";
	private Mark mark;
	private Strategy strategy;
	
	public ComputerPlayer(Mark mark, Strategy strategy) {
		super(strategy.getName(), mark);
		this.mark = mark;
		this.strategy = strategy;
		this.name = strategy.getName();
		// TODO Auto-generated constructor stub
	}
	
	public ComputerPlayer(Mark mark) {
		super("Naive", mark);
		this.mark = mark;
		strategy = new NaiveStrategy();
	}

	/* (non-Javadoc)
	 * @see ss.week5.tictactoe.Player#determineMove(ss.week5.tictactoe.Board)
	 */
	@Override
	public int determineMove(Board board) {
		return strategy.determineMove(board, mark);
	}

	@Override
	public String getName() {
        return name + "-" + "computer" + "-" + mark;
    }
}