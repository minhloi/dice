package boundary;

import static org.junit.Assert.*;

import org.junit.Test;

public class GameCanvasTest {

	@Test
	public void testGameCanvas() {
		
		// Test if a GameCanvas object is created successfully.
		GameCanvas gameCanvas = new GameCanvas();
		assertNotNull(gameCanvas);
	}

}
