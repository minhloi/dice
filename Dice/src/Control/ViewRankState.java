package Control;

import java.util.Scanner;

import Entity.Database;

public class ViewRankState extends State{
	
	private GameController gameController;
	private Database database;
	
	public ViewRankState(GameController controller, Scanner scanner, Database database){
		
		this.gameController = controller;
		this.scanner = scanner;
		this.database = database;
		
	}
		
	public void print(){
					
	}
	
}
