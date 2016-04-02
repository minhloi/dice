package Control;
import java.util.Scanner;

public class MenuState extends GameState{

	private String[] menuList; 
	private int menuLength;
	private GameController gameController;
	
	public MenuState(GameController controller){
		
		menuLength = 3;
		menuList = new String[menuLength];
		menuList[0] = "Start game";
		menuList[1] = "View ranking";
		menuList[2] = "Exit";
		
		gameController = controller;
		
	}
	
	public void print(){
		
		System.out.print("Menu options: \n");
		for(int i = 0; i < menuLength; i++){
			
			System.out.print(i + ". " + menuList[i]+ "\n");
			
		}
		
		
		System.out.print("Please input menu: ");
		
		Scanner scanner = new Scanner(System.in);
		int selectedMenu = scanner.nextInt();
		scanner.close();
		
		System.out.print("\n");
		
		if(selectedMenu == 0){
			
			gameController.setState(GameController.PLAY_STATE);
			
			
		} else if(selectedMenu == 1){
			
			gameController.setState(GameController.VIEW_RANK_STATE);
			
		} else if(selectedMenu == 2){
			
			System.out.print("Exit the game... ");
			
		}
	    
			
	}
	
	
}
