package control;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

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
	private ArrayList<GameObject> objectList;
	
	private String[] menuItems; 
	private int menuLength;
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
		menuItems[BACK_TO_MAIN_MENU] = "Back to main menu";
		menuItems[VIEW_RANK] = "View rankings";
		menuItems[EXIT] = "Quit";
				
		this.gameController = controller;
		this.objectList = objectList;
		this.selectedOption = REMATCH;
	}
	
	public void render() {
		
		menu = new SelectableMenu(MENU_WIDTH, MENU_HEIGHT, Match.PANEL_POSITION_X, Match.PANEL_POSITION_Y + 120);
		menu.setMarginTop(10);
		menu.setFont(new Font("Arial", Font.BOLD, 26));
		menu.setSelectedIndex(selectedOption);
		menu.setUnselectedColor(new Color(0xdcdba9));
		menu.setSelectedColor(new Color(0x9f3636));
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
				PlayState playState = (PlayState) gameController.getState(State.PLAY_STATE);
				
				// Rematch.
				playState.rematch();
				
				// Begin to render menuState.
				gameController.setState(State.PLAY_STATE);
				break;
		
			case BACK_TO_MAIN_MENU:
			
				// Begin to render menuState.
				gameController.setState(State.MENU_STATE);
				break;	
		
			case VIEW_RANK:
			
				ViewRankState viewRankState = (ViewRankState) gameController.getState(State.VIEW_RANK_STATE);
				viewRankState.setBackState(State.PLAY_STATE);
				
				// Begin to render viewRankState
				gameController.setState(State.VIEW_RANK_STATE);
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