package boundary;

import static org.junit.Assert.*;

import org.junit.Test;

public class HealthBarTest {

	@Test
	public void testHealthBar() {
		// Test if a HealthBar object is created
		HealthBar healthBar = new HealthBar(0, 0);
		assertNotNull(healthBar);
	}
	
	@Test
	public void testSetPosition(){
		
		HealthBar healthBar = new HealthBar(0, 0);
		
		// Test if the position for health bar is set 
		healthBar.setPosition(10, 20);
		
		assertEquals(10, healthBar.getPositionX());
		assertEquals(20, healthBar.getPositionY());
		
	}
	
	@Test
	public void testSetPositionX(){
		
		HealthBar healthBar = new HealthBar(0, 0);
		
		// Test if the positionX for health bar is set 
		healthBar.setPositionX(10);
		
		assertEquals(10, healthBar.getPositionX());
		
	}
	
	
	@Test
	public void testSetPositionY(){
		HealthBar healthBar = new HealthBar(0, 0);
		
		// Test if the positionY for health bar is set. 
		healthBar.setPositionY(12);
		
		assertEquals(12, healthBar.getPositionY());
		
	}
	
	@Test
	public void testGetPositionX(){
		
		HealthBar healthBar = new HealthBar(0, 0);
		
		// Test if the positionX for health bar is returned correctly 
		healthBar.setPositionX(10);
		
		assertEquals(10, healthBar.getPositionX());
			
	}
	
	@Test
	public void testGetPositionY(){
		
		HealthBar healthBar = new HealthBar(0, 0);
		
		// Test if the positionX for health bar is returned correctly 
		healthBar.setPositionY(10);
		
		assertEquals(10, healthBar.getPositionY());
	
	}
	
	@Test
	public void testSetHealthBar() {
		
		HealthBar healthBar = new HealthBar(0, 0);
		healthBar.setHealthBar(20);
		
		// Test if the image for the health bar is created. 
		assertNotNull(healthBar.getImage());
	
	}

}