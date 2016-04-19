package control;

import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Scanner;

import boundary.Background;
import boundary.GameObject;
import boundary.HealthBar;
import boundary.PlayerObject;
import entity.Database;
import entity.Player;

/**
 * Match class with all the require method of the game to play
 * 
 * @author Thien Duc Phung
 * @author Minh Loi
 * @author Daniel Enriquez
 * @author Brett Bauman
 * @author Tanner Siffren
 * 
 */
public class Match implements Listenable {

	private Player player1; 
	private Player player2;

	private Turn currentTurn;
	
	private PlayerObject player1Object;
	private PlayerObject player2Object;
	
	private HealthBar healthBar1;
	private HealthBar healthBar2;
		
	private ArrayList<GameObject> objectList;
	private GameController gameController;
	private Database database;
	private Background background;
	
	/**
	 * 
	 * @param player1
	 * @param player2
	 * @param gameController
	 * @param scanner
	 * @param database
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
		
		this.background = new Background("forest.png");
		
		this.healthBar1 = new HealthBar(HealthBar.PLAYER1_POSITION_X, HealthBar.PLAYER1_POSITION_Y);
		this.healthBar2 = new HealthBar(HealthBar.PLAYER2_POSITION_X, HealthBar.PLAYER2_POSITION_Y);
		
		this.currentTurn = new Turn(player1, player2, player1Object, player2Object, objectList);
		
	}
		
	/**
	 * Method to begin the fight 
	 */
	public void renderTurn() {
		
		objectList.add(background);
		objectList.add(player1Object);
		objectList.add(player2Object);
		
		healthBar1.setHealthBar(player1.getHealth());
		healthBar2.setHealthBar(player2.getHealth());
		
		objectList.add(healthBar1);
		objectList.add(healthBar2);
		
		currentTurn.render();
		
		if(currentTurn.isTurnCompleted()){
			if(!hasWinner()){
				setNewTurn();
			} else {
				//displayWinner();
				//displayMenu();
			}
		} 
			
	}
	
	private void setNewTurn(){
		currentTurn = new Turn(player1, player2, player1Object, player2Object, objectList);
	}
		
	private void displayWinner(){
		
		database.incrementWinByName(getWinner().getUserName());
		database.incrementLossByName(getLoser().getUserName());
		
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
	
	private void displayMenu(){
				
	}
	
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
		currentTurn.onKeyPressed(keyEvent);
	}

	@Override
	public void onKeyReleased(KeyEvent keyEvent) {
		currentTurn.onKeyReleased(keyEvent);
	}

	@Override
	public void onKeyTyped(KeyEvent keyEvent) {
		// TODO Auto-generated method stub
		
	}
		
}
