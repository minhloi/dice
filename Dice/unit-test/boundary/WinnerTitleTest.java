package boundary;

import static org.junit.Assert.*;

import org.junit.Test;

public class WinnerTitleTest {

	@Test
	public void testWinnerTitle() {
		// Test if a WinnerTitle object is created
		WinnerTitle title = new WinnerTitle(1, 0, 0);
		assertNotNull(title);
	}
	
	@Test
	public void testImageCreated(){
		WinnerTitle title = new WinnerTitle(1, 0, 0);
		assertNotNull(title.getImage());
	}
	
	@Test
	public void testSetPosition(){
		// Test if the position is set
		WinnerTitle title = new WinnerTitle(1, 0, 0);
		title.setPosition(10, 40);
		
		assertEquals(10, title.getPositionX());
		assertEquals(40, title.getPositionY());
	}
		
	@Test
	public void testSetPositionX(){
		// Test if the positionX is set
		WinnerTitle title = new WinnerTitle(1, 0, 0);
		title.setPositionX(10);
		
		assertEquals(10, title.getPositionX());
	}

	@Test
	public void testSetPositionY(){
		// Test if the positionY is set
		WinnerTitle title = new WinnerTitle(1, 0, 0);
		title.setPositionY(25);
		
		assertEquals(25, title.getPositionY());
	}	

	@Test
	public void testGetPositionX(){
		// Test if the positionX is returned
		WinnerTitle title = new WinnerTitle(1, 0, 0);
		title.setPositionX(10);
		
		assertEquals(10, title.getPositionX());
	}

	@Test
	public void testGetPositionY(){
		// Test if the positionY is returned
		WinnerTitle title = new WinnerTitle(1, 0, 0);
		title.setPositionY(25);
		
		assertEquals(25, title.getPositionY());
	}
}
