package entity;

/**
 * Player class - Player object with action and reset actions before next round.
 * 
 * @author Thien Duc Phung
 * @author Minh Loi
 * @author Daniel Enriquez
 * @author Brett Bauman
 * @author Tanner Siffren
 */
public class Player {

	private int playerNumber;
	private String username;	
	private int health;
	private Dice dice;
	private TurnInfo turnInfo;
		
	// Number of times SPECIAL_ATTACK used.
	private int numSpecialUsed;
	
	// Some default configurations.
	public static final int DEFAULT_HEALTH_POINT = 20;
	public static final int MAX_SPECIAL_ALLOWED = 2;
	
	// Player-move definition
	public static final int NOT_SELECT = -1;
	public static final int ATTACK = 0;
	public static final int BLOCK = 1;
	public static final int SPECIAL_ATTACK = 2;
	
	/**
	 * Constructor - Prepare player data
	 * 
	 * @param number Player ID number 
	 * @param username The player's username
	 */
	public Player(int number){
		
		// Initialize variables
		this.playerNumber = number;
		this.username = "";
		this.health = DEFAULT_HEALTH_POINT; 
		numSpecialUsed = 0;
		dice = new Dice();
		turnInfo = new TurnInfo();
	}
	
	/**
	 * getHealth - Get the player's health
	 * 
	 * @return Returns the player's health
	 */
	public int getHealth(){
		return health;
	}
	
	/**
	 * setHealth - Set and return the player's health 
	 * 
	 * @param health Player's health measurement
	 * @return Returns player's health
	 */
	public int setHealth(int health){
		this.health = health;
		return this.health;
	}
	
	/**
	 * Set username for the player
	 * @param username username string to be set
	 */
	public void setUsername(String username){
		this.username = username;
	}
	
	/**
	 * getUserName - Get the player's username
	 * 
	 * @return Returns the player's username
	 */
	public String getUserName(){
		return username;
	}
	
	/**
	 * getNumber - Get the Player's ID number
	 * 
	 * @return Returns the player's ID number
	 */
	public int getNumber(){
		return playerNumber;
	}
	
	/**
	 * getDice - Get the Dice object
	 * 
	 * @return Returns the Dice object
	 */
	public Dice getDice(){
		return dice;
	}
	
	public TurnInfo getTurnInfo(){
		return turnInfo;
	}
	
	/**
	 * canUseSpecial - Return whether player can use their special attack or not
	 * 
	 * @return Returns boolean value to determine if special attack can be used
	 */
	public boolean canUseSpecial(){
		if(numSpecialUsed >= MAX_SPECIAL_ALLOWED){
			return false;
		} else
			return true;	
	}

	/**
	 * Increment number of special used
	 */
	public void incrementSpecialUsed(){
		++numSpecialUsed;
		
	}
	
	/**
	 * Reset the turnInfo object
	 */
	public void resetTurnInfo(){
		
		int previous = turnInfo.getMove();
			
		turnInfo = new TurnInfo();
		if(previous == Player.BLOCK){
			turnInfo.disableBlock();
		} else if(previous == Player.SPECIAL_ATTACK){
			incrementSpecialUsed();
		}
	}
					
}
