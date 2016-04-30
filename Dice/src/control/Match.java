package control;

import java.awt.event.KeyEvent;
import java.util.ArrayList;

import boundary.Background;
import boundary.GameCanvas;
import boundary.GameObject;
import boundary.HealthBar;
import boundary.LargePanel;
import boundary.PlayerObject;
import boundary.WinnerTitle;
import entity.Database;
import entity.Player;

/**
 * Match class - Handles all different phases inside a game match.
 * 
 * @author Thien Duc Phung
 * @author Minh Loi
 * @author Daniel Enriquez
 * @author Brett Bauman
 * @author Tanner Siffren
 */
public class Match implements Listenable {

	private Player player1; 
	private Player player2;
	
	private boolean matchEnded;
	private Turn currentTurn;
	
	private PlayerObject player1Object;
	private PlayerObject player2Object;
	
	private HealthBar healthBar1;
	private HealthBar healthBar2;
		
	private ArrayList<GameObject> objectList;
	private GameController gameController;
	private Database database;
	private Background background;
	private LargePanel menuPanel;
	private MatchEndMenu menu;
	
	public static final int PANEL_POSITION_X = (GameCanvas.WIDTH - LargePanel.WIDTH) / 2;
	public static final int PANEL_POSITION_Y = (GameCanvas.HEIGHT - LargePanel.HEIGHT) / 2;
	
	/**
	 * Constructor - Initializes all its variables.
	 * 
	 * @param player1 Player object
	 * @param player2 Player object
	 * @param gameController gameController object
	 * @param scanner Scanner object
	 * @param database Database object
	 */
	public Match(Player player1, Player player2, GameController gameController, ArrayList<GameObject> objectList, Database database) {
		
		this.player1 = player1;
		this.player2 = player2;
		this.gameController = gameController;
		this.objectList = objectList;
		this.database = database;
				
		try {
			this.player1Object = new PlayerObject(1);
			this.player2Object = new PlayerObject(2);
		} catch (Exception e){
			e.printStackTrace();
		}
		
		this.background = new Background("play_background.png");
		
		this.healthBar1 = new HealthBar(HealthBar.PLAYER1_POSITION_X, HealthBar.PLAYER1_POSITION_Y);
		this.healthBar2 = new HealthBar(HealthBar.PLAYER2_POSITION_X, HealthBar.PLAYER2_POSITION_Y);
		
		this.currentTurn = new Turn(player1, player2, player1Object, player2Object, objectList);
		this.matchEnded = false;
		this.menuPanel = new LargePanel(PANEL_POSITION_X, PANEL_POSITION_Y);
		this.menu = new MatchEndMenu(this.gameController, this.objectList);
	}
		
	/**
	 * beginTurn - This method is used to render each turn.
	 */
	public void renderTurn() {
		
		objectList.add(background);
		objectList.add(player1Object);
		objectList.add(player2Object);
		
		healthBar1.setHealthBar(player1.getHealth());
		healthBar2.setHealthBar(player2.getHealth());
		
		objectList.add(healthBar1);
		objectList.add(healthBar2);
		
		if(matchEnded == false){
			currentTurn.render();
			
			if(currentTurn.isTurnCompleted()){
				if(!hasWinner()){
					setNewTurn();
				} else {
					setMatchEnd();
					saveData();
				}
			}
		
		} else {
			
			getWinnerObject().setIdle();
			getLoserObject().setDead();
			displayMenu();
		}
			
	}
	
	private void setNewTurn(){
		currentTurn = new Turn(player1, player2, player1Object, player2Object, objectList);
		
	}
	
	private void setMatchEnd(){
		matchEnded = true;
	}
	
	private void saveData(){

		database.incrementWinByName(getWinner().getUserName());
		database.incrementLossByName(getLoser().getUserName());
		database.saveData();
	}
	
	private Player getWinner(){
		Player winner = null;
		if (player1.getHealth() <= 0) {
			winner = player2;
		} else if(player2.getHealth() <= 0){
			winner = player1;
		}
		return winner;
	}
	
	private Player getLoser(){
		Player loser = null;
		if (player1.getHealth() <= 0) {
			loser = player1;
		} else if(player2.getHealth() <= 0){
			loser = player2;
		}
		return loser;
	}
	
	private PlayerObject getWinnerObject(){
		PlayerObject winnerObject;
		if(getWinner().getNumber() == 1){
			winnerObject = player1Object;
		} else {
			winnerObject = player2Object;
		}
		return winnerObject;
	}
	
	private PlayerObject getLoserObject(){
		PlayerObject loserObject;
		if(getLoser().getNumber() == 1){
			loserObject = player1Object;
		} else {
			loserObject = player2Object;
		}
		return loserObject;
	}
	
	private void displayMenu(){
		
		objectList.add(menuPanel);
		
		int winTitlePositionX = (GameCanvas.WIDTH - WinnerTitle.WIDTH) / 2;
		int winTitlePositionY = PANEL_POSITION_Y + 60;
		WinnerTitle winnerTitle = new WinnerTitle(getWinner().getNumber(), winTitlePositionX, winTitlePositionY);
		
		objectList.add(winnerTitle);
		
		menu.render();

	}
	
	/**
	 * hasWinner - Check if there is a winner.
	 * 
	 * @return true if there is a winner, and false otherwise
	 */
	private boolean hasWinner(){
		
		boolean hasWinner;
		
		// Check health points of two players.
		if (player1.getHealth() > 0 && player2.getHealth() > 0) {
			hasWinner = false;
		} else {
			hasWinner = true;						
		}
		
		return hasWinner;		
	}

	@Override
	public void onKeyPressed(KeyEvent keyEvent) {
	}

	@Override
	public void onKeyReleased(KeyEvent keyEvent) {
		
		if(matchEnded == false){
			if(keyEvent.getKeyCode() == KeyEvent.VK_ESCAPE){
				gameController.setState(State.PAUSED_STATE);
			} else {
				currentTurn.onKeyReleased(keyEvent);
			}
		} else {
			menu.onKeyReleased(keyEvent);
		}
	}

	@Override
	public void onKeyTyped(KeyEvent keyEvent) {
		
	}
		
}
