package control;

import java.awt.Color;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import boundary.Background;
import boundary.GameCanvas;
import boundary.GameObject;
import boundary.SelectableMenu;

/**
 * MainMenuState class is the first screen with menu screen when the game start
 * 
 * @author Thien Duc Phung
 * @author Minh Loi
 * @author Daniel Enriquez
 * @author Brett Bauman
 * @author Tanner Siffren
 */

public class MainMenuState extends State{

	private GameController gameController;
	private ArrayList<GameObject> objectList;
	private Background background;
	private SelectableMenu menu;
	private String[] menuItems;
	private int menuLength;
	private int selectedOption;
	
	// Option for main menu
	private static final int START_NEW_GAME = 0;
	private static final int VIEW_RANK = 1;
	private static final int EXIT = 2;
	
	// Position of main menu
	private static final int MENU_HEIGHT = 300;
	private static final int MENU_WIDTH = 300;
	private static final int MENU_POSITION_X = (GameCanvas.WIDTH - MENU_WIDTH) / 2 ;
	private static final int MENU_POSITION_Y = (GameCanvas.HEIGHT - MENU_HEIGHT) - 70;
	
	/**
	 * The MainMenuState initializes its properties and menu items
	 * @param controller controller of the game
	 * @param objectList the ArrayList of all game objects
	 */
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
	
	
	/**
	 * Render the main menu
	 */
	@Override
	public void render(){
		
		objectList.add(background);
		
		menu = new SelectableMenu(MENU_WIDTH, MENU_HEIGHT, MENU_POSITION_X, MENU_POSITION_Y);
		menu.setSelectedIndex(selectedOption);
		menu.setMarginTop(24);
		menu.setUnselectedColor(new Color(0x8fbfd9));
		menu.drawMenu(menuItems);
		
		objectList.add(menu);
	}
	
	/**
	 * Route to a specific game state based on selected option
	 */
	private void route(){
		
		switch (selectedOption) {
		
			case START_NEW_GAME:
			
				// Get playState object
				PlayState playState = (PlayState) gameController.getState(State.PLAY_STATE);
				
				// Before starting new game, create user profiles.
				playState.createProfiles();
				
				// Begin to render playState.
				gameController.setState(State.PLAY_STATE);
								
				break;
		
			case VIEW_RANK:
				
				ViewRankState viewRankState = (ViewRankState) gameController.getState(State.VIEW_RANK_STATE);
				viewRankState.setBackState(State.MENU_STATE);
				
				// Begin to render viewRankState
				gameController.setState(State.VIEW_RANK_STATE);
				
				break;
		
			case EXIT:
			
				gameController.exitGame();
				
				break;
			
		}
		
	}
	
	/**
	 * Select next option
	 */
	private void selectNextOption(){
		if(selectedOption >= menuLength - 1){
			selectedOption = 0;
		} else {
			selectedOption++;
		}
	}
	
	/**
	 * Select previous option
	 */
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
