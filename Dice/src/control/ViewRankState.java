package control;

import java.util.Iterator;
import java.util.Scanner;
import java.util.Vector;

import entity.Database;
import entity.PlayerScore;

public class ViewRankState extends State{
	
	private GameController gameController;
	private Database database;
	
	private String[] menuList; 
	private int menuLength;
	
	private static final int BACK_TO_MAIN_MENU = 0;
	private static final int EXIT = 1;
	
	public ViewRankState(GameController controller, Scanner scanner, Database database){
		
		this.gameController = controller;
		this.scanner = scanner;
		this.database = database;
		
		menuLength = 2;
		menuList = new String[menuLength];
		menuList[BACK_TO_MAIN_MENU] = "Back to main menu";
		menuList[EXIT] = "Exit";
		
	}
		
	public void print(){

		// Sort data by difference of wins and losses.
		database.sortByDifference();
		Vector<PlayerScore> data = database.getData();
		
		int size = data.size();
		
		if(size > 0){
		
			Iterator<PlayerScore> iterator =  data.iterator();
			System.out.println("Viewing ranks of players in order of DIFF.");
			
			System.out.printf("%-25s%-10s%-10s%-10s\n", "Username", "Wins", "Losses", "DIFF");
			System.out.println("-----------------------------------------------------------------------------");
			
			while(iterator.hasNext()){
				PlayerScore player = iterator.next();
				int numOfWins = player.getNumOfWins();
				int numOfLosses = player.getNumOfLosses();
				int diff = numOfWins - numOfLosses;
				System.out.printf("%-25s%-10s%-10s%-10s\n", player.getUsername(), numOfWins, numOfLosses, diff);
				
			}
			
		} else {
			System.out.println("No records in database.");
		}
				
		System.out.println();
		printMenu();
	
	}
	
	// Print all menu options.
	private void printMenu(){
	
		System.out.print("Menu options: \n");
		for(int i = 0; i < menuLength; i++){
			System.out.print(i + ". " + menuList[i]+ "\n");
		}
				
		System.out.print("Please select menu: ");
		
		// Read input
		int selectedOption = scanner.nextInt();
		
		System.out.print("\n");
		
		// Route to corrected state.
		route(selectedOption);
			
	}
	
	private void route(int selectedOption){
		
		switch (selectedOption){
			case BACK_TO_MAIN_MENU:
				// Begin to render menuState.
				gameController.setState(GameController.MENU_STATE);
				break;					
				
			case EXIT:
				gameController.exitGame();
				break;
				
			default:
				System.out.println("Invalid Input. Please try again.");
				break;
		}
	}
}