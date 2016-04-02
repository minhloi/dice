package Entity;

public class Player {

	private int playerNumber;
	private String username;	
	private int health;
	private Dice dice;
	
	private char[] moveSet;
	private int currentMove;
	
	private static final int DEFAULT_HEALTH_POINT = 30;
	
	// Player-move definition
	public static final int NOT_SELECT = -1;
	public static final int ATTACK = 0;
	public static final int BLOCK = 1;
	public static final int SPECIAL_ATTACK = 2;
	
	public Player(int number, char[] moveSet){
		this.health = DEFAULT_HEALTH_POINT; 
		this.currentMove = -1;
		this.moveSet = moveSet;
		this.playerNumber = number;
		this.dice = new Dice();
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
	
	public void resetMove(){
		currentMove = NOT_SELECT;
	}
	
	
}
