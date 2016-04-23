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
	
	// Number of times SPECIAL_ATTACK used.
	private int numSpecialUsed;
	private boolean blockDisabled;
	
	private int currentMove;
	
	// Some default configurations.
	public static final int DEFAULT_HEALTH_POINT = 10;
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
	public Player(int number, String username){
		
		// Initialize variables
		playerNumber = number;
		this.username = username;
		health = DEFAULT_HEALTH_POINT; 
		currentMove = NOT_SELECT;
		numSpecialUsed = 0;
		blockDisabled = false;
		dice = new Dice();
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
	
	/**
	 * isBlockDisabled - Get the boolean value that determines whether block is disabled
	 * 
	 * @return Returns the boolean value of blockDisabled
	 */
	public boolean isBlockDisabled(){
		
		return blockDisabled;
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
	 * getMove - Get the current move
	 * 
	 * @return Returns the current move
	 */
	public int getMove(){
		
		return currentMove;
	}
	
	/**
	 * getMoveInString - Return the type of move used  
	 * 
	 * @return Returns the type of move
	 */
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
	
	/**
	 * setMove - Set the move and check for disable block and special attack capability
	 * 
	 * @param move Player's move choice
	 */
	public void setMove(int move){
		
		// Assume that setMove is called only once in a turn,
		// meaning once player selected a move, he cannot change.
		currentMove = move;
		if(currentMove == BLOCK){
			disableBlock();
		} else if(currentMove == SPECIAL_ATTACK){
			incrementSpecialUsed();
		}
	}
	
	/**
	 * resetMove - Reset the move of the player
	 */
	public void resetMove(){
		
		// If player does not select BLOCK this turn,
		// then enable it back for next turn.
		if(currentMove != BLOCK){
			enableBlock();
		}
		
		currentMove = NOT_SELECT;
		
	}
	
	/**
	 * disableBlock - Set blockDisabled to true
	 */
	private void disableBlock(){
		
		blockDisabled = true;
	}
	
	/**
	 * enableBlock - Set blockDisabled to false
	 */
	private void enableBlock(){
		
		blockDisabled = false;
	}
	
	/**
	 * incrementSpecialUsed - Increment the number of special attacks used
	 */
	private void incrementSpecialUsed(){
		
		++numSpecialUsed;
	}
		
}
