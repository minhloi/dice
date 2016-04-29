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
	public void testSetPosition() {
		Background background = new Background("play_background.png");
		background.setPosition(10, 20);
		
		assertEquals(10, background.getPositionX());
		assertEquals(20, background.getPositionY());
		
	}
	
	@Test
	public void testSetPositionX() {
		Background background = new Background("play_background.png");
		background.setPositionX(10);
		
		assertEquals(10, background.getPositionX());
		
	}
	
	@Test
	public void testSetPositionY() {
		Background background = new Background("play_background.png");
		background.setPositionY(20);
		
		assertEquals(20, background.getPositionY());
		
	}
	
	@Test
	public void testSetBackground(){
		
		Background background = new Background("play_background.png");
		background.setBackground("main_background.png");
		
		assertNotNull(background.getImage());
	}
	
}
