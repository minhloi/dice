package Control;

import java.util.Scanner;

import Entity.Player;

public class PlayState extends State{

	private GameController gameController;	
	private Match currentMatch;
	
	// Player's sessions
	private Player player1;
	private Player player2;
		
	public PlayState(GameController controller, Scanner scanner){
		
		this.gameController = controller;
		this.scanner = scanner;
	
	}
	
	public void createNewMatch(){
		
		// Create new players.
		player1 = new Player(1);
		player2 = new Player(2);
		
		// Create new match.
		currentMatch = new Match(player1, player2, gameController, scanner);
	
	}
	
	public void rematch(){
		
		// If rematch is selected, create a new match
		// but use current players' information.
		currentMatch = new Match(player1, player2, gameController, scanner);
	}
	
	public void print(){
		
		currentMatch.begin();
	
	};
			
}
