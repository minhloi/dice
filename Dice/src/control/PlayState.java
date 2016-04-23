package control;

import java.awt.event.KeyEvent;
import java.util.ArrayList;

import boundary.GameObject;
import entity.Database;
import entity.Player;

public class PlayState extends State implements Listenable {

	private GameController gameController;
	private Database database;
	private Match currentMatch;
	private ArrayList<GameObject> objectList;
	
	// Player's sessions
	private Player player1;
	private Player player2;
		
	public PlayState(GameController controller, ArrayList<GameObject> objectList, Database database){
		
		this.gameController = controller;
		this.objectList = objectList;
		this.database = database;
	
	}
	
	public void startNew(){
		
		player1 = new Player(1, "Guest");
		player2 = new Player(2, "Guest2");
		
		createNewMatch();
		
	}
	
	public void rematch(){
		
		// Retain user names
		retainProfiles();
		
		createNewMatch();
				
	}
	
	private void createNewMatch(){
			
		currentMatch = new Match(player1, player2, gameController, objectList, database);
	
	}
	
	/* private void createProfiles(){
		
		String player1Username;
		String player2Username;
		
		System.out.print("Please enter username for Player 1: ");
		player1Username = scanner.next();
		
		System.out.print("Please enter username for Player 2: ");
		player2Username = scanner.next();
		
		// Create new players.
		player1 = new Player(1, player1Username);
		player2 = new Player(2, player2Username);
			
	} */
	
	private void retainProfiles(){
		
		String player1Username = player1.getUserName();
		String player2Username = player2.getUserName();
		
		player1 = new Player(1, player1Username);
		player2 = new Player(2, player2Username);
		
	}
	
	public void print(){
		currentMatch.renderTurn();
	}

	@Override
	public void onKeyPressed(KeyEvent keyEvent) {
		currentMatch.onKeyPressed(keyEvent);
	}

	@Override
	public void onKeyReleased(KeyEvent keyEvent) {
		currentMatch.onKeyReleased(keyEvent);
	}

	@Override
	public void onKeyTyped(KeyEvent keyEvent) {
		
	};
			
}
