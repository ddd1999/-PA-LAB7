package lab7;

import java.util.ArrayList;
import java.util.List;

/**
 * max=maximum number of tokens on the board
 * tokensOnBoard is a list of numbers that are on the tokens on the board (from 1 to m)
 */
public class Board {
    int max;
    List<Token> tokensOnBoard = new ArrayList<>();

    public List<Token> getTokensOnBoard() {
        return tokensOnBoard;
    }

    public int nrAvailableTokens () {
        int points = 0;
        for (Token token : tokensOnBoard)
            if (!token.taken)
                points++;
        return points;
    }

    /**
     * @Board(int m) is the constructor that initialises the board
     */
    Board(int m) {
        this.max = m;
        for (int i = 1; i <= max; i++) {
            Token token = new Token(i);
            this.tokensOnBoard.add(token);
        }
    }

    /**
     * creates the board with the list of tokens
     */
    Board(List<Integer> numbers) {
        for (int number : numbers) {
            Token token = new Token(number);
            this.tokensOnBoard.add(token);
        }
    }

}
