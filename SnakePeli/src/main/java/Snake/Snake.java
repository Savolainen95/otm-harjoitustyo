package Snake;

import java.util.*;

public class Snake {

    private List<Piece> pieces = new ArrayList<>();
    private Direction direction;
    private int grow;

    public Snake(int startingX, int startingY, Direction startingdirection) {
        this.pieces.add(new Piece(startingX, startingY));
        this.direction = startingdirection;
        this.grow = 2;
    }

    public Direction getDirection() {
        return this.direction;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    public int getLeght() {
        return this.pieces.size();
    }

    public List<Piece> getPieces() {
        return this.pieces;
    }

    public void move() {
        int startingX = pieces.get(pieces.size() - 1).getX();
        int startingY = pieces.get(pieces.size() - 1).getY();

        switch (this.direction) {
            case DOWN:
                startingY++;
                break;
            case UP:
                startingY--;
                break;
            case RIGHT:
                startingX++;
                break;
            default:
                startingX--;
                break;
        }
        pieces.add(new Piece(startingX, startingY));
        if (grow > 0) {
            grow--;
        } else {
            pieces.remove(0);
        }

    }

    public void grow() {
        if (pieces.size() > 2) {
            grow++;
        }
    }

    public boolean contact(Piece piece) {
        //  if (pieces.stream().map(Piece::getX).anyMatch(i -> i == piece.getX()) && pieces.stream().map(Piece::getY).anyMatch(i -> i == piece.getY())) {
        if (pieces.get(pieces.size() - 1).getX() == piece.getX() && pieces.get(pieces.size() - 1).getY() == piece.getY()) {
            return true;

        } else {
            return false;
        }
    }

    public boolean contactWithTail(int x, int y) {
        boolean hit = false;

        for (int i = 0; i < pieces.size(); i++) {
            for (int j = 0; j < pieces.size(); j++) {
                if (pieces.get(i).contact(pieces.get(j)) && i != j) {
                    hit = true;
                }
            }
        }
        for (int i = 0; i < x; i++) {
            if (pieces.get(pieces.size() - 1).contact(new Piece(i, -1))) {
                hit = true;
            }
        }
        for (int i = 0; i < x; i++) {
            if (pieces.get(pieces.size() - 1).contact(new Piece(i, y))) {
                hit = true;
            }
        }
        for (int i = 0; i < y; i++) {
            if (pieces.get(pieces.size() - 1).contact(new Piece(-1, i))) {
                hit = true;
            }
        }
        for (int i = 0; i < y; i++) {
            if (pieces.get(pieces.size() - 1).contact(new Piece(x, i))) {
                hit = true;
            }
        }

        return hit;
    }
}
