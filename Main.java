package lab7;

import java.util.Arrays;

/**
 * Instances for players
 * Initialises the board
 * Set up the game
 * Start the game
 */
public class Main {

    public static void main(String[] args) {
        Player player1 = new Player("PLAYER 1");
        Player player2 = new Player("PLAYER 2");
        Player player3 = new Player("PLAYER 3");

        Board tabla = new Board(Arrays.asList(0,0, 1, 2, 3, 4, 5, 6, 7, 8));
        Game game = new Game(10, tabla, Arrays.asList(player1, player2, player3));
        game.startGame();
    }
}
