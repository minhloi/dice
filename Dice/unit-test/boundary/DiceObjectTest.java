package boundary;

import static org.junit.Assert.*;

import org.junit.Test;

public class DiceObjectTest {

	@Test
	public void testDiceObject() {
		DiceObject diceObject = new DiceObject(0, 0);
		assertNotNull(diceObject);
	}

	@Test
	public void testSetImageByDiceNum() {
		DiceObject diceObject = new DiceObject(0, 0);
		
		diceObject.setImageByDiceNum(2);
		assertNotNull(diceObject);
	
	}
	
	@Test
	public void testSetPosition(){
		DiceObject diceObject = new DiceObject(0, 0);
		
		diceObject.setPosition(15, 30);
		assertEquals(15, diceObject.getPositionX());
		assertEquals(30, diceObject.getPositionY());
		
	}
	
	@Test
	public void testSetPositionX(){
		DiceObject diceObject = new DiceObject(0, 0);
		
		diceObject.setPositionX(15);
		assertEquals(15, diceObject.getPositionX());
		
	}
	
	@Test
	public void testSetPositionY(){
		DiceObject diceObject = new DiceObject(0, 0);
		
		diceObject.setPositionY(35);
		assertEquals(35, diceObject.getPositionX());
		
	}
	

}
