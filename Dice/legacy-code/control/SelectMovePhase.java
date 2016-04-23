package control;

import java.util.Scanner;

import entity.Player;

/**
 * SelectMovePhase class - Capture each of the player's choice of action. Such 
 * 						   as selecting actions for the game.
 * 
 * @author Thien Duc Phung
 * @author Minh Loi
 * @author Daniel Enriquez
 * @author Brett Bauman
 * @author Tanner Siffren
 */
public class SelectMovePhase extends Phase {
	
	private Player player1;
	private Player player2;
	private Scanner scanner;
	
	/**
	 * Constructor - Prepare Player and Scanner objects
	 * 
	 * @param player1
	 * @param player2
	 * @param scanner
	 */
	public SelectMovePhase(Player player1, Player player2, Scanner scanner){
		this.player1 = player1;
		this.player2 = player2;
		this.scanner = scanner;
		
	}
	
	/**
	 * render - Display HP and move-sets. Then check whether block is disabled for
	 * 			both players and if they can use their special attack. Finally, collect
	 * 			player's choice of action
	 */
	public void render(){
		
		System.out.println("SELECT-MOVE PHASE:");
		System.out.println("-----------------------------------------------------");
		// Print players' HP
		System.out.printf("%-30s%-30s\n","Player 1 (HP: " + player1.getHealth() + ")","Player2 (HP: " + player2.getHealth() + ")");
		
		// Print players' move-sets.
		System.out.printf("%-30s%-30s\n", Match.PLAYER1_MOVE_SET[Player.ATTACK] + ": attack", Match.PLAYER2_MOVE_SET[Player.ATTACK] + ": attack");
		
		// Check if player 1 block is disabled in this turn
		if (player1.isBlockDisabled() == false) {
			System.out.printf("%-30s", Match.PLAYER1_MOVE_SET[Player.BLOCK] + ": block");
		} else {
			System.out.printf("%-30s", " ");
		}
		// Check if player 2 block is disabled in this turn
		if (player2.isBlockDisabled() == false) {
			System.out.printf("%-30s\n", Match.PLAYER2_MOVE_SET[Player.BLOCK] + ": block");
		} else {
			System.out.printf("%-30s\n", " ");
		}
		
		// Check if player 1 can select special attack
		if (player1.canUseSpecial() == true) {
			System.out.printf("%-30s", Match.PLAYER1_MOVE_SET[Player.SPECIAL_ATTACK] + ": special attack");
		} else {
			System.out.printf("%-30s", " ");
		}
		// Check if player 2 can select special attack
		if (player2.canUseSpecial() == true) {
			System.out.printf("%-30s\n", Match.PLAYER2_MOVE_SET[Player.SPECIAL_ATTACK] + ": special attack");
		} else {
			System.out.printf("%-30s\n", " ");
		}
		
		System.out.println();
		
		System.out.println("To select move, each player takes turn to input a key above then press enter.");
		scanMove();
		System.out.println();
	
	}
		
	/**
	 * scanMove - Reading input of users
	 */
	private void scanMove() {
		
		String input = scanner.next();
		
		// Input for move must be a single character.
		if (input.length() == 1) {
			
			char key = input.charAt(0);
			
			// Convert user input to corresponding move and set move.
			setMoveByKey(key);
					
			// If one/two players provided invalid inputs or haven't provided yet,
			// then scan again.
			if (player1.getMove() == Player.NOT_SELECT || player2.getMove() == Player.NOT_SELECT) {
				scanMove();
			}
			
		} else {
			System.out.println("Invalid input. Please try again.");
			scanMove();
		}
	}
	
	/**
	 * setMoveByKey - Set move of each player based on their inputs.
	 * 
	 * @param key Player's choice of move
	 */
	private void setMoveByKey(char key) {
		
		boolean found = false;
		int index = 0;
		int selecting;
		
		// Loop over all player1's move-set and find corresponding move.
		while(found == false && index < Match.PLAYER1_MOVE_SET.length) {
			if (key == Match.PLAYER1_MOVE_SET[index]) {
				found = true;
				selecting = index;
				
				// Player 1 already selected a move thus cannot select again.
				if (player1.getMove() != Player.NOT_SELECT) {
					System.out.println("Player 1 cannot re-select.");
				// Check if player 1 is able to select BLOCK.
				} else if (selecting == Player.BLOCK && player1.isBlockDisabled() == true) {
					System.out.println("Player 1 cannot BLOCK. BLOCK has been disabled for this turn.");
				// Check if player 1 is able to select SPECIAL_ATTACK.
				} else if (selecting == Player.SPECIAL_ATTACK && player1.canUseSpecial() == false) {
					System.out.println("Player 1 cannot SPECIAL_ATTACK. Maximum number of used reached.");
				} else {
					player1.setMove(index);
					System.out.println("Player 1 selected successfully.");
				}
			}
			++index;
		}
		
		index = 0;		
		
		// Loop over all player2's move-set and find corresponding move.
		while(found == false && index < Match.PLAYER2_MOVE_SET.length) {
			
			if (key == Match.PLAYER2_MOVE_SET[index]) {
				found = true;
				selecting = index;
				
				// Player 2 already selected a move thus cannot select again.
				if (player2.getMove() != Player.NOT_SELECT) {
					System.out.println("Player 2 cannot re-select.");
				// Check if player 2 is able to select BLOCK	
				} else if (selecting == Player.BLOCK && player2.isBlockDisabled() == true) {
					System.out.println("Player 2 cannot select BLOCK. Block has been disabled for this turn.");
				// Check if player 2 is able to select SPECIAL_ATTACK.
				} else if (selecting == Player.SPECIAL_ATTACK && player2.canUseSpecial() == false) {
					System.out.println("Player 2 cannot select SPECIAL_ATTACK. Maximum number of uses has been reached.");
				} else {
					player2.setMove(index);
					System.out.println("Player 2 selected successfully.");
				}
			}
			++index;
		}
		
		if (found == false) {
			
			// Invalid input. Scan again.
			System.out.println("Invalid input. Please try again.");
			scanMove();
		}
		
	}
	
}
