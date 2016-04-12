package main;
import control.GameController;

/**
 * GameEngine class with initializing  GameControler
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

public class GameEngine {
	
	public static void main(String[] args) {
	
		GameController gameController = new GameController();
		
		gameController.init();
		
		// Start by printing the menu first
		gameController.setState(GameController.MENU_STATE);
		
	}

}
