package ss.week4.tictactoe;

/**
 * Executable class for the game Tic Tac Toe. The game can be played against the
 * computer. Lab assignment Module 2
 * 
 * @author Theo Ruys
 * @version $Revision: 1.4 $
 */
public class TicTacToe {
    public static void main(String[] args) {
    	Player player1 = new HumanPlayer(args[0], Mark.XX);
    	Player player2 = new HumanPlayer(args[1], Mark.OO);
        Game match = new Game(player1, player2);
        match.start();
    }
}