package control;

import java.util.Scanner;

import entity.Database;
import entity.Player;

/**
 * Match class with all the require method of the game to play
 * 
 * @author Thien Duc Phung
 * @author Minh Loi
 * @author Daniel Enriquez
 * @author Brett Bauman
 * @author Tanner Siffren
 * 
 */

public class Match {

	private Player player1; 
	private Player player2;

	private int currentTurn;
	
	private Scanner scanner;
	private GameController gameController;
	private Database database;
		
	// Player move-set definition
	public static final char[] PLAYER1_MOVE_SET = {'a', 's', 'd'};
	public static final char[] PLAYER2_MOVE_SET = {'j', 'k', 'l'};
	
	/**
	 * 
	 * @param player1
	 * @param player2
	 * @param gameController
	 * @param scanner
	 * @param database
	 */
	public Match(Player player1, Player player2, GameController gameController, Scanner scanner, Database database) {
		
		this.player1 = player1;
		this.player2 = player2;
		this.gameController = gameController;
		this.scanner = scanner;
		this.database = database;
		this.currentTurn = 0;
		
	}
		
	/**
	 * Method to begin the fight 
	 */
	public void beginTurn() {
		
		currentTurn++;
		
		System.out.println("TURN " + currentTurn + ":");
		System.out.println("-----------------------------------------------------");
		System.out.println();
		
		// Begin by allowing each player to select their moves. 
		SelectMovePhase selectMovePhase = new SelectMovePhase(player1, player2, scanner);
		selectMovePhase.render();
		
		RollDicePhase rollDicePhase = new RollDicePhase(player1, player2);
		rollDicePhase.render();
		
		BattlePhase battlePhase = new BattlePhase(rollDicePhase.getRollWinner(), rollDicePhase.getRollLoser());
		battlePhase.render();
		
		ResetPhase resetPhase = new ResetPhase(player1, player2);
		resetPhase.render();
				
		if(hasWinner()){
			
			displayWinner();
			
			// Exiting game suddenly can lose data so
			// it's better to save data after every match.
			database.saveData();
			
			// Go to Menu state
			gameController.setState(GameController.MATCH_END_MENU_STATE);
			gameController.renderCurrentState();
			
		} else {
		
			// No one wins the game yet then go to next turn
			System.out.println("Next turn in 5 seconds...");
			System.out.println();
			
			// Wait 5 seconds for a new turn.
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println();
			beginTurn();
			
		}
		
	}
	
	private void displayWinner(){
		
		// Player 1 loses
		if (player1.getHealth() <= 0) {
			
			database.incrementWinByName(player2.getUserName());
			database.incrementLossByName(player1.getUserName());
			
			System.out.println("Player 2 won the game. GAME OVER.");
		// Player 2 loses
		} else {

			database.incrementWinByName(player1.getUserName());
			database.incrementLossByName(player2.getUserName());
			
			System.out.println("Player 1 won the game. GAME OVER.");
		
		}
		
		System.out.println();

	}
	
	private boolean hasWinner(){
		
		boolean hasWinner;
		
		// Check health points of two players.
		if (player1.getHealth() > 0 && player2.getHealth() > 0) {
			hasWinner = false;
		} else {
			hasWinner = true;						
		}
		
		return hasWinner;		
	}
		
}
