package control;

import java.util.ArrayList;

import boundary.GameObject;
import boundary.PlayerObject;
import entity.Player;

public class Turn {
	
	private Player player1;
	private Player player2;
	private Player rollWinner;
	private Player rollLoser;
	
	private PlayerObject player1Object;
	private PlayerObject player2Object;
	
	public static final int PLAYER1_IDLE_POSITION_X = 400;
	public static final int PLAYER1_IDLE_POSITION_Y = 200;
	public static final int PLAYER2_IDLE_POSITION_X = 400;
	public static final int PLAYER2_IDLE_POSITION_Y = 600;
	
	private ArrayList<GameObject> objectList;
	
	public Turn(Player player1, Player player2, ArrayList<GameObject> objectList){
		this.player1 = player1;
		this.player2 = player2;
		this.objectList = objectList;
		
		this.player1Object = new PlayerObject(1, PLAYER1_IDLE_POSITION_X, PLAYER1_IDLE_POSITION_Y);
		this.player2Object = new PlayerObject(2, PLAYER2_IDLE_POSITION_X, PLAYER2_IDLE_POSITION_X);
	}
	
	public void render(){
		
		
	
	}
	
	private void renderIdlePlayers(){
		
		PlayerObject character1 = new PlayerObject();
		character1.setPosition(currentTurn, 0);
		character1.setImageByPath("/player1.png");
		objectList.add(character1);
			
	}
	
}
