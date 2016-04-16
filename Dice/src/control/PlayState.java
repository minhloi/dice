package control;

import java.util.Scanner;

import entity.Database;
import entity.Player;

/**
 * PlayState class - Allow users to create usernames, save the usernames,
 * 					 and start a match
 * 
 * @author Thien Duc Phung
 * @author Minh Loi
 * @author Daniel Enriquez
 * @author Brett Bauman
 * @author Tanner Siffren
 */

public class PlayState extends State{

	private GameController gameController;
	private Database database;
	private Match currentMatch;
	
	// Player's sessions
	private Player player1;
	private Player player2;
		
	/**
	 * Constructor - Initializes gameController, scanner, and database objects 
	 * 
	 * @param controller - gameController object which controls game state.
	 * @param scanner - scanner object which scans input
	 * @param database - database object which load/save data
	 */
	public PlayState(GameController controller, Scanner scanner, Database database){
		
		this.gameController = controller;
		this.scanner = scanner;
		this.database = database;
	
	}
	
	/**
	 * startNew - Create user profiles and start a match
	 */
	public void startNew(){
		
		// Prompt to enter user names of two players
		createProfiles();
		
		createNewMatch();
		
	}
	
	/**
	 * rematch - Start another match with current user profiles
	 */
	public void rematch(){
		
		// Retain user names
		retainProfiles();
		
		createNewMatch();
				
	}
	
	/**
	 * createNewMatch - Create a new match object.
	 */
	private void createNewMatch(){
		
		currentMatch = new Match(player1, player2, gameController, scanner, database);
	
	}
	
	/**
	 * createProfiles - Ask users for usernames. Then store each one for player1 
	 * 					and player2
	 */
	private void createProfiles(){
		
		String player1Username;
		String player2Username;
		
		System.out.print("Please enter username for Player 1: ");
		player1Username = scanner.next();
		
		System.out.print("Please enter username for Player 2: ");
		player2Username = scanner.next();
		
		// Create new players.
		player1 = new Player(1, player1Username);
		player2 = new Player(2, player2Username);
			
	}
	
	/**
	 *  retainProfiles - Keep current user profiles 
	 */
	private void retainProfiles(){
		
		String player1Username = player1.getUserName();
		String player2Username = player2.getUserName();
		
		player1 = new Player(1, player1Username);
		player2 = new Player(2, player2Username);
		
	}
	
	/**
	 * print - Display the start of the match and begin a turn.
	 */
	public void print(){
		currentMatch.beginTurn();
	};
			
}
