package boundary;

import static org.junit.Assert.*;

import org.junit.Test;

public class HealthBarTest {

	@Test
	public void testHealthBar() {
		HealthBar healthBar = new HealthBar(0, 0);
		assertNotNull(healthBar);
	}
	
	@Test
	public void testSetPosition(){
		HealthBar healthBar = new HealthBar(0, 0);
		
		healthBar.setPosition(10, 20);
		
		assertEquals(10, healthBar.getPositionX());
		assertEquals(20, healthBar.getPositionY());
		
	}
	
	@Test
	public void testSetPositionX(){
		HealthBar healthBar = new HealthBar(0, 0);
		
		healthBar.setPositionX(10);
		
		assertEquals(10, healthBar.getPositionX());
		
	}
	
	@Test
	public void testSetPositionY(){
		HealthBar healthBar = new HealthBar(0, 0);
		
		healthBar.setPositionY(12);
		
		assertEquals(12, healthBar.getPositionY());
		
	}

	@Test
	public void testSetHealthBar() {
		HealthBar healthBar = new HealthBar(0, 0);
		healthBar.setHealthBar(20);
		
		assertNotNull(healthBar.getImage());
	
	}

}
