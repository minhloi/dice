package control;

import java.util.ArrayList;
import java.util.Scanner;

import boundary.GameObject;
import boundary.PlayerObject;
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

	private Turn currentTurn;
	
	private ArrayList<GameObject> objectList;
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
	public Match(Player player1, Player player2, GameController gameController, ArrayList<GameObject> objectList, Database database) {
		
		this.player1 = player1;
		this.player2 = player2;
		this.gameController = gameController;
		this.objectList = objectList;
		this.database = database;
		this.currentTurn = new Turn(player1, player2, objectList);
		
	}
		
	/**
	 * Method to begin the fight 
	 */
	public void renderTurn() {
		
		currentTurn.render();
									
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
