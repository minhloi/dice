package control;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import boundary.Background;
import boundary.GameCanvas;
import boundary.GameObject;
import boundary.LargePanel;
import boundary.SelectableMenu;

/**
 * The PauseState class is for the screen when ESC is pressed during the game
 * 
 * @author Thien Duc Phung
 * @author Minh Loi
 * @author Daniel Enriquez
 * @author Brett Bauman
 * @author Tanner Siffren
 */

public class PausedState extends State {
	
	private GameController gameController;
	private ArrayList<GameObject> objectList;
	private Background background;
	
	private String[] menuItems; 
	private int menuLength;
	private SelectableMenu menu;
	private int selectedOption;
	private LargePanel menuPanel;
	
	public static final int RESUME = 0;
	public static final int RESTART_NEW_GAME = 1;
	public static final int GO_TO_MAIN_MENU = 2;
	public static final int VIEW_RANK = 3;
	public static final int EXIT = 4;
	
	// Size of the menu panel when the game is paused
	private static final int MENU_WIDTH = 468;
	private static final int MENU_HEIGHT = 346;
	
	// Position of the menu panel when the game is pause
	public static final int PANEL_POSITION_X = (GameCanvas.WIDTH - LargePanel.WIDTH) / 2;
	public static final int PANEL_POSITION_Y = (GameCanvas.HEIGHT - LargePanel.HEIGHT) / 2;
		
	// Pause state menu initializer
	public PausedState(GameController gameController, ArrayList<GameObject> objectList){
		
		menuLength = 5;
		menuItems = new String[menuLength];
		menuItems[RESUME] = "Resume";
		menuItems[RESTART_NEW_GAME] = "Restart new game";
		menuItems[GO_TO_MAIN_MENU] = "Go to main menu";
		menuItems[VIEW_RANK] = "View rankings";
		menuItems[EXIT] = "Quit";
	
		this.gameController = gameController;
		this.objectList = objectList;	
		this.selectedOption = RESUME;
		
		this.menuPanel = new LargePanel(PANEL_POSITION_X, PANEL_POSITION_Y);
		this.background = new Background("play_background.png");
	}
	
	// Setting the attributes for the menu in pause state
	public void render(){
		
		objectList.add(background);
		objectList.add(menuPanel);
		
		menu = new SelectableMenu(MENU_WIDTH, MENU_HEIGHT, PANEL_POSITION_X, PANEL_POSITION_Y + 50);
		menu.setMarginTop(10);
		menu.setFont(new Font("Arial", Font.BOLD, 26));
		menu.setSelectedIndex(selectedOption);
		menu.setUnselectedColor(new Color(0xdcdba9));
		menu.setSelectedColor(new Color(0x9f3636));
		menu.drawMenu(menuItems);
		
		objectList.add(menu);
				
	}
	
	// Menu options for the pause state
	private void route() {
		
		switch (selectedOption){
		
			case RESUME:
			
				// Begin to render menuState.
				gameController.setState(State.PLAY_STATE);
				break;
		
			case RESTART_NEW_GAME:
				
				PlayState playState = (PlayState) gameController.getState(State.PLAY_STATE);
				playState.rematch();
				
				gameController.setState(State.PLAY_STATE);
				
				break;
				
			case GO_TO_MAIN_MENU:
			
				// Begin to render menuState.
				gameController.setState(State.MENU_STATE);
				break;	
		
			case VIEW_RANK:
			
				ViewRankState viewRankState = (ViewRankState) gameController.getState(State.VIEW_RANK_STATE);
				viewRankState.setBackState(State.PAUSED_STATE);
				
				// Begin to render viewRankState
				gameController.setState(State.VIEW_RANK_STATE);
				break;
		
			case EXIT:
				
				gameController.exitGame();	
				break;
			
		}
		
	}
	
	// Selecting options
	private void selectNextOption(){
		if(selectedOption >= menuLength - 1){
			selectedOption = 0;
		} else {
			selectedOption++;
		}
	}
	
	// Selecting Options
	private void selectPrevOption(){
		if(selectedOption <= 0){
			selectedOption = menuLength - 1;
		} else {
			selectedOption--;
		}
	}
	
	// Keys actions
	@Override
	public void onKeyPressed(KeyEvent keyEvent) {
		
	}

	// Keys actions
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

	// Keys actions
	@Override
	public void onKeyTyped(KeyEvent keyEvent) {
		
	}

}
