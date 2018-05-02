package snake;

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
    /**
     * Return the snakes direction.
     * @return this.direction;
     */
    public Direction getDirection() {
        return this.direction;
    }
    /**
     * Sets direction to given direction. If wrongDirection(direction) return true.
     * @param direction 
     */
    public void setDirection(Direction direction) {
        if (wrongDirection(direction)) {
            this.direction = direction;
            
        }
    }
    /**
     * Method checks if the given direction is viable to use.
     * Snake can't change to direction it was coming from.
     * 
     * @param direction
     * UP, DOWN, LEFT, RIGHT
     * 
     * @return true if given direction is viable to use, false otherwise.
     */
    public boolean wrongDirection(Direction direction) {
        if (this.direction.equals(Direction.UP) && direction.equals(Direction.DOWN)) {
            return false;
        } else if (this.direction.equals(Direction.DOWN) && direction.equals(Direction.UP)) {
            return false;
        } else if (this.direction.equals(Direction.LEFT) && direction.equals(Direction.RIGHT)) {
            return false;
        } else if (this.direction.equals(Direction.RIGHT) && direction.equals(Direction.LEFT)) {
            return false;
        }
        return true;
    }
    /**
     * Method returns the size of pieces list.
     * @return pieces.size();
     */
    public int getLeght() {
        return this.pieces.size();
    }
    /**
     * Method returns the list of pieces
     * @return pieces;
     */
    public List<Piece> getPieces() {
        return this.pieces;
    }
    /**
     * Method checks the direction snake is facing.
     * Then it moves snake to that direction.
     * It does this by adding new Piece to pieces list.
     * Then it checks the grow value.
     * When the grow value is bigger than 0 it grows the sanke.
     * Otherwise it deletes the first piece from pieces list.
     */
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
    /**
     * Grows the value of grow.
     * If pieces.size() is bigger than 2.
     */
    public void grow() {
        if (pieces.size() > 2) {
            grow++;
        }
    }
    /**
     * Method returns the value of grow
     * 
     * @return int grow
     */
    public int getGrow() {
        return grow;
    }
    /**
     * Checks if given piece is contaction with the head of the snake
     * @param piece
     * @return ture if contact with given piece, false otherwise.
     */
    public boolean contact(Piece piece) {
        return (pieces.get(pieces.size() - 1).getX() == piece.getX()
                && pieces.get(pieces.size() - 1).getY() == piece.getY());
    }
    /**
     * Checks if the head of the snake is contacting with its tail.
     * At the same time calls method contactWithWall().
     * @param x - X coordinate of piece.
     * @param y - Y coordinate of piece.
     * @return true if contact with wall or tail, false otherwise.
     */
    public boolean contactWithTail(int x, int y) {
        for (int i = 0; i < pieces.size(); i++) {
            for (int j = 0; j < pieces.size(); j++) {
                if (pieces.get(i).contact(pieces.get(j)) && i != j) {
                    return true;
                }
            }
        }
        return contactWithWall(x, y);
    }
    /**
     * Checks if head of the the snake contacts with walls.
     * @param x - X coordinate of piece.
     * @param y - Y coordinate of piece.
     * @return true if contact with wall, false otherwise.
     */
    public boolean contactWithWall(int x, int y) {
        for (int i = 0; i < x; i++) {
            if (pieces.get(pieces.size() - 1).contact(new Piece(i, -1))) {
                return true;
            }
            if (pieces.get(pieces.size() - 1).contact(new Piece(i, y))) {
                return true;
            }
        }
        for (int i = 0; i < y; i++) {
            if (pieces.get(pieces.size() - 1).contact(new Piece(-1, i))) {
                return true;
            }
            if (pieces.get(pieces.size() - 1).contact(new Piece(x, i))) {
                return true;
            }
        }
        return false;
    }
}
