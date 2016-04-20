package control;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Scanner;

import boundary.Background;
import boundary.GameObject;

public class MenuState extends State{

	private String[] menuList; 
	private int menuLength;
	private GameController gameController;
	private ArrayList<GameObject> objectList;
	private Background background;
	
	public static final int START_GAME = 0;
	public static final int VIEW_RANK = 1;
	public static final int EXIT = 2;
	
	public MenuState(GameController controller, ArrayList<GameObject> objectList){
		
		menuLength = 3;
		menuList = new String[menuLength];
		menuList[START_GAME] = "Start game";
		menuList[VIEW_RANK] = "View ranking";
		menuList[EXIT] = "Exit";
		
		this.objectList = objectList;
		this.gameController = controller;
		this.background = new Background("menu_background.png");
		
	}
	
	public void print(){
		
		objectList.add(background);
		
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
								
				break;
		
			case VIEW_RANK:
			
				// Begin to render viewRankState
				gameController.setState(GameController.VIEW_RANK_STATE);
				
				break;
		
			case EXIT:
			
				gameController.exitGame();
				
				break;
			
			default:
				
				System.out.println("Invalid input. Please try again.");
				print();
				
		}
		
	}

	@Override
	public void onKeyPressed(KeyEvent keyEvent) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onKeyReleased(KeyEvent keyEvent) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onKeyTyped(KeyEvent keyEvent) {
		// TODO Auto-generated method stub
		
	}
	
	
}
