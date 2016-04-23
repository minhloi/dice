package control;

import static org.junit.Assert.*;

import java.util.Scanner;

import org.junit.Test;

import entity.Database;
import entity.Player;

/**
 * Junit test for Match class.
 * 
 * @author Thien Duc Phung
 * @author Minh Loi
 * @author Daniel Enriquez
 * @author Brett Bauman
 * @author Tanner Siffren
 */

public class MatchTest {

	@Test
	public void testMatch() {
		
		Player player1 = new Player(1, "Guest");
		Player player2 = new Player(2, "Guest2");

		GameController controller = new GameController();
		Scanner scanner = new Scanner(System.in);
		Database database = new Database();
		
		// Test if a Match object is created
		Match match = new Match(player1, player2, controller, scanner, database);
		assertNotNull(match);
	
	}

}
