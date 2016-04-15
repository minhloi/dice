package control;
import java.util.Scanner;

public class MenuState extends State{

	private String[] menuList; 
	private int menuLength;
	private GameController gameController;
	
	public static final int START_GAME = 0;
	public static final int VIEW_RANK = 1;
	public static final int EXIT = 2;
	
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
		
		// Route to the correct state.
		route(selectedOption);
			
	}
	
	private void route(int selectedOption){
		
		switch (selectedOption) {
		
			case START_GAME:
			
				// Get playState object
				PlayState playState = (PlayState) gameController.getState(GameController.PLAY_STATE);
				
				// To start a new game, create a new Match object.
				playState.startNew();
				
				// Begin to render playState.
				gameController.setState(GameController.PLAY_STATE);
				gameController.renderCurrentState();
								
				break;
		
			case VIEW_RANK:
			
				// Begin to render viewRankState
				gameController.setState(GameController.VIEW_RANK_STATE);
				gameController.renderCurrentState();
				
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
