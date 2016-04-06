package Control;

import java.util.Scanner;

import Entity.Player;

public class Match {

	private Player player1; 
	private Player player2;
	private Player rollWinner;
	private Player rollLoser;

	private int currentPhase;
	private int currentTurn;
	private Scanner scanner;
	
	// Phase definition
	public static final int SELECT_MOVE_PHASE = 0;
	public static final int ROLL_DICE_PHASE = 1;
	public static final int BATTLE_PHASE = 2;
	
	// Player move-set definition
	private static final char[] PLAYER1_MOVE_SET = {'a', 's', 'd'};
	private static final char[] PLAYER2_MOVE_SET = {'j', 'k', 'l'};
	
	public Match(Scanner scanner){
		
		player1 = new Player(1);
		player2 = new Player(2);
		
		this.scanner = scanner;
	}
	
	public void begin(){
		
		currentTurn = 1;
		
		System.out.println("GAME STARTED - TURN " + currentTurn + ":");
		System.out.println("-----------------------------------------------------");
		System.out.println();
		
		// Begin by allowing each player to select their moves. 
		selectMovePhase();	
	}
	
	public void nextTurn(){
		
		++currentTurn;
		System.out.println("TURN " + currentTurn + ":");
		System.out.println("-----------------------------------------------------");
		System.out.println();
		
		selectMovePhase();	
			
	}
	
	private void selectMovePhase(){
		
		currentPhase = SELECT_MOVE_PHASE;
		System.out.println("SELECT-MOVE PHASE:");
		System.out.println("-----------------------------------------------------");
		// Print players' HP
		System.out.printf("%-30s %-30s\n","Player 1 (HP: " + player1.getHealth() + ")","Player2 (HP: " + player2.getHealth() + ")");
		// Print players' move-sets.
		System.out.printf("%-30s %-30s\n", PLAYER1_MOVE_SET[Player.ATTACK] + ": attack", PLAYER2_MOVE_SET[Player.ATTACK] + ": attack");
		System.out.printf("%-30s %-30s\n", PLAYER1_MOVE_SET[Player.BLOCK] + ": block", PLAYER2_MOVE_SET[Player.BLOCK] + ": block");
		System.out.printf("%-30s %-30s\n", PLAYER1_MOVE_SET[Player.SPECIAL_ATTACK] + ": special attack", PLAYER2_MOVE_SET[Player.SPECIAL_ATTACK] + ": special attack");
		System.out.println();
		
		System.out.println("To select move, each player takes turn to input a key above then press enter.");
		scanMove();
		System.out.println();
		
		// Advance to roll-dice phase.
		rollDicePhase();
 		
	}
	
	private void rollDicePhase(){
		
		currentPhase = ROLL_DICE_PHASE;
			
		System.out.println("ROLL-DICE PHASE:");
		System.out.println("-----------------------------------------------------");
		
		// Roll die of two players to 
		// determine winner and loser of this turn.
		rollDie();
		
		System.out.println("Go to battle in 3 seconds...");
		System.out.println();
		
		// Wait 3 seconds, allow players to see their results.
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		// Advance to battle phase;
		battlePhase();
				
	}
	
	private void battlePhase(){
		
		currentPhase = BATTLE_PHASE;
		System.out.println("BATTLE PHASE:");
		System.out.println("-----------------------------------------------------");
		
		// Winner rolls dice again
		int initialDamage = rollWinner.getDice().roll();			
		
		// Print dice roll of winner
		System.out.println("Player " + rollWinner.getNumber() + " rolled dice once more is: " + initialDamage + ".");
		
		// Print the selected moves of two players.
		System.out.print("Player " + rollWinner.getNumber() + " selected " + rollWinner.getMoveInString() + ". ");
		System.out.println("Player " + rollLoser.getNumber() + " selected " + rollLoser.getMoveInString() + ".");
		
		// Calculate damage to the loser.
		calculateDamage(initialDamage);
		System.out.println();
		
		// Check if there is a winner of the match.
		if(player1.getHealth() < 0){
			System.out.println("Player 2 win the game. GAME OVER.");
		} else if(player2.getHealth() < 0){
			System.out.println("Player 1 win the game. GAME OVER.");
		} else {
			
			// No one wins the game yet then reset phase for new turn
			resetPhase();
			System.out.println("Please press any keys for next turn.");
			scanner.next();
			System.out.println();
			
			// Go to next turn.
			nextTurn();
		}
		
	}
	
	private void scanMove(){
		
		String input = scanner.next();
		
		// Input for move must be a single character.
		if(input.length() == 1){
			
			char key = input.charAt(0);
			
			// Convert user input to corresponding move and set move.
			setMoveByKey(key);
					
			// If one/two players provided invalid inputs or haven't provided yet,
			// then scan again.
			if(player1.getMove() == Player.NOT_SELECT || player2.getMove() == Player.NOT_SELECT){
				scanMove();
			}
			
		} else {
			System.out.println("Invalid input. Please try again.");
			scanMove();
		}
	}
	
