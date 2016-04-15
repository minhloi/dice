package control;

import java.util.Scanner;

import entity.Database;

/**
 * GameEngine class with initializing  GameControler
 * 
 * @author Thien Duc Phung
 * @author Minh Loi
 * @author Daniel Enriquez
 * @author Brett Bauman
 * @author Tanner Siffren
 */

public class GameController {
		
	private State[] stateList;
	private Scanner scanner;
	private Database database;
	
	private int stateLength;
	private int currentState;
	
	// All static variable values needed for state of the game
	public static final int MENU_STATE = 0;
	public static final int PLAY_STATE = 1;
	public static final int VIEW_RANK_STATE = 2;
	public static final int MATCH_END_MENU_STATE = 3; // Menu displayed when a match ended
	
	/**
	 * GameController with initializing all need variables, arrays.
	 */
	public GameController() {
		
		scanner = new Scanner(System.in);
		database = new Database();
		
		stateLength = 4;
		stateList = new State[stateLength];
		stateList[MENU_STATE] = new MenuState(this, scanner);
		stateList[PLAY_STATE] = new PlayState(this, scanner, database);
		stateList[VIEW_RANK_STATE] = new ViewRankState(this, scanner, database);
		stateList[MATCH_END_MENU_STATE] = new MatchEndMenuState(this, scanner);
		
		// Default is Menu
		currentState = MENU_STATE;
			
	}
	
	/**
	 *  Load players' data method
	 */
	public void init() {
		
		// Load all players' data.
		database.loadData();
		
	}
	
	/**
	 *  Method to select the state in game
	 *  
	 * @param state - type of state of the game
	 * @return all the data stored in stateList of current state
	 * 
	 */
	
	public State getState(int state) {
		
		return stateList[state];
		
	}
	
	/**
	 *  Method to set the state in game
	 *  
	 * @param state - type of state of the game
	 */
	public void setState(int state) {
		
		currentState = state;
		
	}
	
	/**
	 *  Method to exit, all data will be save before exit
	 */
	public void exitGame() {
		
		// Before exit
		database.saveData();
		scanner.close();
		
		System.out.print("Exit!");
		
	}
	
	/**
	 *  Method to render the current state the game in
	 */
	public void renderCurrentState() {
		
		stateList[currentState].print();
		
	}
		
}
