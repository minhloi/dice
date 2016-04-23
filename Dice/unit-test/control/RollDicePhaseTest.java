package control;

import static org.junit.Assert.*;

import org.junit.Test;

import entity.Player;

/**
 * Junit test for RollDicePhase class
 * 
 * @author Thien Duc Phung
 * @author Minh Loi
 * @author Daniel Enriquez
 * @author Brett Bauman
 * @author Tanner Siffren
 */

public class RollDicePhaseTest {

	@Test
	public void testRollDicePhase() {
	
		Player player1 = new Player(1, "guest");
		Player player2 = new Player(2, "guest2");
	
		// Test if a RollDicePhase object is created.
		RollDicePhase rollDicePhase = new RollDicePhase(player1, player2);
		assertNotNull(rollDicePhase);
	}

	@Test
	public void testGetRollWinner() {
		Player player1 = new Player(1, "guest");
		Player player2 = new Player(2, "guest2");
	
		RollDicePhase rollDicePhase = new RollDicePhase(player1, player2);
		rollDicePhase.render();
		
		// Test if getRollWinner returned a Player object.
		assertNotNull(rollDicePhase.getRollWinner());
	}

	@Test
	public void testGetRollLoser() {
		Player player1 = new Player(1, "guest");
		Player player2 = new Player(2, "guest2");
	
		RollDicePhase rollDicePhase = new RollDicePhase(player1, player2);
		rollDicePhase.render();
		
		// Test if getRollLoser returned a Player object.
		assertNotNull(rollDicePhase.getRollLoser());
	}

}
