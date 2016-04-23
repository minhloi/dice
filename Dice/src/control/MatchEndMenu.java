package control;

import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Scanner;

import boundary.GameObject;
import boundary.SelectableMenu;

/**
 * MatchEnd class with all method to act when the match of the game ended
 * 
 * @author Thien Duc Phung
 * @author Minh Loi
 * @author Daniel Enriquez
 * @author Brett Bauman
 * @author Tanner Siffren
 */

public class MatchEndMenu implements Listenable {
	
	private GameController gameController;
	private String[] menuItems; 
	private int menuLength;
	private ArrayList<GameObject> objectList;
	private SelectableMenu menu;
	private int selectedOption;
	
	public static final int REMATCH = 0;
	public static final int BACK_TO_MAIN_MENU = 1;
	public static final int VIEW_RANK = 2;
	public static final int EXIT = 3;
	
	private static final int MENU_WIDTH = 468;
	private static final int MENU_HEIGHT = 346;
	
	/**
	 * Method with assigned array at end game
	 * 
	 * @param controller
	 * @param scanner
	 */
	public MatchEndMenu(GameController controller, ArrayList<GameObject> objectList) {
		
		menuLength = 4;
		menuItems = new String[menuLength];
		menuItems[REMATCH] = "Rematch";
		menuItems[BACK_TO_MAIN_MENU] = "Back to main menu.";
		menuItems[VIEW_RANK] = "View rankings";
		menuItems[EXIT] = "Quit";
				
		this.gameController = controller;
		this.objectList = objectList;
		this.selectedOption = -1;
	}
	
	public void render() {
		
		menu = new SelectableMenu(MENU_WIDTH, MENU_HEIGHT, Match.PANEL_POSITION_X, Match.PANEL_POSITION_Y);
		menu.drawMenu(menuItems);
		
		objectList.add(menu);
		
	}
	
	/**
	 * Method to decide what to do after the game base on players' choice
	 * 
	 * @param selectedOption
	 */
	private void route() {
	
		switch (selectedOption){
		
			case REMATCH:
			
				// Get playState object
				PlayState playState = (PlayState) gameController.getState(GameController.PLAY_STATE);
				
				// Rematch.
				playState.rematch();
				
				// Begin to render menuState.
				gameController.setState(GameController.PLAY_STATE);
				break;
		
			case BACK_TO_MAIN_MENU:
			
				// Begin to render menuState.
				gameController.setState(GameController.MENU_STATE);
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


	}
	
	
	
}
