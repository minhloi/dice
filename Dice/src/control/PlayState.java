package control;

import java.awt.event.KeyEvent;
import java.util.ArrayList;

import boundary.GameObject;
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

public class PlayState extends State implements Listenable {

	private GameController gameController;
	private Database database;
	private Match currentMatch;
	private ProfileForm profileForm;
	private ArrayList<GameObject> objectList;
	private int currentState;
	
	// Player's sessions
	private Player player1;
	private Player player2;
	
	private static final int CREATING_PROFILES = 0;
	private static final int PLAYING = 1;
	
	/**
	 * Constructor - Initializes gameController, scanner, and database objects 
	 * 
	 * @param controller GameController object which controls game state.
	 * @param scanner Scanner object which scans input
	 * @param database Database object which load/save data
	 */
	public PlayState(GameController controller, ArrayList<GameObject> objectList, Database database){
		
		this.gameController = controller;
		this.objectList = objectList;
		this.database = database;
	
	}
	
	/**
	 * createProfiles - Create user profiles
	 */
	public void createProfiles(){
		
		player1 = new Player(1);
		player2 = new Player(2);
		
		setState(CREATING_PROFILES);
		profileForm = new ProfileForm(player1, player2, objectList);
				
	}
	
	public void beginMatch(){
		
		setState(PLAYING);
		createNewMatch();
		
	}
	
	
	/**
	 * rematch - Start another match with current user profiles
	 */
	public void rematch(){
		
		// Copy user-names to two new player objects.
		copyProfiles();
		
		setState(PLAYING);
		createNewMatch();
					
	}
	
	/**
	 * createNewMatch - Create a new match object.
	 */
	private void createNewMatch(){
			
		currentMatch = new Match(player1, player2, gameController, objectList, database);
		
	}
	
	/**
	 * createProfiles - Ask users for usernames. Then store each one for player1 
	 * 					and player2
	 */
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
	
	/**
	 *  copyProfiles - Keep current user profiles 
	 */
	private void copyProfiles(){
		
		String player1Username = player1.getUserName();
		String player2Username = player2.getUserName();
		
		player1 = new Player(1);
		player1.setUsername(player1Username);
		player2 = new Player(2);
		player2.setUsername(player2Username);
		
	}
	
	/**
	 * print - Display the start of the match and begin a turn.
	 */
	@Override
	public void render(){
		if(currentState == PLAYING){
			currentMatch.renderTurn();
		} else if(currentState == CREATING_PROFILES){
			profileForm.render();
			if(profileForm.isCompleted()){
				beginMatch();
			}
		}
	}
	
	private void setState(int state){
		currentState = state;
	}

	@Override
	public void onKeyPressed(KeyEvent keyEvent) {
		
	}

	@Override
	public void onKeyReleased(KeyEvent keyEvent) {
		if(currentState == PLAYING){
			currentMatch.onKeyReleased(keyEvent);
		} else if(currentState == CREATING_PROFILES){
			profileForm.onKeyReleased(keyEvent);
		}}

	@Override
	public void onKeyTyped(KeyEvent keyEvent) {
		
	};
			
}
