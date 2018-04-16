
package snake;


public class Piece {
    int x;
    int y;
    public Piece(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
    public boolean contact(Piece piece) {
        return piece.getX() == this.x && piece.getY() == this.y;
    }
    @Override
    public String toString() {
        return "(" + this.x + "," + this.y + ")";
    }
}
