package control;

import entity.Player;

/**
 * BattlePhase containing the action methods such as
 * damage calculate
 * 
 * @author Thien Duc Phung
 * @author Minh Loi
 * @author Daniel Enriquez
 * @author Brett Bauman
 * @author Tanner Siffren
 */

public class BattlePhase extends Phase {
	
	private Player rollWinner;
	private Player rollLoser;
	
	public BattlePhase(Player rollWinner, Player rollLoser){
	
		this.rollWinner = rollWinner;
		this.rollLoser = rollLoser;
	}
	
	public void render(){

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
		try {
			calculateDamage(initialDamage);
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println();
						
	}
	
	/**
	 * Method to calculate damage dealt to other player
	 * @throws Exception exception throws when either players has not selected their move.
	 */
	private void calculateDamage(int initialDamage) throws Exception {
		
		if(rollWinner.getMove() == Player.NOT_SELECT || rollLoser.getMove() == Player.NOT_SELECT) {
			throw new Exception("One of the players have not selected move");
		}
		
		// CASE 1: Winner selected ATTACK.
		if (rollWinner.getMove() == Player.ATTACK) {
			
			// Loser selected ATTACK or SPECIAL_ATTACK takes full damage.
			if (rollLoser.getMove() == Player.ATTACK || rollLoser.getMove() == Player.SPECIAL_ATTACK) {
				
				int damage = initialDamage;
				// Set damage.
				rollLoser.setHealth(rollLoser.getHealth() - damage);
				// Print damage.
				System.out.println("Therefore, player " + rollLoser.getNumber() + " takes " + damage + " damage (full damage).");
			
			// Loser selected BLOCK takes half damage.
			} else if (rollLoser.getMove() == Player.BLOCK) {
				
				int damage = (int) Math.ceil(initialDamage * (float) 1/2);
				// Set damage.
				rollLoser.setHealth(rollLoser.getHealth() - damage);
				// Print damage.
				System.out.println("Therefore, player " + rollLoser.getNumber() + " takes " + damage + " damage (half damage).");
								
			}
			
		// CASE 2: Winner selected BLOCK.	
		} else if (rollWinner.getMove() == Player.BLOCK) {
			
			// Loser selected ATTACK or SPECIAL_ATTACK takes half damage.
			if (rollLoser.getMove() == Player.ATTACK || rollLoser.getMove() == Player.SPECIAL_ATTACK) {
				
				int damage = (int) Math.ceil(initialDamage * (float) 1/2);
				// Set damage.
				rollLoser.setHealth(rollLoser.getHealth() - damage);
				// Print damage.
				System.out.println("Therefore, player " + rollLoser.getNumber() + " takes " + (damage) + " damage (half damage).");
			
			// Loser selected BLOCK takes a quarter of damage.
			} else if (rollLoser.getMove() == Player.BLOCK) {
				
				int damage = (int) Math.ceil(initialDamage * (float) 1/4);
				// Set damage.
				rollLoser.setHealth(rollLoser.getHealth() - damage);
				// Print damage.
				System.out.println("Therefore, player " + rollLoser.getNumber() + " takes " + (damage) + " damage (1/4 damage).");
								
			}
		

		// CASE 3: Winner selected SPECIAL_ATTACK.	
		} else if (rollWinner.getMove() == Player.SPECIAL_ATTACK) {
			
			// Loser selected ATTACK or SPECIAL_ATTACK takes doubled damage.
			if (rollLoser.getMove() == Player.ATTACK || rollLoser.getMove() == Player.SPECIAL_ATTACK) {
						
				int damage = 2 * initialDamage;
				// Set damage.
				rollLoser.setHealth(rollLoser.getHealth() - damage);
				// Print damage.
				System.out.println("Therefore, player " + rollLoser.getNumber() + " takes " + damage + " damage (doubled damage).");
			
			// Loser selected BLOCK takes full normal damage.
			} else if (rollLoser.getMove() == Player.BLOCK) {
				
				int damage = initialDamage;
				// Set damage.
				rollLoser.setHealth(rollLoser.getHealth() - damage);
				// Print damage.
				System.out.println("Therefore, player " + rollLoser.getNumber() + " takes " + damage + " damage (normal damage).");
								
			}
		
		}
		
	}

}