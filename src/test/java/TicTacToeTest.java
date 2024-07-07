import static org.junit.Assert.*;

import org.example.TicTacToe;
import org.junit.Before;
import org.junit.Test;

public class TicTacToeTest {
    private TicTacToe game;

    @Before
    public void setUp() {
        game = new TicTacToe();
    }

    @Test
    public void testSwitchCurrentPlayer() {
        assertEquals('X', game.currentPlayer.getMarker());
        game.switchCurrentPlayer();
        assertEquals('O', game.currentPlayer.getMarker());
    }
}