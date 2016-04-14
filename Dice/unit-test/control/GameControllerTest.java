package control;

import static org.junit.Assert.*;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Scanner;

import org.junit.Test;

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
		assertTrue(gameController.getState(GameController.MENU_STATE) instanceof MenuState);
		assertTrue(gameController.getState(GameController.PLAY_STATE) instanceof PlayState);
		assertTrue(gameController.getState(GameController.VIEW_RANK_STATE) instanceof ViewRankState);
		assertTrue(gameController.getState(GameController.MATCH_END_MENU_STATE) instanceof MatchEndMenuState);
	}

	@Test
	public void testSetState() {
		
		GameController gameController = new GameController();	
		assertNotNull(gameController);
		
	}

	@Test
	public void testExitGame() {
		
		ByteArrayOutputStream outContent = new ByteArrayOutputStream();
		System.setOut(new PrintStream(outContent));
		
		GameController gameController = new GameController();
		
		gameController.exitGame();
		
		// The game exited sucessfully.
		assertEquals("Exit!", outContent.toString());
		
	}

}
