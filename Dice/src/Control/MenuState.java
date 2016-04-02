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
		
		System.out.print("Menu options: \n");
		for(int i = 0; i < menuLength; i++){
			System.out.print(i + ". " + menuList[i]+ "\n");
		}
				
		System.out.print("Please select menu: ");
		
		int selectedOption = scanner.nextInt();
		
		System.out.print("\n");
		route(selectedOption);
			
	}
	
	private void route(int selectedOption){
		
		if(selectedOption == START_GAME){
			
			PlayState playState = (PlayState) gameController.getState(GameController.PLAY_STATE);
			playState.createNewMatch();
			
			gameController.setState(GameController.PLAY_STATE);
								
		}
		
		else if(selectedOption == VIEW_RANK){
			
			gameController.setState(GameController.VIEW_RANK_STATE);
			
		} 
		
		else if(selectedOption == EXIT){
			
			// close scanner;
			scanner.close();
			
			System.out.print("Exit! ");
			
		}
		
	}
	
	
}
