package entity;

public class Player {

	private int playerNumber;
	private String username;	
	private int health;
	private Dice dice;
	private TurnInfo turnInfo;
	
	// Number of times SPECIAL_ATTACK used.
	private int numSpecialUsed;
	
	// Some default configurations.
	public static final int DEFAULT_HEALTH_POINT = 1;
	public static final int MAX_SPECIAL_ALLOWED = 2;
	
	// Player-move definition
	public static final int NOT_SELECT = -1;
	public static final int ATTACK = 0;
	public static final int BLOCK = 1;
	public static final int SPECIAL_ATTACK = 2;
	
	public Player(int number, String username){
		
		// Initialize variables
		this.playerNumber = number;
		this.username = username;
		this.health = DEFAULT_HEALTH_POINT; 
		numSpecialUsed = 0;
		dice = new Dice();
		turnInfo = new TurnInfo();
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
	
	public TurnInfo getTurnInfo(){
		return turnInfo;
	}
	
	public boolean canUseSpecial(){
		if(numSpecialUsed >= MAX_SPECIAL_ALLOWED){
			return false;
		} else
			return true;	
	}

	public void incrementSpecialUsed(){
		++numSpecialUsed;
	}
	
	public void resetTurnInfo(){
		
		int previousMove = turnInfo.getMove();

		turnInfo = new TurnInfo();
		
		switch(previousMove){
			case Player.BLOCK:
				turnInfo.disableBlock();
				break;
				
			case Player.SPECIAL_ATTACK:
				incrementSpecialUsed();
				break;
			
			default:
				turnInfo.enableBlock();
		}
		
	}
			
}
