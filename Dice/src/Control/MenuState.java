package Control;
import java.util.Scanner;

public class MenuState extends State{

	private String[] menuList; 
	private int menuLength;
	private GameController gameController;
	
	private static final int START_GAME = 0;
	private static final int VIEW_RANK = 1;
	private static final int EXIT = 2;
	
	public MenuState(GameController controller, Scanner scanner){
		
		menuLength = 3;
		menuList = new String[menuLength];
		menuList[START_GAME] = "Start game";
		menuList[VIEW_RANK] = "View ranking";
		menuList[EXIT] = "Exit";
		
		this.scanner = scanner;
		this.gameController = controller;
		
	}
	
	public void print(){
		
		// Print all menu options.
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
		
		if(selectedOption == START_GAME){
			
			// Get playState object
			PlayState playState = (PlayState) gameController.getState(GameController.PLAY_STATE);
			
			// To start a new game, create a new Match object.
			playState.createNewMatch();
			
			// Begin to render playState.
			gameController.setState(GameController.PLAY_STATE);
								
		}
		
		else if(selectedOption == VIEW_RANK){
			
			// Begin to render viewRankState
			gameController.setState(GameController.VIEW_RANK_STATE);
			
		} 
		
		else if(selectedOption == EXIT){
			
			gameController.exitGame();
			
		}
		
	}
	
	
}
