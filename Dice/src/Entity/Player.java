package Entity;

public class Player {

	private int playerNum;
	private String username;	
	private int health;
	private char[] moveSet;
	private int currentMove;
	
	private static final int DEFAULT_HEALTH_POINT = 30;
	
	// Player move definition
	public static final int NOT_SELECT = -1;
	public static final int ATTACK = 0;
	public static final int BLOCK = 1;
	public static final int SPECIAL_ATTACK = 2;
	
	public Player(int number, char[] moveSet){
		health = DEFAULT_HEALTH_POINT; 
		currentMove = -1;
		this.moveSet = moveSet;
		playerNum = number;
	}
	
	public int getHealth(){
		return health;
	}
	
	public String getUserName(){
		return username;
	}
	
	public char[] getMoveSet(){
		return moveSet;		
	}
	
	public char getMoveKey(int move){
		return moveSet[move];		
	}
	
	public int getMove(){
		return currentMove;
	}
	
	public void setMove(int move){
		currentMove = move;
	}
	
	
}
