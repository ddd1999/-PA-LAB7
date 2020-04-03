package lab7;

import java.util.ArrayList;
import java.util.List;

/** Game class
 * Simulates the game using a thread for each player.
 */
public class Game extends Thread{
    int sizeOfProgression;
    Board board;
    boolean isOver = false;
    List<Player> players = new ArrayList<Player>();

    public boolean isOver() {
        return isOver;
    }

    public void setOver(boolean isOver) {
        this.isOver = isOver;
    }

    /**
     * Check if there are any moves left to be made.
     * @return
     */
    public boolean movesLeft() {
        for (Player player : players)
            if(!player.over)
                return true;
        return false;
    }

    /**
     * Constructor for setting the game.
     * @param sizeOfProgression
     * @param board
     * @param players
     */
    Game(int sizeOfProgression, Board board, List<Player> players) {
        this.sizeOfProgression = sizeOfProgression;
        this.board = board;
        this.players = players;

        for (Player player : players) {
            player.setGame(this);
        }
    }

    /**
     * A thread for each player
     */
    public void startGame() {
        List<Thread> threads = new ArrayList<Thread>();
        for (Player player : players) {
            Thread thread = new Thread(player);
            threads.add(thread);
        }
        for (Thread thread : threads) {
            thread.start();
        }
        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
