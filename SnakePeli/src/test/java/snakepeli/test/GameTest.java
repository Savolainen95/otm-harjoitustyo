package snakepeli.test;


import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import snakepeli.domain.Direction;
import snakepeli.domain.Game;
import snakepeli.domain.Piece;
import snakepeli.domain.Snake;

public class GameTest {

    Game game;

    @Before
    public void setUp() {
        this.game = new Game(200, 200);
        this.game.getSnake().grow();
        this.game.update();
    }

    @Test
    public void scoreTests() {
        assertEquals(game.getScore(), 0);
        game.growScore();
        assertEquals(game.getScore(), 1);
        game.setScore(10);
        assertEquals(game.getScore(), 10);
    }

    @Test
    public void updateTest() {
        game.update();
    }

    @Test
    public void testGetters() {
        Snake snake = game.getSnake();
        assertEquals(this.game.getScore(), 0);
        assertEquals(this.game.getSnake(), snake);

    }

    /**
     * Test if changing direction to LEFT and then DOWN is working. It needs
     * some setup because otherwise indexoutofbounds will occure.
     */
    @Test
    public void testSnakeChangeDirectionLeftThenDown() {
        assertEquals(this.game.getSnake().getDirection(), Direction.DOWN);
        this.game.getSnake().setDirection(Direction.LEFT);
        this.game.update();
        assertEquals(this.game.getSnake().getDirection(), Direction.LEFT);
        this.game.getSnake().setDirection(Direction.DOWN);
        this.game.update();
        assertEquals(this.game.getSnake().getDirection(), Direction.DOWN);
    }

    /**
     * Test if changing direction to RIGHT and then UP is working. It needs some
     * setup because otherwise indexoutofbounds will occure.
     */
    @Test
    public void testSnakeChangeDirectionRightThenUp() {
        assertEquals(this.game.getSnake().getDirection(), Direction.DOWN);
        this.game.getSnake().setDirection(Direction.RIGHT);
        this.game.update();
        assertEquals(this.game.getSnake().getDirection(), Direction.RIGHT);
        this.game.getSnake().setDirection(Direction.UP);
        this.game.update();
        assertEquals(this.game.getSnake().getDirection(), Direction.UP);
    }

    @Test
    public void testSnakeWrongDirectionUp() {
        assertFalse(this.game.getSnake().wrongDirection(Direction.UP));

    }

    @Test
    public void testSnakeWrongDirectionRight() {
        this.game.getSnake().setDirection(Direction.LEFT);
        this.game.getSnake().grow();
        this.game.update();
        assertFalse(this.game.getSnake().wrongDirection(Direction.RIGHT));
    }

    @Test
    public void testSnakeWrongDirectionLeft() {
        this.game.getSnake().setDirection(Direction.RIGHT);
        this.game.getSnake().grow();
        this.game.update();
        assertFalse(this.game.getSnake().wrongDirection(Direction.LEFT));
    }

    @Test
    public void testSnakeWrongDirectionDown() {
        this.game.getSnake().setDirection(Direction.RIGHT);
        this.game.getSnake().grow();
        this.game.update();
        this.game.getSnake().setDirection(Direction.UP);
        this.game.update();
        assertFalse(this.game.getSnake().wrongDirection(Direction.DOWN));
    }

    @Test
    public void contactTest() {
        Piece piece = new Piece(1, 1);
        assertFalse(this.game.getSnake().contact(piece));
        piece.setX(this.game.getSnake().getPieces().get(this.game.getSnake().getPieces().size() - 1).getX());
        piece.setY(this.game.getSnake().getPieces().get(this.game.getSnake().getPieces().size() - 1).getY());
        assertTrue(this.game.getSnake().contact(piece));
    }

    @Test
    public void testGrowMethod() {
        assertEquals(this.game.getSnake().getGrow(), 1);
        this.game.getSnake().grow();
        this.game.getSnake().grow();
        this.game.update();
        assertEquals(this.game.getSnake().getGrow(), 0);
        this.game.getSnake().grow();
        this.game.getSnake().grow();
        assertEquals(this.game.getSnake().getGrow(), 2);
    }

    @Test
    public void testSnakeContactWithTail() {
        assertFalse(this.game.getSnake().contactWithTail(200, 200));
        this.game.getSnake().setDirection(Direction.LEFT);
        this.game.getSnake().grow();
        this.game.update();
        this.game.getSnake().setDirection(Direction.UP);
        this.game.getSnake().grow();
        this.game.update();
        this.game.getSnake().setDirection(Direction.RIGHT);
        this.game.getSnake().grow();
        this.game.update();
        assertTrue(this.game.getSnake().contactWithTail(200, 200));

    }
    @Test
    public void testNewSnake() {
        Snake help = this.game.getSnake();
        this.game.newSnake();
        assertNotSame(help, this.game.getSnake());
    }
    

}
