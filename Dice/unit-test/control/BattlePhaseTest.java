package control;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import boundary.GameObject;
import boundary.PlayerObject;
import entity.Player;

/**
 * Junit test for BattlePhase class
 * 
 * @author Thien Duc Phung
 * @author Minh Loi
 * @author Daniel Enriquez
 * @author Brett Bauman
 * @author Tanner Siffren
 */

public class BattlePhaseTest {

	@Test
	public void testBattlePhase() {
	
		Player player1 = new Player(1);
		Player player2 = new Player(2);
		PlayerObject player1Object = null;
		PlayerObject player2Object = null;
		
		try {
			player1Object = new PlayerObject(1);
			player2Object = new PlayerObject(2);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		ArrayList<GameObject> objectList = new ArrayList<GameObject>();
		
		// Test if a BattlePhase object is created
		BattlePhase battlePhase = new BattlePhase(player1, player2, player1Object, player2Object, objectList);
		assertNotNull(battlePhase);
			
	}
	
	@Test
	public void testRender(){
		
		Player player1 = new Player(1);
		Player player2 = new Player(2);
		PlayerObject player1Object = null;
		PlayerObject player2Object = null;
		
		try {
			player1Object = new PlayerObject(1);
			player2Object = new PlayerObject(2);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		ArrayList<GameObject> objectList = new ArrayList<GameObject>();
		
		
		BattlePhase battlePhase = new BattlePhase(player1, player2, player1Object, player2Object, objectList);
		int initial = objectList.size();
		// Test if render add new objects to the list
		battlePhase.render();
		
		assertTrue(objectList.size() > initial);
	}
}
