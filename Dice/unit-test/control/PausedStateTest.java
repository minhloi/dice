package control;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import boundary.GameObject;

public class PausedStateTest {

	@Test
	public void testRender() {
		ArrayList<GameObject> objectList = new ArrayList<GameObject>();
		GameController controller = new GameController(objectList);
		// Test if a PausedState object is created successfully
		PausedState paused = new PausedState(controller, objectList);
		assertNotNull(paused);
	}

	@Test
	public void testPausedState() {
		ArrayList<GameObject> objectList = new ArrayList<GameObject>();
		GameController controller = new GameController(objectList);
		
		PausedState paused = new PausedState(controller, objectList);
		int initial = objectList.size();
		// Test if render method can add objects to the list
		paused.render();
		assertTrue(objectList.size() > initial);
	}

}
