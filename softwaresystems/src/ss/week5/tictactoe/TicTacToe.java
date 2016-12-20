package ss.week5.tictactoe;

import java.io.*;

/**
 * Executable class for the game Tic Tac Toe. The game can be played against the
 * computer. Lab assignment Module 2
 * 
 * @author Theo Ruys
 * @version $Revision: 1.4 $
 */
public class TicTacToe {
    public static void main(String[] args) {
    	
    	Player player1;
    	Player player2;
    	Strategy naive = new NaiveStrategy();
    	Strategy smart = new SmartStrategy();
    	
    	if (args[0].equals("-N")) {
    		player1 = new ComputerPlayer(Mark.XX);
    	} else if (args[0].equals("-S")) {
    		player1 = new ComputerPlayer(Mark.XX, smart);
	    } else {
	    	player1 = new HumanPlayer(args[0], Mark.XX);
	    }
    	
    	if (args[1].equals("-N")) {
    		player2 = new ComputerPlayer(Mark.OO);
    	} else if (args[1].equals("-S")) {
    		player2 = new ComputerPlayer(Mark.OO, smart);
	    } else {
	    	player2 = new HumanPlayer(args[1], Mark.OO);
	    }
    	
        Game match = new Game(player1, player2);
        
        System.setIn(new UncloseableInputStream());
        
        match.start();
    }
    
    /**
     * Wraps an input stream to prevent it from being closed.
     */
    private static class UncloseableInputStream extends FilterInputStream {

        /**
         * Creates a wrapper around {@link System.in}.
         */
        UncloseableInputStream() {
            this(System.in);
        }

        /**
         * Creates a wrapper around an arbitrary {@link InputStream}.
         * @param stream The stream to wrap.
         */
        UncloseableInputStream(InputStream stream) {
            super(stream);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public void close() throws IOException {
            // Don't do anything
        }
    }
}