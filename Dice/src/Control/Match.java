package Control;

import java.util.Scanner;

import Entity.Player;

public class Match {

	private Player player1; 
	private Player player2;
	private Player rollWinner;
	private Player rollLoser;

	private int currentPhase;
	private Scanner scanner;
	
	// Phase definition
	public static final int PRINT_HEALTH_PHASE = 0;
	public static final int SELECT_MOVE_PHASE = 1;
	public static final int ROLL_DICE_PHASE = 2;
	public static final int BATTLE_PHASE = 3;
	
	// Player move-set definition
	private static final char[] PLAYER1_MOVE_SET = {'a', 's', 'd'};
	private static final char[] PLAYER2_MOVE_SET = {'j', 'k', 'l'};
	
	public Match(Scanner scanner){
		
		player1 = new Player(1);
		player2 = new Player(2);
		
		this.scanner = scanner;
	}
	
	public void begin(){

		// Begin match by display players' health points
		printHealthPhase();	
	}
	
		
	private void printHealthPhase(){
		
		currentPhase = PRINT_HEALTH_PHASE;
		System.out.println("PRINT-HEALTH PHASE:");
		System.out.println("-----------------------------------------------------");
		System.out.println("Player 1 HP: " + player1.getHealth());
		System.out.println("Player 2 HP: " + player2.getHealth());
		System.out.println();
		
		// Advance to select-move phase
		selectMovePhase();
	}
	
	private void selectMovePhase(){
		
		currentPhase = SELECT_MOVE_PHASE;
		System.out.println("SELECT-MOVE PHASE:");
		System.out.println("-----------------------------------------------------");
		System.out.printf("%-30s %-30s\n","Player 1","Player2");
		System.out.printf("%-30s %-30s\n", PLAYER1_MOVE_SET[Player.ATTACK] + ": attack", PLAYER2_MOVE_SET[Player.ATTACK] + ": attack");
		System.out.printf("%-30s %-30s\n", PLAYER1_MOVE_SET[Player.BLOCK] + ": block", PLAYER2_MOVE_SET[Player.BLOCK] + ": block");
		System.out.printf("%-30s %-30s\n", PLAYER1_MOVE_SET[Player.SPECIAL_ATTACK] + ": special attack", PLAYER2_MOVE_SET[Player.SPECIAL_ATTACK] + ": special attack");
		System.out.println();
		
		System.out.println("Each player takes turn to input a key above then press enter to select move.");
		scanMove();
		System.out.println();
		
		// Advance to roll-dice phase.
		rollDicePhase();
 		
	}
	
	private void rollDicePhase(){
		
		currentPhase = ROLL_DICE_PHASE;
			
		System.out.println("ROLL-DICE PHASE:");
		System.out.println("-----------------------------------------------------");
		
		rollDie();
		
		// Advance to battle phase;
		battlePhase();
				
	}
	
	private void battlePhase(){
		
		currentPhase = BATTLE_PHASE;
		System.out.println("BATTLE PHASE:");
		System.out.println("-----------------------------------------------------");
		
		if(rollWinner.getMove() == Player.ATTACK){
			
			int damage = rollWinner.getDice().roll();			
			System.out.println("Player " + rollWinner.getNumber() + " rolled one more for damamge: " + damage + ".");
			
			System.out.print("Player " + rollWinner.getNumber() + " selected ATTACK. ");
			
			if(rollLoser.getMove() == Player.ATTACK){
			
				rollLoser.setHealth(rollLoser.getHealth() - damage);
				System.out.println("Player " + rollLoser.getNumber() + " also selected ATTACK. Thus player " + rollLoser.getNumber() + " takes full damage which is " + damage + ".");
			
			} else if(rollLoser.getMove() == Player.SPECIAL_ATTACK){
			
				rollLoser.setHealth(rollLoser.getHealth() - damage);
				System.out.println("Player " + rollLoser.getNumber() + " selected SPECIAL_ATTACK. Thus player " + rollLoser.getNumber() + " takes full damage which is " + damage + ".");
			
			} else if(rollLoser.getMove() == Player.BLOCK){
				
				rollLoser.setHealth(rollLoser.getHealth() - 1/2*damage);
				System.out.println("Player " + rollLoser.getNumber() + " selected BLOCK. Thus player " + rollLoser.getNumber() + " takes half damage which is " + 1/2*damage + ".");
								
			}
			
		} else if(rollWinner.getMove() == Player.BLOCK){
			
			System.out.print("Player " + rollWinner.getNumber() + " won the roll but selected BLOCK thus nothing happens in this turn.");
		
		}
		
		System.out.println();
		
		// reset for new turn;
		resetPhase();
		
		if(player1.getHealth() < 0){
			System.out.println("Player 2 win the game. GAME OVER.");
		} else if(player2.getHealth() < 0){
			System.out.println("Player 1 win the game. GAME OVER.");
		} else {
			// go to next turn.
			System.out.println("Please press any keys for next turn.");
			scanner.next();
			
			printHealthPhase();
		}
		
	}
	
	private void scanMove(){
		
		String input = scanner.next();
		
		if(input.length() == 1){
			
			char key = input.charAt(0);
			setMoveByKey(key);
					
			// If one or two players have not input yet or provide invalid inputs,
			// then scan again;
			if(player1.getMove() == Player.NOT_SELECT || player2.getMove() == Player.NOT_SELECT){
				scanMove();
			}
			
		} else if(input.length() >= 2){
			System.out.println("Invalid input. Please try again.");
			scanMove();
		}
	}
	
	private void setMoveByKey(char key){
		
		boolean found = false;
		int index = 0;
		
		while(found == false && index < PLAYER1_MOVE_SET.length){
			if(key == PLAYER1_MOVE_SET[index]){
				found = true;
				
				// Player 1 already selected move thus cannot select again.
				if(player1.getMove() != Player.NOT_SELECT){
					System.out.println("Player 1 cannot re-select.");
				} else {
					player1.setMove(index);
					System.out.println("Player 1 selected move successfully.");
				}
			}
			++index;
		}
		
		index = 0;		
		while(found == false && index < PLAYER2_MOVE_SET.length){
			if(key == PLAYER2_MOVE_SET[index]){
				found = true;
				
				// Player 2 already selected move thus cannot select again.
				if(player2.getMove() != Player.NOT_SELECT){
					System.out.println("Player 2 cannot re-select.");
				} else {
					player2.setMove(index);
					System.out.println("Player 2 selected move successfully.");
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
		System.out.println();
		
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
			rollDie();	
		}
		
	}
	
	public void resetPhase(){
		
		rollWinner = null;
		rollLoser = null;
		player1.resetMove();
		player2.resetMove();
				
	}
	
}
