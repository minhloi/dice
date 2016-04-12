import Control.GameController;

public class GameEngine {
	
	public static void main(String[] args) {
	
		GameController gameController = new GameController();
		
		gameController.init();
		
		// Start by printing the menu first
		gameController.setState(GameController.MENU_STATE);
		
		
	}

}
