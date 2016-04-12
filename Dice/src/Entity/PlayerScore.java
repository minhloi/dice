package Entity;

import java.io.Serializable;

public class PlayerScore implements Serializable {
	
	private String playerName;
	private int numOfWins;
	private int numOfLosses;
	
	public PlayerScore(String username, int wins, int losses ){
		playerName = username;
		this.numOfWins = wins;
		this.numOfLosses = losses;
	}
	
	public String getUsername(){
		return playerName;
	}
	
	public int getNumOfWins(){
		return numOfWins;		
	}
	
	public int getNumOfLosses(){
		return numOfLosses;		
	}
	
	public int getDifference(){
		return (numOfWins - numOfLosses);
	}
	
	public void incrementWins(){
		numOfWins++;
	}
	
	public void incrementLosses(){
		numOfLosses++;
	}
				
}
