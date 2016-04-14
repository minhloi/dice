package entity;

import static org.junit.Assert.*;

import org.junit.Test;

public class DiceTest {

	@Test
	public void testDice() {
		
		// Test if a Dice object is created
		Dice dice = new Dice();
		assertNotNull(dice);
	}

	@Test
	public void testRoll() {
		
		Dice dice = new Dice();
		int number = dice.roll();
		
		// Test if a random number falls within the range.
		assertTrue(number >= 1);
		assertTrue(number <= 6);

	}

}
