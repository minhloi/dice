package control;

import java.util.ArrayList;

import boundary.GameObject;
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
	private Database database;
	
	private int stateLength;
	private int currentState;
	
	// All static variable values needed for state of the game
	public static final int MENU_STATE = 0;
	public static final int PLAY_STATE = 1;
	public static final int VIEW_RANK_STATE = 2;
	
	/**
	 * GameController with initializing all need variables, arrays.
	 */
	public GameController(ArrayList<GameObject> objectList) {
		
		database = new Database();
				
		stateLength = 3;
		stateList = new State[stateLength];
		stateList[MENU_STATE] = new MainMenuState(this, objectList);
		stateList[PLAY_STATE] = new PlayState(this, objectList, database);
		//stateList[VIEW_RANK_STATE] = new ViewRankState(this, scanner, database);
		
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
	
	public State getCurrentStateObject(){
		return stateList[currentState];		
	}
	
	/**
	 *  Method to exit, all data will be save before exit
	 */
	public void exitGame() {
		
		// Before exit
		database.saveData();
		
		System.exit(0);
	}
	
	/**
	 *  Method to print the current state the game in
	 */
	public void render() {
		stateList[currentState].print();
	}
	
}