package Entity;

import static org.junit.Assert.*;

import org.junit.Test;

public class PlayerTest {

	@Test
	public void testPlayer() {
		Player player = new Player(1);
		assertNotNull(player);
	}
	
	@Test
	public void testGetHealth() {
		Player player = new Player(1);
		int playerHP = player.getHealth();
		
		assertEquals( Player.DEFAULT_HEALTH_POINT, playerHP);
	}

	@Test
	public void testSetHealth() {
		Player player = new Player(1);
		player.setHealth(20);
		
		assertEquals( 20, player.getHealth());
	}

	@Test
	public void testGetUserName() {
		// Test username
	}

	@Test
	public void testGetNumber() {
		Player player = new Player(1);
		int playerNumber = player.getNumber();
		
		assertEquals(1, playerNumber);
	}

	@Test
	public void testGetDice() {
		Player player = new Player(1);
		Dice playerDice = player.getDice();
		
		assertNotNull(playerDice);
	}

	@Test
	public void testIsBlockDisabled() {
		//fail("Not yet implemented");
	}

	@Test
	public void testCanUseSpecial() {
		//fail("Not yet implemented");
	}

	@Test
	public void testGetMove() {
		//fail("Not yet implemented");
	}

	@Test
	public void testGetMoveInString() {
		//fail("Not yet implemented");
	}

	@Test
	public void testSetMove() {
		//fail("Not yet implemented");
	}

	@Test
	public void testResetMove() {
		//fail("Not yet implemented");
	}

}
