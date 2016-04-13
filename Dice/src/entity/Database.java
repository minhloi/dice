package entity;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Vector;
import java.util.Iterator;

public class Database {

	private FileOutputStream fileOutput;
	private ObjectOutputStream outStream;
    
	private FileInputStream fileInput;
	private ObjectInputStream inStream;
    
	private Vector<PlayerScore> gameData;
	private static final String FILE_NAME = "database.txt";
	
	public Database(){
		gameData = new Vector<PlayerScore>();
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
		
			gameData = new Vector<PlayerScore>();
				
		} catch (ClassNotFoundException e) {
		
			e.printStackTrace();
			
		} catch (IOException e) {
		
			e.printStackTrace();
		
		} finally {
			
			try {
				if(inStream != null){
					inStream.close();
				}	
			} catch (IOException e) {
				e.printStackTrace();
			}
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
			e1.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}  finally {
			
			try {
				if(outStream != null){
					outStream.close();
				}	
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		
	}
	
	// TODO: Use BubbleSort to sort players by difference of wins and losses
	public void sortByDifference(){
		
		int size = gameData.size();
		PlayerScore currentPlayer, nextPlayer;
		
		for(int index = 0; index < size - 1; index++){
			for(int current = 0; current < size - index - 1; current++ ){
				
				currentPlayer = gameData.get(current);
				nextPlayer = gameData.get(current + 1);
				
				if(currentPlayer.getDifference() < nextPlayer.getDifference()){
					swapPlayers(current, current + 1);
				
				// Difference of two players are equal, then compare the number of wins.
				} else if(currentPlayer.getDifference() == nextPlayer.getDifference()){
					if(currentPlayer.getNumOfWins() < nextPlayer.getNumOfWins()){
						swapPlayers(current, current + 1);
					}
				}
			}
		}
		
	}
	
	public Vector<PlayerScore> getData(){
		return gameData;
	}
	
	public void incrementWinByName(String username){
		
		PlayerScore target = getPlayerScoreByName(username);
		
		if(target == null){
			target = createNewPlayer(username);
		} 
		
		target.incrementWins();		
				
	}
	
	public void incrementLossByName(String username){
		
		PlayerScore target = getPlayerScoreByName(username);
		
		if(target == null){
			target = createNewPlayer(username);
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
	
	private PlayerScore createNewPlayer(String username){
		PlayerScore newPlayer = new PlayerScore(username, 0, 0);
		gameData.add(newPlayer);
		
		return newPlayer;
	}
	
	private void swapPlayers(int index1, int index2){
		
		PlayerScore player1 = gameData.get(index1);
		PlayerScore player2 = gameData.get(index2);
			
		gameData.set(index1, player2);
		gameData.set(index2, player1);
		
	}
	
}