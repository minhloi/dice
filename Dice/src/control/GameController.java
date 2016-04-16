package control;

import java.util.Scanner;

import entity.Database;

/**
 * The GameController class controlls all states of the game,
 * including loading data after opening and saving data before exiting.
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
	
	private int currentState;
	
	/**
	 * The GameController constructor initializes all game states.
	 */
	public GameController() {
		
		scanner = new Scanner(System.in);
		database = new Database();
		
		stateList = new State[State.LENGTH];
		stateList[State.MENU_STATE] = new MenuState(this, scanner);
		stateList[State.PLAY_STATE] = new PlayState(this, scanner, database);
		stateList[State.VIEW_RANK_STATE] = new ViewRankState(this, scanner, database);
		stateList[State.MATCH_END_MENU_STATE] = new MatchEndMenuState(this, scanner);
		
		// Default is Menu
		currentState = State.MENU_STATE;
			
	}
	
	/**
	 * Initializes all game data when the game first opened.
	 */
	public void init() {
		
		// Load all players' data.
		database.loadData();
		
	}
	
	/**
	 * Get a specific state object.
	 * 
	 * @param state	- the index of the desired state
	 * @return the state object
	 * @throws Exception 
	 */
	public State getState(int state) throws Exception {
		
		if(state < 0 || state >= State.LENGTH || stateList[state] == null){
			throw new Exception("State does not exists.");
		} 
		
		return stateList[state];
				
	}
	
	/**
	 * Set the game to a specific state.
	 *  
	 * @param state	- the index of the desired state
	 */
	public void setState(int state) throws Exception {
		
		if(state < 0 || state >= State.LENGTH || stateList[state] == null){
			throw new Exception("State does not exists.");
		} else { 
			currentState = state;
		}
	}
	
	/**
	 * Perform some necessary action before exiting games.
	 */
	public void exitGame() {
		
		database.saveData();
		scanner.close();
		
		System.out.print("Exit!");
		
	}
	
	/**
	 * Render the current state of the game.
	 */
	public void renderCurrentState() {
		
		stateList[currentState].print();
		
	}
		
}
