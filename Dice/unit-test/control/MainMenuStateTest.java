package control;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import boundary.GameObject;

/**
 * Junit test for MenuState class
 * 
 * @author Thien Duc Phung
 * @author Minh Loi
 * @author Daniel Enriquez
 * @author Brett Bauman
 * @author Tanner Siffren
 */

public class MainMenuStateTest {

	
	@Test
	public void testMainMenuState() {
		
		ArrayList<GameObject> objectList = new ArrayList<GameObject>();
		GameController controller = new GameController(objectList);
		
		// Test if a MainMenuState object is created
		MainMenuState mainMenuState = new MainMenuState(controller, objectList);
		assertNotNull(mainMenuState);
		
	}


}
