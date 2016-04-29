package boundary;

import static org.junit.Assert.*;

import org.junit.Test;

public class LargePanelTest {

	@Test
	public void testLargePanel() {
		LargePanel largePanel = new LargePanel(0, 0);
		assertNotNull(largePanel);		
	}

}
