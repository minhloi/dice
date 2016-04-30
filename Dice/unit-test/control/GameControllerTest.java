package control;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import boundary.GameObject;

/**
 * Junit test for GameController class
 * 
 * @author Thien Duc Phung
 * @author Minh Loi
 * @author Daniel Enriquez
 * @author Brett Bauman
 * @author Tanner Siffren
 */

public class GameControllerTest {

	@Test
	public void testGameController() {
		
		// Test if a GameController object is created.
		ArrayList<GameObject> objectList = new ArrayList<GameObject>();
		GameController gameController = new GameController(objectList);
		
		assertNotNull(gameController);
	}

	@Test
	public void testGetState() {
	
		
		// Test if getState returns a correct object.
		ArrayList<GameObject> objectList = new ArrayList<GameObject>();
		GameController gameController = new GameController(objectList);
		
		assertTrue(gameController.getState(State.MENU_STATE) instanceof MainMenuState);
		assertTrue(gameController.getState(State.PLAY_STATE) instanceof PlayState);
		assertTrue(gameController.getState(State.VIEW_RANK_STATE) instanceof ViewRankState);
		assertTrue(gameController.getState(State.PAUSED_STATE) instanceof PausedState);
		
	}
	
	@Test
	public void testSetState() {
	
		ArrayList<GameObject> objectList = new ArrayList<GameObject>();
		GameController gameController = new GameController(objectList);
		
		PausedState paused = (PausedState) gameController.getState(State.PAUSED_STATE);
		
		//Test if game state is set successfully.
		gameController.setState(State.PAUSED_STATE);
		assertEquals(paused, gameController.getCurrentStateObject());
			
	}
	
	@Test
	public void testGetCurrentState() {
	
		ArrayList<GameObject> objectList = new ArrayList<GameObject>();
		GameController gameController = new GameController(objectList);
		
		PlayState playState = (PlayState) gameController.getState(State.PLAY_STATE);
		gameController.setState(State.PLAY_STATE);
		// Test if a GameState object is returned correctly
		assertEquals(playState, gameController.getCurrentStateObject());
			
	}

}
