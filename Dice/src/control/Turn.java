package control;

import java.awt.event.KeyEvent;
import java.util.ArrayList;

import boundary.GameObject;
import boundary.PlayerObject;
import entity.Player;

public class Turn implements Listenable {
	
	private Player player1;
	private Player player2;
	private Player rollWinner;
	private Player rollLoser;
	
	private PlayerObject player1Object;
	private PlayerObject player2Object;
	private ArrayList<GameObject> objectList;
	private Phase phaseList[];
	private int currentPhase;
	private boolean turnCompleted;
	
	public Turn(Player player1, Player player2, ArrayList<GameObject> objectList){
		
		this.player1 = player1;
		this.player2 = player2;
		this.objectList = objectList;
		
		try {
			this.player1Object = new PlayerObject(1, PlayerObject.PLAYER1_IDLE_POSITION_X, PlayerObject.PLAYER1_IDLE_POSITION_Y);
			this.player2Object = new PlayerObject(2, PlayerObject.PLAYER2_IDLE_POSITION_X, PlayerObject.PLAYER2_IDLE_POSITION_Y);
		} catch (Exception e){
			e.printStackTrace();
		}
		
		phaseList = new Phase[Phase.LENGTH];
		phaseList[Phase.SELECT_MOVE_PHASE] = new SelectMovePhase(player1, player2, objectList);
		phaseList[Phase.ROLL_DICE_PHASE] = new RollDicePhase(player1, player2, rollWinner, rollLoser, objectList);
		
		// The initial phase is SelectMovePhase.
		this.currentPhase = Phase.SELECT_MOVE_PHASE;
		this.turnCompleted = false;
		
	}
	
	public void render(){
	
		setPlayerObjectsIdle();
		objectList.add(player1Object);
		objectList.add(player2Object);
		
		if(phaseList[currentPhase].isCompleted()){
			if(hasNextPhase()){
				renderNextPhase();
			} else {
				setTurnCompleted();
			}
		} else {
			phaseList[currentPhase].render();
		}
		
	}
	
	private void setPlayerObjectsIdle(){
		player1Object.setIdle();
		player2Object.setIdle();
	}
	
	private boolean hasNextPhase(){
		boolean hasNext;
		if(currentPhase >= Phase.LENGTH - 1){
			hasNext = false; 
		} else {
			hasNext = true;
		}
		return hasNext;
	}
	
	private void renderNextPhase(){
		if(hasNextPhase() == true){
			++currentPhase;
			phaseList[currentPhase].render();
		}
	}
	
	public boolean isTurnCompleted(){
		return turnCompleted;
	}
	private void setTurnCompleted(){
		turnCompleted = true;
	}
	
	@Override
	public void onKeyPressed(KeyEvent keyEvent) {
	
	}

	@Override
	public void onKeyReleased(KeyEvent keyEvent) {
		phaseList[currentPhase].onKeyReleased(keyEvent);
	}

	@Override
	public void onKeyTyped(KeyEvent keyEvent) {
		
	}
	
}
