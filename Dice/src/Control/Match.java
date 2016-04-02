package Control;

import java.util.Scanner;

import Entity.Player;

public class Match {

	private Player player1; 
	private Player player2;
	private int currentPhase;
	private Scanner scanner;
	
	public static final int PRINT_HEALTH_PHASE = 0;
	public static final int SELECT_MOVE_PHASE = 1;
	public static final int ROLL_DICE_PHASE = 2;
	public static final int ATTACK_PHASE = 3;	
	
	public Match(Scanner scanner){

		char[] player1MoveSet = {'a', 's', 'd'};
		char[] player2MoveSet = {'j', 'k', 'l'};
		player1 = new Player(1, player1MoveSet);
		player2 = new Player(2, player2MoveSet);
		
		this.scanner = scanner;
	}
	
	public void begin(){

		// Begin match by display players' health points
		printHealthPhase();	
	}
	
		
	private void printHealthPhase(){
		
		currentPhase = PRINT_HEALTH_PHASE;
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
		System.out.printf("%-30s %-30s\n", player1.getMoveKey(Player.ATTACK) + ": attack", player2.getMoveKey(Player.ATTACK) + ": attack");
		System.out.printf("%-30s %-30s\n", player1.getMoveKey(Player.BLOCK) + ": block", player2.getMoveKey(Player.BLOCK) + ": block");
		System.out.printf("%-30s %-30s\n", player1.getMoveKey(Player.SPECIAL_ATTACK) + ": special attack", player2.getMoveKey(Player.SPECIAL_ATTACK) + ": special attack");
		System.out.println();
		
		System.out.println("Each player takes turn to inputs a key above then press enter to select move.");
		scanMove();
		System.out.println();
		
		//Advance to roll-dice phase.
		rollDicePhase();
 		
	}
	
	private void rollDicePhase(){
		
		currentPhase = ROLL_DICE_PHASE;
		System.out.println("ROLL-DICE PHASE:");
		System.out.println("-----------------------------------------------------");
		
	}
	
	private void AttackPhase(){
		
		currentPhase = ATTACK_PHASE;
		
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
		
		char[] player1MoveSet = player1.getMoveSet();
		char[] player2MoveSet = player2.getMoveSet();
		boolean found = false;
		int index = 0;
		
		while(found == false && index < player1MoveSet.length){
			if(key == player1MoveSet[index]){
				found = true;
				
				// Player 1 already selected move thus cannot select again.
				if(player1.getMove() != Player.NOT_SELECT){
					System.out.println("Player 1 cannot re-select.");
				} else {
					player1.setMove(index);
					System.out.println("Player 1 selected move succesfully.");
				}
			}
			++index;
		}
		
		index = 0;		
		while(found == false && index < player2MoveSet.length){
			if(key == player2MoveSet[index]){
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
			System.out.println("Invalid input. Please try again.");
			scanMove();
		}
		
	}
	
}
