package boundary;

import static org.junit.Assert.*;

import org.junit.Test;

public class SelectableMenuTest {

	@Test
	public void testSelectableMenu() {
		SelectableMenu menu = new SelectableMenu(0, 0, 0, 0);
		assertNotNull(menu);
	}
	@Test
	public void testSetPosition(){
		/*SelectableMenu table = new RankingTable();
		table.setPosition(10, 40);
		
		assertEquals(10, table.getPositionX());
		assertEquals(40, table.getPositionY());
	*/
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
	
}
