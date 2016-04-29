package boundary;

import static org.junit.Assert.*;

import org.junit.Test;

public class PlayerObjectTest {

	@Test
	public void testPlayerObject() {
		
		try {
			PlayerObject playerObject = new PlayerObject(1);
			assertNotNull(playerObject);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
				
	}

}
