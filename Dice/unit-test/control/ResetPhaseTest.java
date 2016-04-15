package control;

import static org.junit.Assert.*;

import org.junit.Test;

import entity.Player;

/**
 * Junit test of ResetPhase class
 * 
 * @author Thien Duc Phung
 * @author Minh Loi
 * @author Daniel Enriquez
 * @author Brett Bauman
 * @author Tanner Siffren
 */

public class ResetPhaseTest {

	@Test
	public void testResetPhase() {
	
		Player player1 = new Player(1, "guest");
		Player player2 = new Player(2, "guest2");
		
		// Test if a ResetPhase object is created.
		ResetPhase resetPhase = new ResetPhase(player1, player2);
		assertNotNull(resetPhase);
	}
	
	@Test
	public void testRender() {
		
		Player player1 = new Player(1, "guest");
		Player player2 = new Player(2, "guest2");
				
		ResetPhase resetPhase = new ResetPhase(player1, player2);
		player1.setMove(Player.ATTACK);
		player2.setMove(Player.ATTACK);
		
		// Test if players' moves are reset successfully.
		resetPhase.render();
		assertEquals(Player.NOT_SELECT, player1.getMove());
		assertEquals(Player.NOT_SELECT, player1.getMove());
		
		// Test if players' blocks are enabled after reseting two turns. 
		player1.setMove(Player.BLOCK);
		player2.setMove(Player.BLOCK);
		resetPhase.render();
		
		player1.setMove(Player.ATTACK);
		player2.setMove(Player.ATTACK);
		
		resetPhase.render();
		assertFalse(player1.isBlockDisabled());
		assertFalse(player2.isBlockDisabled());
		
	}

}
