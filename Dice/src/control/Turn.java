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
	
	public static final int PLAYER1_IDLE_POSITION_X = 0;
	public static final int PLAYER1_IDLE_POSITION_Y = 250;
	public static final int PLAYER2_IDLE_POSITION_X = 600;
	public static final int PLAYER2_IDLE_POSITION_Y = 250;
		
	public Turn(Player player1, Player player2, ArrayList<GameObject> objectList){
		
		this.player1 = player1;
		this.player2 = player2;
		this.objectList = objectList;
		
		try {
			this.player1Object = new PlayerObject(1, PLAYER1_IDLE_POSITION_X, PLAYER1_IDLE_POSITION_Y);
			this.player2Object = new PlayerObject(2, PLAYER2_IDLE_POSITION_X, PLAYER2_IDLE_POSITION_Y);
		} catch (Exception e){
			e.printStackTrace();
		}
		
		phaseList = new Phase[Phase.LENGTH];
		phaseList[Phase.SELECT_MOVE_PHASE] = new SelectMovePhase(player1, player2, objectList);
		phaseList[Phase.ROLL_DICE_PHASE] = new RollDicePhase(player1, player2, rollWinner, rollLoser, objectList);
		
		// The initial phase is SelectMovePhase.
		this.currentPhase = Phase.SELECT_MOVE_PHASE;
		
	}
	
	public boolean render(){
		
		boolean hasNextPhase = false;
		
		setPlayerObjectsIdle();
		objectList.add(player1Object);
		objectList.add(player2Object);
		
		phaseList[currentPhase].render();
		if(phaseList[currentPhase].isCompleted()){
			hasNextPhase = nextPhase();
		}
		
		return hasNextPhase;
	}
	
	private void setPlayerObjectsIdle(){
		player1Object.setIdle();
		player2Object.setIdle();
	}
	
	private boolean nextPhase(){
		boolean hasNext;
		if(currentPhase >= Phase.LENGTH){
			hasNext = false; 
		} else {
			++currentPhase;
			hasNext = true;
		}
		return hasNext;		
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
