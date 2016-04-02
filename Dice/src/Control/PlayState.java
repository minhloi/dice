package Control;

public class PlayState extends GameState{

	private GameController gameController;	
	
	public PlayState(GameController controller){
		
		gameController = controller;
		
		
	}
	
	public void print(){
		
		System.out.println("Starting new game...");
		
	};
	
	
	
	
}
