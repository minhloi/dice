package control;

import java.util.ArrayList;

import boundary.GameObject;
import entity.Database;

/**
 * GameController class - controls all states of the game, including loading data 
 * 						  after opening and saving data before exiting.
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
	
	private int currentState;
	
	/**
	 * GameController constructor - Initializes all game states.
	 */
	public GameController(ArrayList<GameObject> objectList) {
		
		database = new Database();
				
		stateList = new State[State.LENGTH];
		stateList[State.MENU_STATE] = new MainMenuState(this, objectList);
		stateList[State.PLAY_STATE] = new PlayState(this, objectList, database);
		stateList[State.VIEW_RANK_STATE] = new ViewRankState(this, objectList, database);
		stateList[State.PAUSED_STATE] = new PausedState(this, objectList);

		// Default is Menu
		currentState = State.MENU_STATE;
			
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
	 * setState - Set the game to a specific state.
	 *  
	 * @param state	- the index of the desired state
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
		
		database.saveData();
		
		System.exit(0);
	}
	
	/**
	 * renderCurrentState - Render the current state of the game.
	 */
	public void renderCurrentState() {
		
		stateList[currentState].render();
	}
	
}