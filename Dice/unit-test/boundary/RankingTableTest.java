package boundary;

import static org.junit.Assert.*;

import org.junit.Test;

public class RankingTableTest {

	@Test
	public void testRankingTable() {
		
		// Test if a RankingTable object is created.
		RankingTable table = new RankingTable();
		assertNotNull(table);
	}
	
	@Test
	public void testImageCreated() {
		
		// Test if a BufferedImage is created.
		RankingTable table = new RankingTable();
		assertNotNull(table.getImage());
	}
	
	@Test
	public void testSetPosition(){
		
		// Test if the position of the table is set
		RankingTable table = new RankingTable();
		table.setPosition(10, 40);
		
		assertEquals(10, table.getPositionX());
		assertEquals(40, table.getPositionY());
	}
	
	@Test
	public void testSetPositionX(){
		
		// Test if the positionX of the table is set
		RankingTable table = new RankingTable();
		table.setPositionX(10);
		
		assertEquals(10, table.getPositionX());
	}

	@Test
	public void testSetPositionY(){
		
		// Test if the positionY of the table is set
		RankingTable table = new RankingTable();
		table.setPositionY(25);
		
		assertEquals(25, table.getPositionY());
	}	
	
	@Test
	public void testGetPositionX(){
		
		// Test if the positionX of the table is returned
		RankingTable table = new RankingTable();
		table.setPositionX(10);
		
		assertEquals(10, table.getPositionX());
	}

	@Test
	public void testGetPositionY(){
		
		// Test if the positionY of the table is returned
		RankingTable table = new RankingTable();
		table.setPositionY(25);
		
		assertEquals(25, table.getPositionY());
	}
	
}
