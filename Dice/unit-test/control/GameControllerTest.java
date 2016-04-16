package control;

import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.Test;

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
		GameController gameController = new GameController();	
		assertNotNull(gameController);
	}

	@Test
	public void testGetState() {
		GameController gameController = new GameController();	
		
		// Test if getState returns a correct object.
		try {
			assertTrue(gameController.getState(State.MENU_STATE) instanceof MenuState);
			assertTrue(gameController.getState(State.PLAY_STATE) instanceof PlayState);
			assertTrue(gameController.getState(State.VIEW_RANK_STATE) instanceof ViewRankState);
			assertTrue(gameController.getState(State.MATCH_END_MENU_STATE) instanceof MatchEndMenuState);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	@Test(expected = Exception.class)
	public void testGetStateExceptionThrown() throws Exception {
		GameController gameController = new GameController();	
		
		// Test if getState throws an exception when state does not exists.
		gameController.getState(-1);
		
	}
	
	@Test(expected = Exception.class)
	public void testSetStateExceptionThrown() throws Exception {
		GameController gameController = new GameController();	
		
		// Test if setState throws an exception when state does not exists.
		gameController.setState(100);
				
	}

	@Test
	public void testExitGame() {
		
		ByteArrayOutputStream outContent = new ByteArrayOutputStream();
		System.setOut(new PrintStream(outContent));
		
		GameController gameController = new GameController();
		
		gameController.exitGame();
		
		// The game exited successfully.
		assertEquals("Exit!", outContent.toString());
		
	}

}
