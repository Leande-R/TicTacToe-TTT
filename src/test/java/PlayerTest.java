import static org.junit.Assert.*;
import org.example.Player;
import org.junit.Before;
import org.junit.Test;

public class PlayerTest {
    private Player player;

    @Before
    public void setUp() {
        player = new Player('X');
    }

    @Test
    public void testGetMarker() {
        assertEquals('X', player.getMarker());
    }
}