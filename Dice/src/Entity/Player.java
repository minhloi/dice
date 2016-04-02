package Entity;

public class Player {

	private int playerNumber;
	private String username;	
	private int health;
	private Dice dice;
	
	private int currentMove;
	
	private static final int DEFAULT_HEALTH_POINT = 30;
	
	// Player-move definition
	public static final int NOT_SELECT = -1;
	public static final int ATTACK = 0;
	public static final int BLOCK = 1;
	public static final int SPECIAL_ATTACK = 2;
	
	public Player(int number){
		health = DEFAULT_HEALTH_POINT; 
		currentMove = NOT_SELECT;
		playerNumber = number;
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
		else if(currentMove == NOT_SELECT)
			return "NOT_SELECTED";	
		else
			return "";
	}
	
	public void setMove(int move){
		currentMove = move;
	}
	
	public void resetMove(){
		currentMove = NOT_SELECT;
	}
	
	
}
