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
		Player player = new Player(1);
		assertNotNull(player);
	}
	
	@Test
	public void testGetHealth() {
		// Test if HP is returned correctly
		Player player = new Player(1);
		int playerHP = player.getHealth();
		
		assertEquals( Player.DEFAULT_HEALTH_POINT, playerHP);
	}

	@Test
	public void testSetHealth() {

		// Test if HP of a player is set successfully.
		Player player = new Player(1);
		player.setHealth(20);
		
		assertEquals( 20, player.getHealth());
	}

	@Test
	public void testGetUserName() {
		// Test if a player's name is correctly returned
		Player player = new Player(1);
		player.setUsername("guest");
		
		assertEquals("guest", player.getUserName());
	}

	@Test
	public void testGetNumber() {
		// Test if a player's number is correctly returned
		Player player = new Player(1);
		int playerNumber = player.getNumber();
		
		assertEquals(1, playerNumber);
	}

	@Test
	public void testGetDice() {
		
		Player player = new Player(1);
		Dice playerDice = player.getDice();
		
		// Test if a Dice object of a player is correctly returned
		assertNotNull(playerDice);
		
	}

	@Test
	public void testCanUseSpecial() {
		// Default a player is allowed to use special.
		Player player = new Player(1);
		assertTrue(player.canUseSpecial());
		
		player.incrementSpecialUsed();
		assertTrue(player.canUseSpecial());
		
		// Test if a player can use special after using twice.
		player.incrementSpecialUsed();
		assertFalse(player.canUseSpecial());
	}

	@Test
	public void testResetTurnInfo() {
		Player player = new Player(1);
		try {
			player.getTurnInfo().setMove(Player.ATTACK);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		player.resetTurnInfo();
		assertEquals(Player.NOT_SELECT, player.getTurnInfo().getMove());
		
	}

}
