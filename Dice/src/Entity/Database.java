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
		int diffOfCurrent, diffOfNext;
		PlayerScore currentPlayer, nextPlayer;
		
		for(int index = 0; index < size - 1; index++){
			for(int current = 0; current < size - index - 1; current++ ){
				
				currentPlayer = gameData.get(current);
				nextPlayer = gameData.get(current + 1);
				
				diffOfCurrent = currentPlayer.getNumOfWins() - currentPlayer.getNumOfLosses();
				diffOfNext = nextPlayer.getNumOfWins() - nextPlayer.getNumOfLosses();	
				
				if(diffOfCurrent < diffOfNext){
					swapPlayers(current, current + 1);
				
				// Difference of two players are equal, then compare the number of wins.
				} else if(diffOfCurrent == diffOfNext){
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
