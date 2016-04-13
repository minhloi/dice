package entity;

import static org.junit.Assert.*;

import org.junit.Test;

public class PlayerScoreTest {

	@Test
	public void testPlayerScore() {
		PlayerScore newPlayer = new PlayerScore("guest");
		assertNotNull(newPlayer);
	}

	@Test
	public void testGetUsername() {
		PlayerScore newPlayer = new PlayerScore("guest");
		assertEquals("guest", newPlayer.getUsername());
	}

	@Test
	public void testGetNumOfWins() {
		PlayerScore newPlayer = new PlayerScore("guest");
		assertEquals(0, newPlayer.getNumOfWins());
	}

	@Test
	public void testGetNumOfLosses() {
		PlayerScore newPlayer = new PlayerScore("guest");
		assertEquals(0, newPlayer.getNumOfLosses());
	}

	@Test
	public void testGetDifference() {
		PlayerScore newPlayer = new PlayerScore("guest");
		newPlayer.incrementWins();
		newPlayer.incrementWins();
		newPlayer.incrementLosses();
		assertEquals(1, newPlayer.getDifference());
	}

	@Test
	public void testIncrementWins() {
		PlayerScore newPlayer = new PlayerScore("guest");
		newPlayer.incrementWins();
		assertEquals(1, newPlayer.getNumOfWins());
	}

	@Test
	public void testIncrementLosses() {
		PlayerScore newPlayer = new PlayerScore("guest");
		newPlayer.incrementLosses();
		assertEquals(1, newPlayer.getNumOfLosses());
	}

}
