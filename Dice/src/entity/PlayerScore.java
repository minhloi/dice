package entity;

import java.io.Serializable;

/**
 * PlayerScore class - Use to get player's name and store data of correct player.
 * 
 * @author Thien Duc Phung
 * @author Minh Loi
 * @author Daniel Enriquez
 * @author Brett Bauman
 * @author Tanner Siffren
 */
public class PlayerScore implements Serializable {
	
	private String playerName;
	private int numOfWins;
	private int numOfLosses;
	
	/**
	 * Constructor - Set the player's username
	 * 
	 * @param username The player's username
	 */
	public PlayerScore(String username){
		playerName = username;
		this.numOfWins = 0;
		this.numOfLosses = 0;
	}
	
	/**
	 * getUsername - Get the player's username
	 * 
	 * @return Returns the player's username
	 */
	public String getUsername(){
		return playerName;
	}
	
	/**
	 * getNumOfWins - Get the number of wins
	 * 
	 * @return Returns the number of wins
	 */
	public int getNumOfWins(){
		return numOfWins;		
	}
	
	/**
	 * getNumOfLosses - Get the number of losses
	 * 
	 * @return Returns the number of losses
	 */
	public int getNumOfLosses(){
		return numOfLosses;		
	}
	
	/**
	 * getDifference - Get the difference between the number of wins and losses
	 * 
	 * @return Returns the difference between the number of wins and losses
	 */
	public int getDifference(){
		return (numOfWins - numOfLosses);
	}
	
	/**
	 * incrementWins - Increment the number of wins
	 */
	public void incrementWins(){
		numOfWins++;
	}
	
	/**
	 * incrementLosses - Increment the number of losses
	 */
	public void incrementLosses(){
		numOfLosses++;
	}
				
}
