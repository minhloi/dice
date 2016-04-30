package boundary;

import static org.junit.Assert.*;

import org.junit.Test;

public class DiceObjectTest {

	@Test
	public void testDiceObject() {
		// Test if a DiceObject is created.
		DiceObject diceObject = new DiceObject(0, 0);
		assertNotNull(diceObject);
	}

	@Test
	public void testSetImageByDiceNum() {
		
		DiceObject diceObject = new DiceObject(0, 0);
		
		// Test if a dice image is set
		diceObject.setImageByDiceNum(1);
		assertNotNull(diceObject);
	
	}
	
	@Test
	public void testSetPosition(){
		DiceObject diceObject = new DiceObject(0, 0);
		
		// Test if dice position is set
		diceObject.setPosition(15, 30);
		assertEquals(15, diceObject.getPositionX());
		assertEquals(30, diceObject.getPositionY());
		
	}
	
	@Test
	public void testSetPositionX(){
		DiceObject diceObject = new DiceObject(0, 0);
		
		// Test if dice positionX is set
		diceObject.setPositionX(15);
		assertEquals(15, diceObject.getPositionX());
		
	}
	
	@Test
	public void testSetPositionY(){
		DiceObject diceObject = new DiceObject(0, 0);
		
		// Test if dice positionY is set
		diceObject.setPositionY(35);
		assertEquals(35, diceObject.getPositionY());
		
	}
	
	@Test
	public void testGetPositionX(){
		DiceObject diceObject = new DiceObject(0, 0);
		
		// Test if dice positionX is returned correctly.
		diceObject.setPositionX(15);
		assertEquals(15, diceObject.getPositionX());
		
	}
	
	@Test
	public void testGetPositionY(){
		DiceObject diceObject = new DiceObject(0, 0);
		
		// Test if dice positionY is returned correctly.
		diceObject.setPositionY(35);
		assertEquals(35, diceObject.getPositionY());
		
	}

}