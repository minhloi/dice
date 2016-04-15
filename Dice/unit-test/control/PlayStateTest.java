package control;

import static org.junit.Assert.*;

import java.io.ByteArrayInputStream;
import java.util.Scanner;

import org.junit.Test;

import entity.Database;

/**
 * Junit test of PlayState class
 * 
 * @author Thien Duc Phung
 * @author Minh Loi
 * @author Daniel Enriquez
 * @author Brett Bauman
 * @author Tanner Siffren
 */

public class PlayStateTest {

	@Test
	public void testPrint() {
		// We do not have to test this method.
		// This method calls to render a match object
		// thus test Match instead.
	}

	@Test
	public void testPlayState() {
		
		GameController controller = new GameController();
		Scanner scanner = new Scanner(System.in);
		Database database = new Database();
		
		PlayState playState = new PlayState(controller, scanner, database);
		assertNotNull(playState);
		
	}

	@Test
	public void testStartNew() {
		
		// Mock user name inputs for test
		String inputs = "Guest" + "\n" + "Guest2";
		System.setIn(new ByteArrayInputStream(inputs.getBytes()));

		GameController controller = new GameController();
		Scanner scanner = new Scanner(System.in);
		Database database = new Database();
		
		PlayState playState = new PlayState(controller, scanner, database);
		playState.startNew();
		
		// Test if startNew() requires to input exactly two user names for two players
		assertFalse(scanner.hasNext());
		
	}

}
