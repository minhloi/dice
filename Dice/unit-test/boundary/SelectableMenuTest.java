package boundary;

import static org.junit.Assert.*;

import org.junit.Test;

public class SelectableMenuTest {

	@Test
	public void testSelectableMenu() {
		
		// Test if a SelectableMenu object is created
		SelectableMenu menu = new SelectableMenu(10, 10, 0, 0);
		assertNotNull(menu);
	}
	
	@Test
	public void testBufferedImageCreated() {
		// Test if a BufferedImage is created
		SelectableMenu menu = new SelectableMenu(10, 10, 0, 0);
		assertNotNull(menu.getImage());
	}
	
	@Test
	public void testSetPosition(){
		
		// Test if the position is set correctly
		SelectableMenu menu = new SelectableMenu(10, 10, 0, 0);
		menu.setPosition(10, 40);
		
		assertEquals(10, menu.getPositionX());
		assertEquals(40, menu.getPositionY());
	
	}
	
	@Test
	public void testSetPositionX(){
		
		// Test if the positionX is set correctly
		SelectableMenu menu = new SelectableMenu(10, 10, 0, 0);
		menu.setPositionX(30);
		
		assertEquals(30, menu.getPositionX());
	}
	
	@Test
	public void testSetPositionY(){
		
		// Test if the positionT is set correctly
		SelectableMenu menu = new SelectableMenu(10, 10, 0, 0);
		menu.setPositionY(25);
		
		assertEquals(25, menu.getPositionY());
	}
	
	@Test
	public void testGetPositionX(){
		
		// Test if the positionX is returned correctly
		SelectableMenu menu = new SelectableMenu(10, 10, 0, 0);
		menu.setPositionX(30);
		
		assertEquals(30, menu.getPositionX());
	}
	
	@Test
	public void testGetPositionY(){
		
		// Test if the positionY is returned correctly
		SelectableMenu menu = new SelectableMenu(10, 10, 0, 0);
		menu.setPositionY(25);
		
		assertEquals(25, menu.getPositionY());
	}

}
