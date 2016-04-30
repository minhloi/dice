package control;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import boundary.GameObject;

public class MatchEndMenuTest {

	@Test
	public void testMatchEndMenu() {
		
		ArrayList<GameObject> objectList = new ArrayList<GameObject>();
		GameController controller = new GameController(objectList);
		
		// Test if a MatchEndMenu object is created successfully
		MatchEndMenu menu = new MatchEndMenu(controller, objectList);
		assertNotNull(menu);
	}

	@Test
	public void testRender() {
		ArrayList<GameObject> objectList = new ArrayList<GameObject>();
		GameController controller = new GameController(objectList);
		
		MatchEndMenu menu = new MatchEndMenu(controller, objectList);
		int initial = objectList.size();
		// Test if render method can add objects to the list
		menu.render();
		assertTrue(objectList.size() > initial);
	}

}
