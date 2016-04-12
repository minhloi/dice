package control;

import java.util.Scanner;

/**
 * MatchEnd class with all method to act when the match of the game ended
 * 
 * @author Team 38
 * 				Thien Duc Phung
 * 				Minh Loi
 * 				Daniel Enriquez
 * 				Brett Bauman
 * 				Tanner Siffren
 * @version 04/12/2016
 *
 */

public class MatchEndMenuState extends State {

	private String[] menuList; 
	private int menuLength;
	private GameController gameController;
	
	private static final int REMATCH = 0;
	private static final int BACK_TO_MAIN_MENU = 1;
	private static final int VIEW_RANK = 2;
	private static final int EXIT = 3;
	
	/**
	 * Method with assigned array at end game
	 * 
	 * @param controller
	 * @param scanner
	 */
	public MatchEndMenuState(GameController controller, Scanner scanner) {
		
		menuLength = 4;
		menuList = new String[menuLength];
		menuList[REMATCH] = "Rematch";
		menuList[BACK_TO_MAIN_MENU] = "Back to main menu.";
		menuList[VIEW_RANK] = "View ranking";
		menuList[EXIT] = "Exit";
				
		this.gameController = controller;
		this.scanner = scanner;
		
	}
	
	/**
	 * Method to print the menu
	 */
	@Override
	public void print() {
		
		// Print all menu options.
		System.out.print("Menu options: \n");
		for(int i = 0; i < menuLength; i++) {
			System.out.print(i + ". " + menuList[i]+ "\n");
		}
						
		System.out.print("Please select menu: ");
				
		// Read input
		int selectedOption = scanner.nextInt();
				
		System.out.print("\n");
				
		// Route to corrected state.
		route(selectedOption);
				
	}
	
	/**
	 * Method to decide what to do after the game base on players' choice
	 * 
	 * @param selectedOption
	 */
	public void route(int selectedOption) {
	
		if (selectedOption == REMATCH) {
			
			// Get playState object
			PlayState playState = (PlayState) gameController.getState(GameController.PLAY_STATE);
			
			// Rematch.
			playState.rematch();
			
			// Begin to render playState.
			gameController.setState(GameController.PLAY_STATE);
								
		}
		
		else if (selectedOption == BACK_TO_MAIN_MENU) {
			
			// Begin to render menuState.
			gameController.setState(GameController.MENU_STATE);
		
		}
		
		else if (selectedOption == VIEW_RANK) {
			
			// Begin to render viewRankState
			gameController.setState(GameController.VIEW_RANK_STATE);
			
		} 
		
		else if (selectedOption == EXIT) {
			
			gameController.exitGame();	

		}
		
	}
	
}
