
package Snake;


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
        if(piece.getX() == this.x && piece.getY() == this.y) {
            return true;
        } else {
            return false;
        }
    }
    @Override
    public String toString() {
        return "(" + this.x + "," + this.y + ")";
    }
}
