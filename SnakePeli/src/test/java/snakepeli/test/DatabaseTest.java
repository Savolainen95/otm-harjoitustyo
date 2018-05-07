package snakepeli.test;

import java.sql.SQLException;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import snakepeli.db.Database;
import snakepeli.db.HighScore;
import snakepeli.db.HighScoreDao;


public class DatabaseTest {
    
    Database database;
    HighScoreDao highScoreDao;
    HighScore highScore;
    
    
    public DatabaseTest() {
    }
    
    
    @Before
    public void setUp() throws SQLException {
        this.database = new Database("jdbc:sqlite:HighScoresTest.db");
        this.highScoreDao = new HighScoreDao(this.database);
        this.highScore = new HighScore("Test", 10);
        this.highScoreDao.saveOrUpdate(highScore);
    }
    
    @Test
    public void testHighScoreSave() throws SQLException {
        HighScore help = this.highScoreDao.saveOrUpdate(highScore);
        assertEquals(highScore.getPlayer(), help.getPlayer());
        assertEquals(help.getPoints(), highScore.getPoints());
    }
    @Test
    public void testFindOne() throws SQLException {
        HighScore help = this.highScoreDao.findOne(1);
        
        assertEquals(highScore.getPlayer(), help.getPlayer());
        assertEquals(help.getPoints(), highScore.getPoints());
        
    }
    
    
    
    
    
    
    @Test
    public void testDropTable() throws SQLException {
        HighScore help = this.highScoreDao.dropTable();
        assertEquals(help.getPlayer(), "DROPING");
        assertEquals(help.getPoints(), (Integer) 13);
        
    }
    
    
    
    
    

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}
