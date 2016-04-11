package Control;

import java.util.Scanner;

public class GameController {
	
	private State[] stateList;
	private int stateLength;
	private int currentState;
	
	public static final int MENU_STATE = 0;
	public static final int PLAY_STATE = 1;
	public static final int VIEW_RANK_STATE = 2;
	public static final int MATCH_END_MENU_STATE = 3; // Menu displayed when a match ended
	
	public GameController(){
		
		Scanner scanner = new Scanner(System.in);
		
		stateLength = 4;
		stateList = new State[stateLength];
		stateList[MENU_STATE] = new MenuState(this, scanner);
		stateList[PLAY_STATE] = new PlayState(this, scanner);
		stateList[VIEW_RANK_STATE] = new ViewRankState(this, scanner);
		stateList[MATCH_END_MENU_STATE] = new MatchEndMenuState(this, scanner);
		
		// Default is Menu
		currentState = MENU_STATE;
			
	}
	
	public State getState(int state){
		return stateList[state];
	}
	
	public void setState(int state){
		
		currentState = state;
		printCurrentState();
		
	}
		
	private void printCurrentState(){
		stateList[currentState].print();
	}
		
}
