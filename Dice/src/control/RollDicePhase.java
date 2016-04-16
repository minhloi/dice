package control;

import java.util.Scanner;

import entity.Player;

/**
 * RollDicePhase class - Trigger Dice class to generate the value and display 
 * 						 who win the roll
 * 
 * @author Thien Duc Phung
 * @author Minh Loi
 * @author Daniel Enriquez
 * @author Brett Bauman
 * @author Tanner Siffren
 */
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
	 * render - Render roll-dice phase.
	 */
	public void render(){
	
		System.out.println("ROLL-DICE PHASE:");
		System.out.println("-----------------------------------------------------");
		
		rollDie();
		
	}
	
	/**
	 * getRollWinner - Get roll winner of the turn.
	 */
	public Player getRollWinner(){
		return rollWinner;
	}
	
	/**
	 * getRollLoser - Get roll loser of the turn.
	 */
	public Player getRollLoser(){
		return rollLoser;
	}
	
	/**
	 * rollDie - Roll die of two players to determine who wins the turn.
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
