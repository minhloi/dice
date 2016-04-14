package control;

import static org.junit.Assert.*;

import org.junit.Test;

import entity.Player;

public class BattlePhaseTest {

	@Test
	public void testBattlePhase() {
	
		Player rollWinner = new Player(1, "guest");
		Player rollLoser = new Player(2, "guest2");

		BattlePhase battlePhase = new BattlePhase(rollWinner, rollLoser);
		assertNotNull(battlePhase);
			
	}

	@Test  
	public void testRender() {

		Player rollWinner = new Player(1, "guest");
		Player rollLoser = new Player(2, "guest2");
		
		rollWinner.setMove(Player.BLOCK);
		rollLoser.setMove(Player.BLOCK);
				
		BattlePhase battlePhase = new BattlePhase(rollWinner, rollLoser);
		battlePhase.render();
		
		// Test if health point of rollLoser is deducted. 
		assertTrue(rollLoser.getHealth() != Player.DEFAULT_HEALTH_POINT);
	}
}
