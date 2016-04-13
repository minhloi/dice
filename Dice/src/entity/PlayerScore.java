package entity;

import java.io.Serializable;

public class PlayerScore implements Serializable {
	
	private String playerName;
	private int numOfWins;
	private int numOfLosses;
	
	public PlayerScore(String username){
		playerName = username;
		this.numOfWins = 0;
		this.numOfLosses = 0;
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
