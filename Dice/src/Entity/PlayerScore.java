package Entity;

public class PlayerScore {
	private String playerName;
	private int numOfWinning;
	
	public PlayerScore(String username, int winning ){
		playerName = username;
		this.numOfWinning = winning;
	}
	
	public String getUsername(){
		return playerName;
	}
	
	public int getNumOfWinning(){
		return numOfWinning;		
	}
			
}
