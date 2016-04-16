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
	private Phase currentPhase;
	
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
		
		// The initial phase is SelectMovePhase.
		this.currentPhase = new SelectMovePhase(player1, player2, this.objectList);
		
	}
	
	public void render(){

		renderIdlePlayerObjects();
		objectList.add(player1Object);
		objectList.add(player2Object);
		
		currentPhase.render();

	}
	
	private void renderIdlePlayerObjects(){
		player1Object.setIdle();
		player2Object.setIdle();
	}

	@Override
	public void onKeyPressed(KeyEvent keyEvent) {
	
	}

	@Override
	public void onKeyReleased(KeyEvent keyEvent) {
	}

	@Override
	public void onKeyTyped(KeyEvent keyEvent) {
		
	}
	
}
