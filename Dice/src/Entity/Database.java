package Entity;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Vector;
import java.util.Iterator;

public class Database {

	private BufferedReader bufferedReader;
	private FileReader fileReader;
	
	private Vector<PlayerScore> gameData;
	private static final String FILE_NAME = "database.txt";
	
	public Database(){
		
		gameData = new Vector();
		
	}
	
	public void loadData(){
		
		try {
			BufferedReader fileRead = new BufferedReader(new FileReader(FILE_NAME));
		} catch (FileNotFoundException e) {
			
		}
	
	}
	
	// It is better to dump all data to a file
	// because we don't know which line has been changed.
	public void saveData(){
		
		PlayerScore target = null;
		Iterator<PlayerScore> iterator =  gameData.iterator();
		
		while(iterator.hasNext()){
			

		}
		
	}
	
	// TODO: Use BubbleSort to sort players by difference of wins and losses
	public void sortByDifference(){
				
		
	}
	
	public void incrementWinByName(String username){
		
		PlayerScore target = getPlayerScoreByName(username);
		
		if(target == null){
			target = new PlayerScore(username, 0, 0);
		} 
		
		target.incrementWins();		
				
	}
	
	public void incrementLossByName(String username){
		
		PlayerScore target = getPlayerScoreByName(username);
		
		if(target == null){
			target = new PlayerScore(username, 0, 0);
		} 
		
		target.incrementLosses();
		
	}
	
	private PlayerScore getPlayerScoreByName(String username){
		
		PlayerScore target = null;
		Iterator<PlayerScore> iterator =  gameData.iterator();
		
		while(iterator.hasNext()){
			PlayerScore player = iterator.next();
			if(username.equals(player.getUsername())){
				 target = player;
			}
		}
		
		return target;
		
	}
	
}
