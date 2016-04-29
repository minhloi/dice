package boundary;

import static org.junit.Assert.*;

import org.junit.Test;

public class SelectableMenuTest {

	@Test
	public void testSelectableMenu() {
		SelectableMenu menu = new SelectableMenu(0, 0, 0, 0);
		assertNotNull(menu);
	}

}
