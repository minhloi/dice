package boundary;

import static org.junit.Assert.*;

import org.junit.Test;

public class RankingTableTest {

	@Test
	public void testRankingTable() {
		RankingTable table = new RankingTable();
		assertNotNull(table);
	}
	
	@Test
	public void testSetPosition(){
		RankingTable table = new RankingTable();
		table.setPosition(10, 40);
		
		assertEquals(10, table.getPositionX());
		assertEquals(40, table.getPositionY());
	}
	
	@Test
	public void testSetPositionX(){
		RankingTable table = new RankingTable();
		table.setPositionX(10);
		
		assertEquals(10, table.getPositionX());
	}

	@Test
	public void testSetPositionY(){
		RankingTable table = new RankingTable();
		table.setPositionY(25);
		
		assertEquals(25, table.getPositionY());
	}	
	
	@Test
	public void testDrawHeader() {
		//fail("Not yet implemented");
	}

	@Test
	public void testDrawPlayerScore() {
		//fail("Not yet implemented");
	}

	@Test
	public void testDrawNoRecords() {
		//fail("Not yet implemented");
	}

}
