package control;

import java.util.Scanner;

import entity.Player;

public class RollDicePhase extends Phase {
	
	private Player player1;
	private Player player2;
	private Player rollWinner;
	private Player rollLoser;
	
	public RollDicePhase(Player player1, Player player2){
		this.player1 = player1;
		this.player2 = player2;
	}
	
	/**
	 * Method of rolling dice to decide who go first in current turn
	 */
	public void render(){
	
		System.out.println("ROLL-DICE PHASE:");
		System.out.println("-----------------------------------------------------");
		
		// Roll dice of two players to 
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
				
	}
	
	public Player getRollWinner(){
		return rollWinner;
	}
	
	public Player getRollLoser(){
		return rollLoser;
	}
	
	/**
	 * Method to roll the dice on both players
	 */
	private void rollDie() {
		
		int player1Dice =  player1.getDice().roll();
		int player2Dice =  player2.getDice().roll();
		
		System.out.println("Player 1 Dice: " + player1Dice);
		System.out.println("Player 2 Dice: " + player2Dice);
		
		if (player1Dice > player2Dice) {
			
			rollWinner = player1;
			rollLoser = player2;
			System.out.println("Player 1 wins this turn.");
			System.out.println();
						
		} else if (player1Dice < player2Dice) {

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

}
