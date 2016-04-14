package entity;

import static org.junit.Assert.*;

import java.util.Iterator;
import java.util.Vector;

import org.junit.Test;

public class DatabaseTest {

	@Test
	public void testDatabase() {
		
		// Test if a Database object is created.
		Database database = new Database();
		assertNotNull(database);
	}

	@Test
	public void testLoadData() {
			
		Database database = new Database();
		database.loadData();
		// Test if data is sucessfully load
		assertNotNull(database.getData());
		
		// Test if data is correct
		assertTrue(database.getData() instanceof Vector<?>);
	}

	@Test
	public void testSaveData() {
		// Test if there is no exception thrown while saving data.
		Database database = new Database();
		database.loadData();
		database.saveData();
	}

	@Test
	public void testSortByDifference() {
		Database database = new Database();
		database.loadData();
		database.sortByDifference();
		
		Vector<PlayerScore> gameData = database.getData();
		// Test if data is sort in descending order of difference
		for(int index = 0; index < gameData.size() - 1; ++index){
			PlayerScore current = gameData.get(index);
			PlayerScore next = gameData.get(index + 1);
			
			assertTrue(current.getDifference() > next.getDifference());			
		}
		
	}

	@Test
	public void testGetData() {
		Database database = new Database();
		database.loadData();
		// Test if data is returned correctly.
		Vector<PlayerScore> gameData = database.getData();
		assertNotNull(gameData);
		assertTrue(gameData instanceof Vector<?>);
	}

	@Test
	public void testIncrementWinByName() {
		Database database = new Database();
		database.incrementWinByName("guest");
		
		// Test if wins of a player incremented
		PlayerScore player = database.getPlayerScoreByName("guest");
		assertEquals(1, player.getNumOfWins());
		
		database.incrementWinByName("guest");
		assertEquals(2, player.getNumOfWins());
		
	}

	@Test
	public void testIncrementLossByName() {
		Database database = new Database();
		database.incrementLossByName("guest");
		
		// Test if losses of a player incremented
		PlayerScore player = database.getPlayerScoreByName("guest");
		assertEquals(1, player.getNumOfLosses());
		
		database.incrementLossByName("guest");
		assertEquals(2, player.getNumOfLosses());
		
	}

}
