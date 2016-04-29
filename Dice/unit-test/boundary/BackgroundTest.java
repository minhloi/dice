package boundary;

import static org.junit.Assert.*;

import org.junit.Test;

public class BackgroundTest {

	@Test
	public void testBackground() {
		Background background = new Background("play_background.png");
		assertNotNull(background);
	}

	@Test
	public void testSetBackground() {
		//fail("Not yet implemented");
	}

}
