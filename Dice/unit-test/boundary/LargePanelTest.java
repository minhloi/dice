package boundary;

import static org.junit.Assert.*;

import org.junit.Test;

public class LargePanelTest {

	@Test
	public void testLargePanel() {
		LargePanel largePanel = new LargePanel(0, 0);
		assertNotNull(largePanel);		
	}

	@Test
	public void testSetPosition(){
		LargePanel largePanel = new LargePanel(0, 0);
		
		// Test if the position for the panel is set
		largePanel.setPosition(10, 40);
		assertEquals(10, largePanel.getPositionX());
		assertEquals(10, largePanel.getPositionX());
	}
	
	@Test
	public void testSetPositionX(){
		LargePanel largePanel = new LargePanel(0, 0);
		
		// Test if the positionX for the panel is set
		largePanel.setPositionX(50);
		assertEquals(50, largePanel.getPositionX());
	}
	
	@Test
	public void testSetPositionY(){
		LargePanel largePanel = new LargePanel(0, 0);
		
		// Test if the positionX for the panel is set
		largePanel.setPositionY(30);
		assertEquals(30, largePanel.getPositionY());
	}
	
	@Test
	public void testGetPositionX(){
		LargePanel largePanel = new LargePanel(0, 0);
		
		// Test if the positionX for the panel is returned correctly.
		largePanel.setPositionX(40);
		assertEquals(40, largePanel.getPositionX());
	}
	
	@Test
	public void testGetPositionY(){
		LargePanel largePanel = new LargePanel(0, 0);
		
		// Test if the positionY for the panel is returned correctly.
		largePanel.setPositionY(60);
		assertEquals(60, largePanel.getPositionY());
	}
}