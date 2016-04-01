
public class GameController {
	
	private GameState[] stateList;
	private int stateLength;
	private int currentState;
	
	public GameController(){
		
		stateLength = 3;
		stateList = new GameState[stateLength];
		stateList[0] = new MenuState();
		
		currentState = 0;
			
	}
	
	public GameState getState(int stateNum){
		
		return stateList[stateNum];
		
	}
	
	public void setState(int stateNum){
		
		currentState = stateNum;
		
	}
	
	public void printCurrentState(){
		
		stateList[currentState].print();
		
	}
	
	public void run(){
		
		setState(0);
		printCurrentState();
		
	}
}
