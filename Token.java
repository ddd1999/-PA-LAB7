package lab7;

/**
 * An instance of this class will hold a number from 1 to m. We use 0 for the blank token.
 * taken shows if the token was used by a player
 */
public class Token {
        int number;
        boolean taken;

    Token(){}

    Token(int value) {
        this.number = value;
        this.taken = false;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int nr) {
        this.number = nr;
    }
}
