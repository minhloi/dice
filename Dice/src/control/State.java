package control;

import java.util.Scanner;

/**
 * State class - Abstact class that contains print method and method to return scanner object   
 * 
 * @author Thien Duc Phung
 * @author Minh Loi
 * @author Daniel Enriquez
 * @author Brett Bauman
 * @author Tanner Siffren
 */

public abstract class State {

	protected Scanner scanner;

	public static final int MENU_STATE = 0;
	public static final int PLAY_STATE = 1;
	public static final int VIEW_RANK_STATE = 2;
	public static final int MATCH_END_MENU_STATE = 3; // Menu displayed when a match ended
	
	/**
	 * print
	 */
	public abstract void print();
	
	/**
	 * getScanner - Returns the scanner object
	 * 
	 * @return scanner object is returned
	 */
	public Scanner getScanner(){
		return scanner;		
	}
	
}
