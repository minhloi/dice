package control;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import boundary.GameObject;
import boundary.PlayerObject;
import entity.Player;

public class TurnTest {

	@Test
	public void testTurn() {
		
		Player player1 = new Player(1);
		Player player2 = new Player(2);
		ArrayList<GameObject> objectList = new ArrayList<GameObject>();
		
		PlayerObject player1Object;
		PlayerObject player2Object;
		
		try {
			player1Object = new PlayerObject(1);
			player2Object = new PlayerObject(2);
		
			// Test if a PlayerObject is created successfully
			Turn turn = new Turn(player1, player2, player1Object, player2Object, objectList);
			assertNotNull(turn);
		
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
}
