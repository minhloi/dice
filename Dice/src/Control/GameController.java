package Control;

import java.util.Scanner;

import Entity.Database;

public class GameController {
	
	private State[] stateList;
	private Scanner scanner;
	private Database database;
	
	private int stateLength;
	private int currentState;
		
	public static final int MENU_STATE = 0;
	public static final int PLAY_STATE = 1;
	public static final int VIEW_RANK_STATE = 2;
	public static final int MATCH_END_MENU_STATE = 3; // Menu displayed when a match ended
	
	public GameController(){
		
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
	
	public void init(){
		
		// Load all players' data.
		database.loadData();
		
	}
	
	public State getState(int state){
		return stateList[state];
	}
	
	public void setState(int state){
		
		currentState = state;
		printCurrentState();
		
	}
	
	public void exitGame(){
		
		// Before exit
		database.saveData();
		scanner.close();
		
		System.out.print("Exit! ");
		
	}
	
	private void printCurrentState(){
		stateList[currentState].print();
	}
		
}
