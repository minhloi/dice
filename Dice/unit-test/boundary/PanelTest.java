package boundary;

import static org.junit.Assert.*;

import org.junit.Test;

public class PanelTest {

	@Test
	public void testPanel() {
		Panel panel = new Panel(0, 0);
		assertNotNull(panel);
	}
	
	@Test
	public void testPanelImage() {
		Panel panel = new Panel(0, 0);
		// Test image is set when a panel object is created.
		assertNotNull(panel.getImage());
	}

	@Test
	public void testSetPosition(){
		Panel panel = new Panel(0, 0);
		panel.setPosition(10, 20);
		
		assertEquals(10, panel.getPositionX());
		assertEquals(20, panel.getPositionY());
		
	}
	
	@Test
	public void testSetPositionX(){
		Panel panel = new Panel(0, 0);
		panel.setPositionX(20);
		
		assertEquals(10, panel.getPositionX());
	}
	
	@Test
	public void testSetPositionY(){
		Panel panel = new Panel(0, 0);
		panel.setPositionY(40);
		
		assertEquals(40, panel.getPositionY());
	}

}
