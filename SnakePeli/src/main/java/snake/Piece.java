package snake;

public class Piece {

    int x;
    int y;

    public Piece(int x, int y) {
        this.x = x;
        this.y = y;
    }
    /**
     * Gets the x coordinate of piece.
     * @return x
     */
    public int getX() {
        return x;
    }
    /**
     * Gets the y coordinate of piece.
     * @return y
     */
    public int getY() {
        return y;
    }
    /**
     * Sets x coordinate of piece.
     * @param x 
     */
    public void setX(int x) {
        this.x = x;
    }
    /**
     * Sets y coordinate of piece.
     * @param y 
     */
    public void setY(int y) {
        this.y = y;
    }
    /**
     * Checks if piece is in contact with given piece.
     * @param piece
     * @return 
     * true if contact with given piece, false otherwise.
     */
    public boolean contact(Piece piece) {
        return piece.getX() == this.x && piece.getY() == this.y;
    }
    /**
     * Returns the coordinates of the piece in string.
     * @return "(" + this.x + "," + this.y + ")"
     */
    @Override
    public String toString() {
        return "(" + this.x + "," + this.y + ")";
    }
}
