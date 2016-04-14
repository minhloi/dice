package main;
import control.GameController;

/**
 * The GameEngine class is simply a starter of the game.
 * 
 * @author Thien Duc Phung
 * @author Minh Loi
 * @author Daniel Enriquez
 * @author Brett Bauman
 * @author Tanner Siffren
 */

public class GameEngine {
	
	public static void main(String[] args) {
	
		GameController gameController = new GameController();
		
		// Load necessary data such as players' scores.
		gameController.init();
		
		// Start by printing the menu first
		gameController.setState(GameController.MENU_STATE);
		
	}

}
