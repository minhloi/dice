package Control;

import java.util.Scanner;

import Entity.Database;
import Entity.Player;

public class PlayState extends State{

	private GameController gameController;
	private Database database;
	private Match currentMatch;
	
	// Player's sessions
	private Player player1;
	private Player player2;
		
	public PlayState(GameController controller, Scanner scanner, Database database){
		
		this.gameController = controller;
		this.scanner = scanner;
		this.database = database;
	
	}
	
	public void createNewMatch(){
		
		// Prompt to enter user-names of two players
		createProfiles();
		
		// Create new match.
		currentMatch = new Match(player1, player2, gameController, scanner, database);
	
	}
	
	public void rematch(){
		
		// Retain username
		retainProfiles();
		
		currentMatch = new Match(player1, player2, gameController, scanner, database);
	}
	
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
	
	private void retainProfiles(){
		
		String player1Username = player1.getUserName();
		String player2Username = player2.getUserName();
		
		player1 = new Player(1, player1Username);
		player2 = new Player(2, player2Username);
		
	}
	
	public void print(){
		
		currentMatch.begin();
	
	};
			
}
