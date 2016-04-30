package boundary;

import static org.junit.Assert.*;

import java.awt.image.BufferedImage;

import org.junit.Test;

public class BackgroundTest {

	@Test
	public void testBackground() {
		
		// Test if a Background object is created successfully.
		Background background = new Background("play_background.png");
		assertNotNull(background);
	}

	@Test
	public void testSetPosition() {
		
		// Test if position is set correctly.
		Background background = new Background("play_background.png");
		background.setPosition(10, 20);
		
		assertEquals(10, background.getPositionX());
		assertEquals(20, background.getPositionY());
		
	}
		
	@Test
	public void testSetPositionX() {
		
		// Test if positionX is set correctly.
		Background background = new Background("play_background.png");
		background.setPositionX(10);
		
		assertEquals(10, background.getPositionX());
		
	}
	
	@Test
	public void testSetPositionY() {
		
		// Test if positionY is set correctly.
		Background background = new Background("play_background.png");
		background.setPositionY(20);
		
		assertEquals(20, background.getPositionY());
		
	}
	
	@Test
	public void testGetPositionX() {
		
		// Test if position is return correctly.
		Background background = new Background("play_background.png");
		background.setPosition(60, 20);
		
		assertEquals(60, background.getPositionX());
		
	}
	
	@Test
	public void testGetPositionY() {
		
		// Test if position is return correctly.
		Background background = new Background("play_background.png");
		background.setPosition(60, 50);
		
		assertEquals(50, background.getPositionY());
		
	}
	
	@Test
	public void testSetBackground(){
		
		// Test if background image is set.
		Background background = new Background("play_background.png");
		background.setBackground("main_background.png");
		
		assertNotNull(background.getImage());
	}
	
	@Test
	public void testGetImage(){
		
		// Test if a BufferedImage is returned.
		Background background = new Background("play_background.png");
		background.setBackground("main_background.png");
		
		assertTrue(background.getImage() instanceof BufferedImage);
		assertNotNull(background.getImage());
	}
	
}
