package lab7;

import java.util.ArrayList;
import java.util.List;

/**
 * Each player will have a name. This class will implement the Runnable interface. In the run method the player will repeatedly extract one token from the board.
 */
public class Player implements Runnable{
    String name;
    int points = 0;
    List<Token> tokensPlayer = new ArrayList<>();
    Game game;
    boolean over = false;
    boolean move = true;

    Player(String nume) {
        this.name = nume;
    }

    public void setGame(Game game) {
        this.game = game;
    }

    /**
     * Synchronized the game.board
     * If the game is over, return
     * Check if there are any moves to be made. If not, end game.
     * Check if the tokens from a player is the size of the progression. If so, end game.
     */
    @Override
    public synchronized void run() {
        while(!this.over) {
            synchronized (game.board) {
                if(game.isOver)
                    return;
                else {
                    if (tokensPlayer.size() == game.sizeOfProgression) {
                        game.isOver = true;
                    }
                    if (!game.movesLeft()) {
                        game.isOver = true;
                    }
                }
            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
