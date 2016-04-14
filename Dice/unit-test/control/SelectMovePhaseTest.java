package control;

import static org.junit.Assert.*;

import java.io.ByteArrayInputStream;
import java.util.Scanner;

import org.junit.Test;

import entity.Player;

public class SelectMovePhaseTest {

	@Test
	public void testSelectMovePhase() {
		
		Player player1 = new Player(1, "guest");
		Player player2 = new Player(2, "guest2");
		Scanner scanner = new Scanner(System.in);
		
		// Test if a SelectMovePhase object is created.
		SelectMovePhase selectMovePhase = new SelectMovePhase(player1, player2, scanner);
		assertNotNull(selectMovePhase);
	}
	
	@Test
	public void testRender() {
		
		// Mock select inputs.
		String selectMove = Match.PLAYER1_MOVE_SET[Player.ATTACK] + "\n" + Match.PLAYER2_MOVE_SET[Player.BLOCK];
		System.setIn(new ByteArrayInputStream(selectMove.getBytes()));
				
		Player player1 = new Player(1, "guest");
		Player player2 = new Player(2, "guest2");
		Scanner scanner = new Scanner(System.in);
		
		SelectMovePhase selectMovePhase = new SelectMovePhase(player1, player2, scanner);
		
		// Test if inputs are captured and set correctly in Player objects.
		selectMovePhase.render();
		
		assertEquals(Player.ATTACK, player1.getMove());
		assertEquals(Player.BLOCK, player2.getMove());
		
	}
	
	@Test
	public void testReselectNotAllowed() {
		
		// Mock inputs such that player1 selects twice
		String selectMove = Match.PLAYER1_MOVE_SET[Player.ATTACK] + "\n" + Match.PLAYER1_MOVE_SET[Player.BLOCK] + "\n" + Match.PLAYER2_MOVE_SET[Player.BLOCK];
		System.setIn(new ByteArrayInputStream(selectMove.getBytes()));
				
		Player player1 = new Player(1, "guest");
		Player player2 = new Player(2, "guest2");
		Scanner scanner = new Scanner(System.in);
		
		SelectMovePhase selectMovePhase = new SelectMovePhase(player1, player2, scanner);
		selectMovePhase.render();
		
		// Test if the first input of player1 is set but not the second.
		assertFalse(scanner.hasNext());
		assertEquals(Player.ATTACK, player1.getMove());
		assertEquals(Player.BLOCK, player2.getMove());
		
	}
		
}
