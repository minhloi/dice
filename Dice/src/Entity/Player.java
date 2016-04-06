package Entity;

public class Player {

	private int playerNumber;
	private String username;	
	private int health;
	private Dice dice;
	// Number of times SPECIAL_ATTACK used.
	private int numSpecialUsed;
	private boolean blockDisabled;
	
	private int currentMove;
	
	// Some default configurations.
	private static final int DEFAULT_HEALTH_POINT = 30;
	private static final int MAX_SPECIAL_ALLOWED = 2;
	
	// Player-move definition
	public static final int NOT_SELECT = -1;
	public static final int ATTACK = 0;
	public static final int BLOCK = 1;
	public static final int SPECIAL_ATTACK = 2;
	
	public Player(int number){
		
		// Initialized variables
		health = DEFAULT_HEALTH_POINT; 
		currentMove = NOT_SELECT;
		playerNumber = number;
		numSpecialUsed = 0;
		blockDisabled = false;
		dice = new Dice();
	}
	
	public int getHealth(){
		return health;
	}
	
	public int setHealth(int health){
		this.health = health;
		return this.health;
	}
	
	public String getUserName(){
		return username;
	}
	
	public int getNumber(){
		return playerNumber;
	}
	
	public Dice getDice(){
		return dice;
	}
	
	public boolean isBlockDisabled(){
		return blockDisabled;
	}
	
	public boolean canUseSpecial(){
		if(numSpecialUsed >= MAX_SPECIAL_ALLOWED){
			return false;
		} else
			return true;	
	}
		
	public int getMove(){
		return currentMove;
	}
	
	public String getMoveInString(){
		if(currentMove == ATTACK)
			return "ATTACK";
		else if(currentMove == BLOCK)
			return "BLOCK";
		else if(currentMove == SPECIAL_ATTACK)
			return "SPECIAL_ATTACK";
		else 
			return "NOT_SELECTED";	
	}
	
	// Assume that setMove is called only once in a turn,
	// meaning once player selected a move, he cannot change.
	public void setMove(int move){
		currentMove = move;
		if(currentMove == BLOCK){
			disableBlock();
		} else if(currentMove == SPECIAL_ATTACK){
			incrementSpecialUsed();
		}
	}
	
	public void resetMove(){
		
		// If Player does not select BLOCK this turn,
		// then enable it back for next turn.
		if(currentMove != BLOCK){
			enableBlock();
		}
		
		currentMove = NOT_SELECT;
		
	}
	
	private void disableBlock(){
		blockDisabled = true;
	}
	
	private void enableBlock(){
		blockDisabled = false;
	}
	
	private void incrementSpecialUsed(){
		++numSpecialUsed;
	}
		
}
