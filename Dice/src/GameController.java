
public class GameController {
	
	private GameState[] stateList;
	private int stateLength;
	private int currentState;
	public static int MENU_STATE = 0;
	public static int PLAY_STATE = 1;
	public static int VIEW_RANK_STATE = 2;
	
	public GameController(){
		
		stateLength = 3;
		stateList = new GameState[stateLength];
		stateList[MENU_STATE] = new MenuState(this);
		stateList[PLAY_STATE] = new PlayState(this);
		
		currentState = 0;
			
	}
	
	public GameState getState(int stateNum){
		
		return stateList[stateNum];
		
	}
	
	public void setState(int stateNum){
		
		currentState = stateNum;
		printCurrentState();
		
	}
	
	private void printCurrentState(){
			stateList[currentState].print();
	}
	
	public void run(){
		
		setState(0);
		
	}
}
