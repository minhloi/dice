package entity;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * Junit test of Player class
 * 
 * @author Thien Duc Phung
 * @author Minh Loi
 * @author Daniel Enriquez
 * @author Brett Bauman
 * @author Tanner Siffren
 */

public class PlayerTest {

	@Test
	public void testPlayer() {
		// Test if a Player object is created.
		Player player = new Player(1, "guest");
		assertNotNull(player);
	}
	
	@Test
	public void testGetHealth() {
		// Test if HP is returned correctly
		Player player = new Player(1, "guest");
		int playerHP = player.getHealth();
		
		assertEquals( Player.DEFAULT_HEALTH_POINT, playerHP);
	}

	@Test
	public void testSetHealth() {

		// Test if HP of a player is set successfully.
		Player player = new Player(1, "guest");
		player.setHealth(20);
		
		assertEquals( 20, player.getHealth());
	}

	@Test
	public void testGetUserName() {
		// Test if a player's name is correctly returned
		Player player = new Player(1, "guest");
		assertEquals("guest", player.getUserName());
	}

	@Test
	public void testGetNumber() {
		// Test if a player's number is correctly returned
		Player player = new Player(1, "guest");
		int playerNumber = player.getNumber();
		
		assertEquals(1, playerNumber);
	}

	@Test
	public void testGetDice() {
		
		Player player = new Player(1, "guest");
		Dice playerDice = player.getDice();
		// Test if a Dice object of a player is correctly returned
		assertNotNull(playerDice);
		
	}

	@Test
	public void testIsBlockDisabled() {
		
		Player player = new Player(1, "guest");
		// Default block is not disabled
		assertFalse(player.isBlockDisabled());
		
		// Test if block is disabled when the player selected BLOCK.
		player.setMove(Player.BLOCK);
		assertTrue(player.isBlockDisabled());
		
	}

	@Test
	public void testCanUseSpecial() {
		// Default a player is allowed to use special.
		Player player = new Player(1, "guest");
		assertTrue(player.canUseSpecial());
		
		player.setMove(Player.SPECIAL_ATTACK);
		assertTrue(player.canUseSpecial());
		
		// Test if a player can use special after using twice.
		player.setMove(Player.SPECIAL_ATTACK);
		assertFalse(player.canUseSpecial());
	}

	@Test
	public void testGetMove() {
		Player player = new Player(1, "guest");
		// Test if a player's move is returned correctly
		assertEquals(Player.NOT_SELECT, player.getMove());
	}

	@Test
	public void testGetMoveInString() {
		Player player = new Player(1, "guest");
		
		// Test if strings are returned correctly.
		player.setMove(Player.NOT_SELECT);
		assertEquals("NOT_SELECTED", player.getMoveInString());
		
		player.setMove(Player.BLOCK);
		assertEquals("BLOCK", player.getMoveInString());
		
		player.setMove(Player.ATTACK);
		assertEquals("ATTACK", player.getMoveInString());
		
		player.setMove(Player.SPECIAL_ATTACK);
		assertEquals("SPECIAL_ATTACK", player.getMoveInString());
	}

	@Test
	public void testSetMove() {
		// Test if a move is successfully set.
		Player player = new Player(1, "guest");
		player.setMove(Player.ATTACK);
		
		assertEquals(Player.ATTACK, player.getMove());
	}

	@Test
	public void testResetMove() {
		// Test if a player's move is reset.
		Player player = new Player(1, "guest");
		player.setMove(Player.ATTACK);
		
		player.resetMove();
		assertEquals(Player.NOT_SELECT, player.getMove());
	}

}
