package control;

import java.awt.event.KeyEvent;
import java.util.ArrayList;

import boundary.GameObject;
import boundary.HealthBar;
import boundary.Move;
import boundary.PlayerObject;
import entity.Player;

public class Turn implements Listenable {
	
	private Player player1;
	private Player player2;
	
	private PlayerObject player1Object;
	private PlayerObject player2Object;
	private ArrayList<GameObject> objectList;
	private Phase phaseList[];
	private int currentPhase;
	private boolean turnCompleted;
	
	public Turn(Player player1, Player player2, PlayerObject player1Object, PlayerObject player2Object, ArrayList<GameObject> objectList){
		
		this.player1 = player1;
		this.player2 = player2;
		this.player1Object = player1Object;
		this.player2Object = player2Object;
		this.objectList = objectList;
		
		phaseList = new Phase[Phase.LENGTH];
		phaseList[Phase.SELECT_MOVE_PHASE] = new SelectMovePhase(player1, player2, player1Object, player2Object, objectList);
		phaseList[Phase.ROLL_DICE_PHASE] = new RollDicePhase(player1, player2, player1Object, player2Object, objectList);
		phaseList[Phase.BATTLE_PHASE] = new BattlePhase(player1, player2, player1Object, player2Object, objectList);
		
		// The initial phase is SelectMovePhase.
		this.currentPhase = Phase.SELECT_MOVE_PHASE;
		this.turnCompleted = false;
		
	}
	
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
		
	private void resetTurn(){
		player1.resetTurnInfo();
		player2.resetTurnInfo();
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
	
	private void setNextPhase(){
		if(hasNextPhase() == true){
			++currentPhase;
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
