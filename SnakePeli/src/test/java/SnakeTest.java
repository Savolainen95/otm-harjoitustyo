
import snake.Snake;
import snake.Direction;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import snake.Piece;

public class SnakeTest {

    Snake snake;

    @Before
    public void setUp() {
        snake = new Snake(15, 15, Direction.DOWN);
    }

    @Test
    public void changeDirection() {
        assertEquals(snake.getDirection(), Direction.DOWN);
        snake.setDirection(Direction.LEFT);
        assertEquals(snake.getDirection(), Direction.LEFT);
        snake.setDirection(Direction.RIGHT);
        snake.setDirection(Direction.DOWN);
        assertEquals(snake.getDirection(), Direction.DOWN);
        snake.setDirection(Direction.RIGHT);
        assertEquals(snake.getDirection(), Direction.RIGHT);
        snake.setDirection(Direction.UP);
        assertEquals(snake.getDirection(), Direction.UP);
    }

    @Test
    public void snakeGrow() {
        assertEquals(snake.getLeght(), 1);

    }

    @Test
    public void snakeMove() {
        Snake sake = new Snake(15, 15, Direction.DOWN);
        assertEquals(snake.getPieces().get(0).getY(), sake.getPieces().get(0).getY());
        snake.move();
        snake.move();
        assertEquals(snake.getPieces().get(0).getY(), sake.getPieces().get(0).getY());
        snake.move();
        assertNotSame(snake.getPieces().get(0).getY(), sake.getPieces().get(0).getY());
        //  assertNotSame(snake.getPieces(), sake.getPieces());
    }

    @Test
    public void wrongDirectionTest() {
        assertFalse(snake.wrongDirection(Direction.UP));
        snake.setDirection(Direction.LEFT);
        assertFalse(snake.wrongDirection(Direction.RIGHT));
        snake.setDirection(Direction.UP);
        assertFalse(snake.wrongDirection(Direction.DOWN));
        snake.setDirection(Direction.RIGHT);
        assertFalse(snake.wrongDirection(Direction.LEFT));
        assertTrue(snake.wrongDirection(Direction.DOWN));
    }

    @Test
    public void contactTest() {
        Piece piece = new Piece(1, 1);
        assertFalse(snake.contact(piece));
        piece.setX(snake.getPieces().get(snake.getPieces().size() - 1).getX());
        piece.setY(snake.getPieces().get(snake.getPieces().size() - 1).getY());
        assertTrue(snake.contact(piece));
    }

    @Test
    public void growTest() {
        assertEquals(snake.getGrow(), 2);
        snake.grow();
        assertEquals(snake.getGrow(), 2);
        snake.getPieces().add(new Piece(1, 1));
        snake.getPieces().add(new Piece(1, 2));
        snake.grow();
        assertEquals(snake.getGrow(), 3);
    }
    @Test
    public void contactWithTailTest() {
        assertFalse(snake.contactWithTail(1,1));
        
    }
    
            

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}
