package control;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import boundary.GameObject;
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
		
		Player player1 = new Player(1);
		Player player2 = new Player(2);

		ArrayList<GameObject> objectList = new ArrayList<GameObject>();
		GameController controller = new GameController(objectList);
		Database database = new Database();
		
		// Test if a Match object is created
		Match match = new Match(player1, player2, controller, objectList, database);
		assertNotNull(match);
	
	}

}
