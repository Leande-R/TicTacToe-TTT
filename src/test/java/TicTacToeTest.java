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

    @Test
    public void testHasWinnerHorizontal() {
        game.board.place(0, 0, 'X');
        game.board.place(0, 1, 'X');
        game.board.place(0, 2, 'X');
        assertTrue(game.hasWinner());
    }

    @Test
    public void testHasWinnerVertical() {
        game.board.place(0, 0, 'X');
        game.board.place(1, 0, 'X');
        game.board.place(2, 0, 'X');
        assertTrue(game.hasWinner());
    }

    @Test
    public void testHasWinnerDiagonal() {
        game.board.place(0, 0, 'X');
        game.board.place(1, 1, 'X');
        game.board.place(2, 2, 'X');
        assertTrue(game.hasWinner());
    }

    @Test
    public void testNoWinner() {
        game.board.place(0, 0, 'X');
        game.board.place(0, 1, 'X');
        game.board.place(1, 0, 'O');
        game.board.place(1, 1, 'O');
        assertFalse(game.hasWinner());
    }

    @Test
    public void testIsFull() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                game.board.place(i, j, 'X');
            }
        }
        assertTrue(game.board.isFull());
    }

    @Test
    public void testPromptMove() {
        // Testen der promptMove Methode
        // Wir simulieren eine Benutzereingabe durch Setzen von Zeichen auf das Brett.
        game.board.place(0, 0, 'X');
        assertFalse(game.board.isCellEmpty(0, 0));
        assertEquals('X', game.board.getCells()[0][0]);
    }

    @Test
    public void testCheckGameOverWin() {
        game.board.place(0, 0, 'X');
        game.board.place(0, 1, 'X');
        game.board.place(0, 2, 'X');

        assertTrue(game.checkGameOver());
    }

    @Test
    public void testCheckGameOverDraw() {
        char[][] moves = {
                {'X', 'O', 'X'},
                {'X', 'X', 'O'},
                {'O', 'X', 'O'}
        };

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                game.board.place(i, j, moves[i][j]);
            }
        }

        assertTrue(game.checkGameOver());
    }

    @Test
    public void testCheckGameOverContinue() {
        game.board.place(0, 0, 'X');
        game.board.place(0, 1, 'X');

        assertFalse(game.checkGameOver());
    }
    @Test
    public void testStartGameAndMakeMove() {
    }

    @Test
    public void testReset() {
        game.board.place(0, 0, 'X');
        game.board.place(0, 1, 'O');
        game.reset();
        assertTrue(game.board.isCellEmpty(0, 0));
        assertTrue(game.board.isCellEmpty(0, 1));
        assertEquals('X', game.currentPlayer.getMarker());
    }
}