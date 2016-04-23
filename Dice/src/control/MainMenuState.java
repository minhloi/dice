package control;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Scanner;

import boundary.Background;
import boundary.GameCanvas;
import boundary.GameObject;
import boundary.SelectableMenu;

public class MainMenuState extends State{

	private GameController gameController;
	private ArrayList<GameObject> objectList;
	private Background background;
	private SelectableMenu menu;
	private String[] menuItems;
	private int menuLength;
	private int selectedOption;
	
	private static final int START_NEW_GAME = 0;
	private static final int VIEW_RANK = 1;
	private static final int EXIT = 2;
	
	private static final int MENU_HEIGHT = 300;
	private static final int MENU_WIDTH = 300;
	private static final int MENU_POSITION_X = (GameCanvas.WIDTH - MENU_WIDTH) / 2 ;
	private static final int MENU_POSITION_Y = (GameCanvas.HEIGHT - MENU_HEIGHT) - 70;
	
	public MainMenuState(GameController controller, ArrayList<GameObject> objectList){
		
		this.objectList = objectList;
		this.gameController = controller;
		this.background = new Background("main_background.png");
		
		this.menuLength = 3;
		this.menuItems = new String[3];
		menuItems[START_NEW_GAME] = "Start new game";
		menuItems[VIEW_RANK] = "View rankings";
		menuItems[EXIT] = "Quit";
		
		this.selectedOption = START_NEW_GAME;
	}
	
	public void print(){
		
		objectList.add(background);
		
		menu = new SelectableMenu(MENU_WIDTH, MENU_HEIGHT, MENU_POSITION_X, MENU_POSITION_Y);
		menu.setSelectedIndex(selectedOption);
		menu.drawMenu(menuItems);
		
		objectList.add(menu);
	}
	
	private void route(){
		
		switch (selectedOption) {
		
			case START_NEW_GAME:
			
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
			
		}
		
	}
	
	private void selectNextOption(){
		if(selectedOption >= menuLength - 1){
			selectedOption = 0;
		} else {
			selectedOption++;
		}
	}
	
	private void selectPrevOption(){
		if(selectedOption <= 0){
			selectedOption = menuLength - 1;
		} else {
			selectedOption--;
		}
	}

	@Override
	public void onKeyPressed(KeyEvent keyEvent) {
	}

	@Override
	public void onKeyReleased(KeyEvent keyEvent) {
		int keycode = keyEvent.getKeyCode();
		switch(keycode){
			case KeyEvent.VK_DOWN:
				selectNextOption();
				break;
			case KeyEvent.VK_UP:
				selectPrevOption();
				break;
			case KeyEvent.VK_ENTER:
				route();
				break;
		}
	}

	@Override
	public void onKeyTyped(KeyEvent keyEvent) {
		// TODO Auto-generated method stub
		
	}
		
}
