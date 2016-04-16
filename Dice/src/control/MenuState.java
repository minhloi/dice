package control;

import java.util.Scanner;

/**
 * The MenuState class - Where players' select between play the game, 
 * 			   		 view rank, or exit
 * 
 * @author Thien Duc Phung
 * @author Minh Loi
 * @author Daniel Enriquez
 * @author Brett Bauman
 * @author Tanner Siffren
 */

public class MenuState extends State{

	private String[] menuList; 
	private int menuLength;
	private GameController gameController;
	
	public static final int START_GAME = 0;
	public static final int VIEW_RANK = 1;
	public static final int EXIT = 2;
	
	/**
	 *  Constructor - Initializes menu item.
	 *  
	 * @param controller - gameController object
	 * @param scanner - scanner object
	 */
	public MenuState(GameController controller, Scanner scanner){
		
		menuLength = 3;
		menuList = new String[menuLength];
		menuList[START_GAME] = "Start game";
		menuList[VIEW_RANK] = "View ranking";
		menuList[EXIT] = "Exit";
		
		this.scanner = scanner;
		this.gameController = controller;
		
	}
	
	/**
	 * print - Display the menu, collect user's menu choice, and route user to 
	 * 		   that option
	 */
	public void print(){
		
		// Print all menu options.
		System.out.print("Menu options: \n");
		for(int i = 0; i < menuLength; i++){
			System.out.print(i + ". " + menuList[i]+ "\n");
		}
				
		System.out.print("Please select menu: ");
		
		// Read input
		try {
			int selectedOption = Integer.parseInt(scanner.next());
			System.out.print("\n");
			
			// Route to the correct state.
			route(selectedOption);
			
		} catch (NumberFormatException e) {
			System.out.print("\n");
			System.out.println("Invalid input. Please try again.");
		    print();
		}
					
	}
	
	/**
	 * route - Depending on the user's choice, route to a correct game state. 
	 * 
	 * @param selectedOption - The menu option the user has chosen.
	 */
	private void route(int selectedOption){
		
		switch (selectedOption) {
		
			case START_GAME:
				// Get playState object
				try {
					PlayState playState;
					playState = (PlayState) gameController.getState(State.PLAY_STATE);
					// To start a new game, create a new Match object.
					playState.startNew();
					
					// Begin to render playState.
					gameController.setState(State.PLAY_STATE);
					gameController.renderCurrentState();
				} catch (Exception e) {
					e.printStackTrace();
				}
				break;
		
			case VIEW_RANK:
				// Begin to render viewRankState
				try {
					gameController.setState(State.VIEW_RANK_STATE);
					gameController.renderCurrentState();
				} catch (Exception e) {
					e.printStackTrace();
				}
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
