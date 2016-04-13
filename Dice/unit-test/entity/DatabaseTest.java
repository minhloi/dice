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
		//fail("Not yet implemented");
	}

	@Test
	public void testIncrementWinByName() {
		//fail("Not yet implemented");
	}

	@Test
	public void testIncrementLossByName() {
		//fail("Not yet implemented");
	}

}
