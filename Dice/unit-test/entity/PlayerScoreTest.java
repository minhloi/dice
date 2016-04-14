package entity;

import static org.junit.Assert.*;

import org.junit.Test;

public class PlayerScoreTest {

	@Test
	public void testPlayerScore() {
		// Test if a PlayerScore object is created sucessfully.
		PlayerScore newPlayer = new PlayerScore("guest");
		assertNotNull(newPlayer);
	}

	@Test
	public void testGetUsername() {
		// Test if user name is corrected returned.
		PlayerScore newPlayer = new PlayerScore("guest");
		assertEquals("guest", newPlayer.getUsername());
	}

	@Test
	public void testGetNumOfWins() {

		// Test if numOfWins is corrected returned.
		PlayerScore newPlayer = new PlayerScore("guest");
		assertEquals(0, newPlayer.getNumOfWins());
	}

	@Test
	public void testGetNumOfLosses() {

		// Test if numOfLoss is corrected returned.
		PlayerScore newPlayer = new PlayerScore("guest");
		assertEquals(0, newPlayer.getNumOfLosses());
	}

	@Test
	public void testGetDifference() {
		
		// Test if difference is calculated correctly.
		PlayerScore newPlayer = new PlayerScore("guest");
		newPlayer.incrementWins();
		newPlayer.incrementWins();
		newPlayer.incrementLosses();
		assertEquals(1, newPlayer.getDifference());
	}

	@Test
	public void testIncrementWins() {
		
		// Test if numOfWins incremented
		PlayerScore newPlayer = new PlayerScore("guest");
		newPlayer.incrementWins();
		assertEquals(1, newPlayer.getNumOfWins());
	}

	@Test
	public void testIncrementLosses() {

		// Test if numOfLosses incremented
		PlayerScore newPlayer = new PlayerScore("guest");
		newPlayer.incrementLosses();
		assertEquals(1, newPlayer.getNumOfLosses());
	}

}
