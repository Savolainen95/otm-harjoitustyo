
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import snake.Game;
import snake.Snake;


public class GameTest {
    
    Game game;
    
    
    @Before
    public void setUp() {
        this.game = new Game(200, 200);
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
}
