package entity;

import static org.junit.Assert.*;

import org.junit.Test;

public class PlayerTest {

	@Test
	public void testPlayer() {
		Player player = new Player(1, "guest");
		assertNotNull(player);
	}
	
	@Test
	public void testGetHealth() {
		Player player = new Player(1, "guest");
		int playerHP = player.getHealth();
		
		assertEquals( Player.DEFAULT_HEALTH_POINT, playerHP);
	}

	@Test
	public void testSetHealth() {
		Player player = new Player(1, "guest");
		player.setHealth(20);
		
		assertEquals( 20, player.getHealth());
	}

	@Test
	public void testGetUserName() {
		// Test username
	}

	@Test
	public void testGetNumber() {
		Player player = new Player(1, "guest");
		int playerNumber = player.getNumber();
		
		assertEquals(1, playerNumber);
	}

	@Test
	public void testGetDice() {
		Player player = new Player(1, "guest");
		Dice playerDice = player.getDice();
		
		assertNotNull(playerDice);
	}

	@Test
	public void testIsBlockDisabled() {
		Player player = new Player(1, "guest");
		// Default block is not disabled
		assertFalse(player.isBlockDisabled());
		
		// Block is disabled when the player selected BLOCK.
		player.setMove(Player.BLOCK);
		assertTrue(player.isBlockDisabled());
		
	}

	@Test
	public void testCanUseSpecial() {
		Player player = new Player(1, "guest");
		assertTrue(player.canUseSpecial());
		
		player.setMove(Player.SPECIAL_ATTACK);
		assertTrue(player.canUseSpecial());
		
		player.setMove(Player.SPECIAL_ATTACK);
		assertFalse(player.canUseSpecial());
	}

	@Test
	public void testGetMove() {
		Player player = new Player(1, "guest");
		
		assertEquals(Player.NOT_SELECT, player.getMove());
	}

	@Test
	public void testGetMoveInString() {
		Player player = new Player(1, "guest");
		
		assertEquals("NOT_SELECTED", player.getMoveInString());
	}

	@Test
	public void testSetMove() {
		Player player = new Player(1, "guest");
		player.setMove(Player.ATTACK);
		
		assertEquals(Player.ATTACK, player.getMove());
	}

	@Test
	public void testResetMove() {
		Player player = new Player(1, "guest");
		player.setMove(Player.ATTACK);
		
		player.resetMove();
		assertEquals(Player.NOT_SELECT, player.getMove());
				
	}

}
