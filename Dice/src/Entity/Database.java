package Entity;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Vector;

public class Database {

	private BufferedReader bufferedReader;
	private FileReader fileReader;
	private Vector<PlayerScore> data;
	private static final String FILE_NAME = "game.txt";
	
	public Database(){
		
		data = new Vector();
		
	}
	
	public void loadData(){
		
		try {
		
			BufferedReader fileIn = new BufferedReader(new FileReader(FILE_NAME));
		
		} catch (FileNotFoundException e) {
			
			
			
		}
	
	}
	
	public void saveData(){
			
	
	}
	
	public void get(){
		
		
	
	}
	
}
