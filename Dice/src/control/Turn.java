package control;

import java.awt.event.KeyEvent;
import java.util.ArrayList;

import boundary.GameObject;
import boundary.Move;
import boundary.PlayerObject;
import entity.Player;

/**
 * Turn class show which stage the game is in during the match 
 * 
 * @author Thien Duc Phung
 * @author Minh Loi
 * @author Daniel Enriquez
 * @author Brett Bauman
 * @author Tanner Siffren
 */
public class Turn implements Listenable {
	
	private Player player1;
	private Player player2;
	
	private PlayerObject player1Object;
	private PlayerObject player2Object;
	private ArrayList<GameObject> objectList;
	private Phase phaseList[];
	private int currentPhase;
	private boolean turnCompleted;
	
	/**
	 * Contains the phase of which the game is currently in
	 *  
	 * @param player1 - player1 of object type Player
	 * @param player2 - player2 of object type Player
	 * @param player1Object - player1Object of object PlayerObject
	 * @param player2Object - player2Object of object PlayerObject
	 * @param objectList - objectList of ArrayList of GameObject
	 */
	public Turn(Player player1, Player player2, PlayerObject player1Object, PlayerObject player2Object, ArrayList<GameObject> objectList){
		
		this.player1 = player1;
		this.player2 = player2;
		this.player1Object = player1Object;
		this.player2Object = player2Object;
		this.objectList = objectList;
		
		phaseList = new Phase[Phase.LENGTH];
		phaseList[Phase.SELECT_MOVE_PHASE] = new SelectMovePhase(this.player1, this.player2, this.player1Object, this.player2Object, this.objectList);
		phaseList[Phase.ROLL_DICE_PHASE] = new RollDicePhase(this.player1, this.player2, this.player1Object, this.player2Object, this.objectList);
		phaseList[Phase.BATTLE_PHASE] = new BattlePhase(this.player1, this.player2, this.player1Object, this.player2Object, this.objectList);
		
		// The initial phase is SelectMovePhase.
		this.currentPhase = Phase.SELECT_MOVE_PHASE;
		this.turnCompleted = false;
		
	}
	
	/**
	 *  render is the updating of the gui screen
	 *  
	 */
	public void render(){
	
		phaseList[currentPhase].render();
		if(phaseList[currentPhase].isCompleted()){
			if(hasNextPhase()){
				setNextPhase();
			} else {
				setTurnCompleted();
				resetTurn();
			}
		} 
		// Display players' selected moves when both are ready
		if(player1.getTurnInfo().getMove() != Player.NOT_SELECT && player2.getTurnInfo().getMove() != Player.NOT_SELECT){
			Move player1Move = new Move(player1.getTurnInfo().getMove(), PlayerObject.PLAYER1_DEFAULT_POSITION_X - 120, PlayerObject.PLAYER1_DEFAULT_POSITION_Y + 30);
			Move player2Move = new Move(player2.getTurnInfo().getMove(), PlayerObject.PLAYER2_DEFAULT_POSITION_X + 120, PlayerObject.PLAYER2_DEFAULT_POSITION_Y + 30);
			
			objectList.add(player1Move);
			objectList.add(player2Move);
		}	
	}
	
	/**
	 *  resetTurn restes the turn for both players
	 *  
	 */	
	private void resetTurn(){
		player1.resetTurnInfo();
		player2.resetTurnInfo();
	}
	
	/**
	 *  hasNextPhase checks if there is a next phase
	 *  
	 */
	private boolean hasNextPhase(){
		boolean hasNext;
		if(currentPhase >= Phase.LENGTH - 1){
			hasNext = false; 
		} else {
			hasNext = true;
		}
		return hasNext;
	}
	
	/**
	 *  setNextPhase sets the next phase of the game
	 *  
	 */
	private void setNextPhase(){
		if(hasNextPhase() == true){
			++currentPhase;
		}
	}
	
	/**
	 *  isTurnCompleted checks if the players have completed their turn
	 *  
	 * @return turnCompleted - returns if the players have completed their turns
	 * 
	 */
	public boolean isTurnCompleted(){
		return turnCompleted;
	}
	
	/**
	 *  setTurnCompleted sets the turn to complete
	 *  
	 */
	private void setTurnCompleted(){
		turnCompleted = true;
	}
	
	@Override
	public void onKeyPressed(KeyEvent keyEvent) {
	
	}

	/**
	 *  onKeyReleased listens for a button to be pressed
	 *  
	 * @param keyEvent - the button that is pressed
	 */
	@Override
	public void onKeyReleased(KeyEvent keyEvent) {
		phaseList[currentPhase].onKeyReleased(keyEvent);
	}

	@Override
	public void onKeyTyped(KeyEvent keyEvent) {
		
	}
	
}
