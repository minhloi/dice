package boundary;

import static org.junit.Assert.*;

import org.junit.Test;

public class WinnerTitleTest {

	@Test
	public void testWinnerTitle() {
		WinnerTitle title = new WinnerTitle(1, 0, 0);
		assertNotNull(title);
	}

}
