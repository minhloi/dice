package control;

import java.util.Scanner;

/**
 * MatchEnd class with all method to act when the match of the game ended
 * 
 * @author Thien Duc Phung
 * @author Minh Loi
 * @author Daniel Enriquez
 * @author Brett Bauman
 * @author Tanner Siffren
 */

public class MatchEndMenuState extends State {

	private String[] menuList; 
	private int menuLength;
	private GameController gameController;
	
	public static final int REMATCH = 0;
	public static final int BACK_TO_MAIN_MENU = 1;
	public static final int VIEW_RANK = 2;
	public static final int EXIT = 3;
	
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
				
		// Route to the correct state.
		route(selectedOption);
				
	}
	
	/**
	 * Method to decide what to do after the game base on players' choice
	 * 
	 * @param selectedOption
	 */
	private void route(int selectedOption) {
	
		switch (selectedOption){
		
			case REMATCH:
			
				// Get playState object
				PlayState playState = (PlayState) gameController.getState(GameController.PLAY_STATE);
				
				// Rematch.
				playState.rematch();
				
				// Begin to render menuState.
				gameController.setState(GameController.PLAY_STATE);
				break;
		
			case BACK_TO_MAIN_MENU:
			
				// Begin to render menuState.
				gameController.setState(GameController.MENU_STATE);
				break;	
		
			case VIEW_RANK:
			
				// Begin to render viewRankState
				gameController.setState(GameController.VIEW_RANK_STATE);
				break;
		
			case EXIT:
				
				gameController.exitGame();	
				break;
			
			default:
				System.out.println("Invalid input. Please try again.");
				print();
		}
		
	}
	
}
