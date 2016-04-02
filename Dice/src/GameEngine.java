import Control.GameController;

public class GameEngine {
	
	public static void main(String[] args) {
	
		GameController gameController = new GameController();
		
		// Start by displaying menu first
		gameController.setState(GameController.MENU_STATE);
		
		
	}

}
