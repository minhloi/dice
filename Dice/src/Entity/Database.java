package Entity;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Vector;
import java.util.Iterator;

public class Database {

    FileOutputStream fileOutput;
    ObjectOutputStream outStream;
    
    FileInputStream fileInput;
    ObjectInputStream inStream;
    
	private Vector<PlayerScore> gameData;
	private static final String FILE_NAME = "database.txt";
	
	public Database(){
	}
	
	@SuppressWarnings("unchecked")
	public void loadData(){
		
		try {
			
			fileInput = new FileInputStream(FILE_NAME);
			inStream = new ObjectInputStream(fileInput);
			
			Object data = inStream.readObject();
			if( data instanceof Vector<?>){
				gameData = (Vector<PlayerScore>) data;
			}
	
		} catch (FileNotFoundException e) {
		
			gameData = new Vector();
				
		} catch (ClassNotFoundException e) {
		
			e.printStackTrace();
			
		} catch (IOException e) {
		
			e.printStackTrace();
		
		}
	
	}
	
	// It is better to dump all objects to a file
	// because we don't know which objects have been changed.
	public void saveData(){
		
		try {
		
			fileOutput = new FileOutputStream(FILE_NAME, false);
			outStream = new ObjectOutputStream(fileOutput);
			
			outStream.writeObject(gameData);
						
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
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