	private void setMoveByKey(char key){
		
		boolean found = false;
		int index = 0;
		
		// Loop over all player1's move-set and find corresponding move.
		while(found == false && index < PLAYER1_MOVE_SET.length){
			if(key == PLAYER1_MOVE_SET[index]){
				found = true;
				
				// Player 1 already selected a move thus cannot select again.
				if(player1.getMove() != Player.NOT_SELECT){
					System.out.println("Player 1 cannot re-select.");
				} else {
					player1.setMove(index);
					System.out.println("Player 1 selected successfully.");
				}
			}
			++index;
		}
		
		index = 0;		
		// Loop over all player2's move-set and find corresponding move.
		while(found == false && index < PLAYER2_MOVE_SET.length){
			if(key == PLAYER2_MOVE_SET[index]){
				found = true;
				
				// Player 2 already selected a move thus cannot select again.
				if(player2.getMove() != Player.NOT_SELECT){
					System.out.println("Player 2 cannot re-select.");
				} else {
					player2.setMove(index);
					System.out.println("Player 2 selected successfully.");
				}
			}
			++index;
		}
		
		if(found == false){
			// Invalid input. Scan again.
			System.out.println("Invalid input. Please try again.");
			scanMove();
		}
		
	}
	
	private void rollDie(){
		
		int player1Dice =  player1.getDice().roll();
		int player2Dice =  player2.getDice().roll();
		
		System.out.println("Player 1 Dice: " + player1Dice);
		System.out.println("Player 2 Dice: " + player2Dice);
		
		if (player1Dice > player2Dice){
			
			rollWinner = player1;
			rollLoser = player2;
			System.out.println("Player 1 wins this turn.");
			System.out.println();
						
		} else if (player1Dice < player2Dice){

			rollWinner = player2;
			rollLoser = player1;
			System.out.println("Player 2 wins this turn.");
			System.out.println();
			
		} else {
			
			System.out.println("Tie! Roll again...");
			System.out.println();
			// Roll again.
			rollDie();	
		}
		
	}
	
	private void calculateDamage(int initialDamage){
		
		// CASE 1: Winner selected ATTACK.
		if(rollWinner.getMove() == Player.ATTACK){
			
			// Loser selected ATTACK or SPECIAL_ATTACK takes full damage.
			if(rollLoser.getMove() == Player.ATTACK || rollLoser.getMove() == Player.SPECIAL_ATTACK){
				
				int damage = initialDamage;
				// Set damage.
				rollLoser.setHealth(rollLoser.getHealth() - damage);
				// Print damage.
				System.out.println("Therefore, player " + rollLoser.getNumber() + " takes " + damage + " damage (full damage).");
			
			// Loser selected BLOCK takes half damage.
			} else if(rollLoser.getMove() == Player.BLOCK){
				
				int damage = (int)(initialDamage * (float) 1/2);
				// Set damage.
				rollLoser.setHealth(rollLoser.getHealth() - damage);
				// Print damage.
				System.out.println("Therefore, player " + rollLoser.getNumber() + " takes " + damage + " damage (half damage).");
								
			}
			
		// CASE 2: Winner selected BLOCK.	
		} else if(rollWinner.getMove() == Player.BLOCK){
			
			// Loser selected ATTACK or SPECIAL_ATTACK takes half damage.
			if(rollLoser.getMove() == Player.ATTACK || rollLoser.getMove() == Player.SPECIAL_ATTACK){
				
				int damage = (int)(initialDamage * (float) 1/2);
				// Set damage.
				rollLoser.setHealth(rollLoser.getHealth() - damage);
				// Print damage.
				System.out.println("Therefore, player " + rollLoser.getNumber() + " takes " + (damage) + " damage (half damage).");
			
			// Loser selected BLOCK takes a quarter of damage.
			} else if(rollLoser.getMove() == Player.BLOCK){
				
				int damage = (int)(initialDamage * (float) 1/4);
				// Set damage.
				rollLoser.setHealth(rollLoser.getHealth() - damage);
				// Print damage.
				System.out.println("Therefore, player " + rollLoser.getNumber() + " takes " + (damage) + " damage (1/4 damage).");
								
			}
		

		// CASE 3: Winner selected SPECIAL_ATTACK.	
		} else if(rollWinner.getMove() == Player.SPECIAL_ATTACK){
			
			// Loser selected ATTACK or SPECIAL_ATTACK takes doubled damage.
			if(rollLoser.getMove() == Player.ATTACK || rollLoser.getMove() == Player.SPECIAL_ATTACK){
						
				int damage = 2 * initialDamage;
				// Set damage.
				rollLoser.setHealth(rollLoser.getHealth() - damage);
				// Print damage.
				System.out.println("Therefore, player " + rollLoser.getNumber() + " takes " + damage + " damage (doubled damage).");
			
			// Loser selected BLOCK takes full normal damage.
			} else if(rollLoser.getMove() == Player.BLOCK){
				
				int damage = initialDamage;
				// Set damage.
				rollLoser.setHealth(rollLoser.getHealth() - damage);
				// Print damage.
				System.out.println("Therefore, player " + rollLoser.getNumber() + " takes " + damage + " damage (normal damage).");
								
			}
		
		}
		
	}
	
	public void resetPhase(){
		
		rollWinner = null;
		rollLoser = null;
		
		// reset players' selected moves
		player1.resetMove();
		player2.resetMove();
				
	}
	
}