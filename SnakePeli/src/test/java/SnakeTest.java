import Snake.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;


public class SnakeTest {
    
    Snake snake;
    
    
    @Before
    public void setUp() {
        snake = new Snake(15, 15, Direction.DOWN);
    }
    @Test
    public void changeDirection() {
        assertEquals(snake.getDirection(), Direction.DOWN);
        snake.setDirection(Direction.UP);
        assertEquals(snake.getDirection(), Direction.UP);
        snake.setDirection(Direction.LEFT);
        assertEquals(snake.getDirection(), Direction.LEFT);
        snake.setDirection(Direction.DOWN);
        assertEquals(snake.getDirection(), Direction.DOWN);
        snake.setDirection(Direction.RIGHT);
        assertEquals(snake.getDirection(), Direction.RIGHT);
    }
    @Test
    public void snakeGrow() {
       assertEquals(snake.getLeght(), 1);
        
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}
