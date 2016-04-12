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
		currentMatch = new Match(player1, player2, gameController, scanner);
	
	}
	
	public void rematch(){
		
		// TODO: if rematch is selected, it should retain current usernames of two players ;
						
		currentMatch = new Match(player1, player2, gameController, scanner);
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
	
	public void print(){
		
		currentMatch.begin();
	
	};
			
}
