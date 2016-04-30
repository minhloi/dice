package entity;

import static org.junit.Assert.*;

import org.junit.Test;

public class TurnInfoTest {

	@Test
	public void testTurnInfo() {
		// Test if a TurnInfo object is created
		TurnInfo turnInfo = new TurnInfo();
		assertNotNull(turnInfo);
	}

	@Test
	public void testIsBlockDisabled() {
		// Test if isBlockDisabled return correct boolean value
		TurnInfo turnInfo = new TurnInfo();
		assertFalse(turnInfo.isBlockDisabled());
		
		turnInfo.disableBlock();
		assertTrue(turnInfo.isBlockDisabled());
		
	}

	@Test
	public void testGetMove() {
		// Test if getMove return correct value
		TurnInfo turnInfo = new TurnInfo();
		assertEquals(Player.NOT_SELECT, turnInfo.getMove());
		
		try {
			turnInfo.setMove(Player.ATTACK);
			assertEquals(Player.ATTACK, turnInfo.getMove());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	

	@Test
	public void testSetTurnWinner() {
		// Test if setTurnWinner works correctly
		TurnInfo turnInfo = new TurnInfo();
		turnInfo.setTurnWinner();
		assertTrue(turnInfo.isTurnWinner());
	}

	@Test
	public void testIsTurnWinner() {
		TurnInfo turnInfo = new TurnInfo();
		// Test if isTurnWinner return correct value;
		assertFalse(turnInfo.isTurnWinner());
		
		turnInfo.setTurnWinner();
		assertTrue(turnInfo.isTurnWinner());
	}

	@Test
	public void testGetMoveInString() {
		
		TurnInfo turnInfo = new TurnInfo();
		try {
			// Test if a correct string is returned
			turnInfo.setMove(Player.BLOCK);
			assertEquals("BLOCK", turnInfo.getMoveInString());
			turnInfo.setMove(Player.NOT_SELECT);
			assertEquals("NOT_SELECTED", turnInfo.getMoveInString());
			turnInfo.setMove(Player.ATTACK);
			assertEquals("ATTACK", turnInfo.getMoveInString());
			turnInfo.setMove(Player.SPECIAL_ATTACK);
			assertEquals("SPECIAL_ATTACK", turnInfo.getMoveInString());
		
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Test
	public void testSetMove() {
		
		TurnInfo turnInfo = new TurnInfo();
		
		try {
			// Test if set move successfully
			turnInfo.setMove(Player.BLOCK);
			assertEquals(Player.BLOCK, turnInfo.getMove());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testDisableBlock() {
		// Test if disableBlock works
		TurnInfo turnInfo = new TurnInfo();
		turnInfo.enableBlock();
		turnInfo.disableBlock();
		assertTrue(turnInfo.isBlockDisabled());
				
	}

	@Test
	public void testEnableBlock() {
		// Test if disableBlock works
		TurnInfo turnInfo = new TurnInfo();
		turnInfo.disableBlock();
		turnInfo.enableBlock();
		assertFalse(turnInfo.isBlockDisabled());
	}

}
