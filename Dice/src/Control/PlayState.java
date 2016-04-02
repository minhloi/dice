package Control;

import java.util.Scanner;

public class PlayState extends State{

	private GameController gameController;	
	private Match currentMatch;
	
	public PlayState(GameController controller, Scanner scanner){
		
		this.gameController = controller;
		this.scanner = scanner;
	
	}
	
	public void createNewMatch(){
		currentMatch = new Match(scanner);
	}
			
	public void print(){
		
		System.out.println("GAME STARTED");
		System.out.println("-----------------------------------------------------");
		System.out.println();
		
		currentMatch.begin();
		
	};
	
	
	
	
}
