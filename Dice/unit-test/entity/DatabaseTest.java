package entity;

import static org.junit.Assert.*;

import java.util.Iterator;
import java.util.Vector;

import org.junit.Test;

public class DatabaseTest {

	@Test
	public void testDatabase() {
		Database database = new Database();
		assertNotNull(database);
	}

	@Test
	public void testLoadData() {
		Database database = new Database();
		database.loadData();
		assertNotNull(database.getData());
	}

	@Test
	public void testSaveData() {
		//fail("Not yet implemented");
	}

	// Test if data is sort in descending order of difference
	@Test
	public void testSortByDifference() {
		Database database = new Database();
		database.loadData();
		database.sortByDifference();
		
		Vector<PlayerScore> gameData = database.getData();
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
		Vector<PlayerScore> gameData = database.getData();
		assertNotNull(gameData);
	
	}

	@Test
	public void testIncrementWinByName() {
		Database database = new Database();
		database.incrementWinByName("guest");
		
		PlayerScore player = database.getPlayerScoreByName("guest");
		assertEquals(1, player.getNumOfWins());
		
		database.incrementWinByName("guest");
		assertEquals(2, player.getNumOfWins());
		
	}

	@Test
	public void testIncrementLossByName() {
		Database database = new Database();
		database.incrementLossByName("guest");
		
		PlayerScore player = database.getPlayerScoreByName("guest");
		assertEquals(1, player.getNumOfLosses());
		
		database.incrementLossByName("guest");
		assertEquals(2, player.getNumOfLosses());
		
	}

}
