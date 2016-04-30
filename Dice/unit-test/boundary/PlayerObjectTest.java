package boundary;

import static org.junit.Assert.*;

import org.junit.Test;

public class PlayerObjectTest {

	@Test
	public void testPlayerObject() {
		
		// Test if a playerObject is created.
		try {
			PlayerObject playerObject = new PlayerObject(1);
			assertNotNull(playerObject);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test(expected = Exception.class)
	public void testPlayerObjectException() throws Exception {
		
		// Test if a playerObject throws an exception 
		new PlayerObject(0);
						
	}
	
	@Test
	public void testSetIdle(){
		try {
	
			PlayerObject playerObject = new PlayerObject(1);
			// Test if the idle image of the character is set correctly
			playerObject.setIdle();
			assertNotNull(playerObject.getImage());
						
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testSetIdleWithPosition(){
		try {
	
			PlayerObject playerObject = new PlayerObject(1);
			
			// Test if the idle image of the character is set correctly
			playerObject.setIdle(10, 50);
			assertNotNull(playerObject.getImage());
			assertEquals(10, playerObject.getPositionX());
			assertEquals(50, playerObject.getPositionY());
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testSetDead(){
		try {
			PlayerObject playerObject = new PlayerObject(1);
			// Test if a BufferedImage for the character is set
			playerObject.setDead();
			assertNotNull(playerObject.getImage());
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testRunRight(){
		try {
			PlayerObject playerObject = new PlayerObject(1);
			// Test if character's positionX decreases and a run image for the character is set
			playerObject.setPositionX(50);
			playerObject.runRight(100);		
			assertNotNull(playerObject.getImage());
			
			assertTrue(playerObject.getPositionX() > 50);
						
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testRunLeft(){
		try {
			PlayerObject playerObject = new PlayerObject(1);
			// Test if character's positionX increases and a run image for the character is set
			playerObject.setPositionX(50);
			playerObject.runLeft(100);
			
			assertNotNull(playerObject.getImage());
			assertTrue(playerObject.getPositionX() < 50);
						
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testDying(){
		try {
			PlayerObject playerObject = new PlayerObject(1);
			// Test if dying images is set for the character
			playerObject.dying();		
			assertNotNull(playerObject.getImage());
						
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testAttack(){
		try {
			PlayerObject playerObject = new PlayerObject(1);
			// Test if dying images is set for the character
			playerObject.attack();
			
			assertNotNull(playerObject.getImage());
						
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	@Test 
	public void testIsIdle(){
		
		try {
			PlayerObject playerObject = new PlayerObject(1);
			// Test if isIdle returns correct boolean value.
			playerObject.attack();
			assertFalse(playerObject.isIdle());
			
			playerObject.setIdle();
			assertTrue(playerObject.isIdle());
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	@Test
	public void testSetPosition(){
		try {
			PlayerObject playerObject = new PlayerObject(1);
			assertNotNull(playerObject);
			
			// Test if the position for the panel is set correctly
			playerObject.setPosition(10, 20);
			assertEquals(10, playerObject.getPositionX());
			assertEquals(20, playerObject.getPositionY());
			
		} catch (Exception e) {
			e.printStackTrace();
		}
				
	}
	
	@Test
	public void testSetPositionX(){
		try {
			PlayerObject playerObject = new PlayerObject(1);
			assertNotNull(playerObject);
			
			// Test if the positionX for the panel is set correctly
			playerObject.setPositionX(50);
			assertEquals(50, playerObject.getPositionX());
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testSetPositionY(){
		try {
			PlayerObject playerObject = new PlayerObject(1);
			assertNotNull(playerObject);
			
			// Test if the positionY for the panel is set correctly
			playerObject.setPositionY(34);
			assertEquals(34, playerObject.getPositionY());
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testGetPositionX(){
		try {
			PlayerObject playerObject = new PlayerObject(1);
			assertNotNull(playerObject);
			
			playerObject.setPositionX(50);
			
			// Test if the positionX for the panel is returned correctly
			assertEquals(50, playerObject.getPositionX());
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testGetPositionY(){
		Panel panel = new Panel(0, 0);
		panel.setPositionY(40);
		
		try {
			PlayerObject playerObject = new PlayerObject(1);
			assertNotNull(playerObject);
			
			playerObject.setPositionY(60);
			
			// Test if the positionY for the panel is returned correctly
			assertEquals(60, playerObject.getPositionY());
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}