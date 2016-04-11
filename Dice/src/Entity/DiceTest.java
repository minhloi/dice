package Entity;

import static org.junit.Assert.*;

import org.junit.Test;

public class DiceTest {

	@Test
	public void testDice() {
		Dice dice = new Dice();
		assertNotNull(dice);
	}

	@Test
	public void testRoll() {
		Dice dice = new Dice();
		int number = dice.roll();
		
		// Test randomness
	}

}
