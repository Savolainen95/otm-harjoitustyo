package snakepeli.test;

import snakepeli.domain.Piece;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Savolainen
 */
public class PieceTest {
    
    Piece piece;
    
    
    
    @Before
    public void setUp() {
        this.piece = new Piece(5, 6);
    }
    
    @Test
    public void setUpIsWorking() {
        assertEquals(5, piece.getX());
        assertEquals(6, piece.getY());
    }
    @Test
    public void changeCoordinates() {
        assertEquals(piece.getX(), 5);
        piece.setX(20);
        assertEquals(piece.getX(), 20);
        piece.setY(-4);
        assertEquals(piece.getY(), -4);
        
    }
    @Test
    public void correcttoString() {
        assertEquals(piece.toString(), "(5,6)");
        piece.setX(6);
        assertEquals(piece.toString(), "(6,6)");
    }
    @Test
    public void contactWithPiece() {
        assertTrue(this.piece.contact(new Piece(5,6)));
        assertFalse(this.piece.contact(new Piece(3,7)));
    }
}
