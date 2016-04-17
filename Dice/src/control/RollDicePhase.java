package control;

import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Scanner;

import boundary.DiceObject;
import boundary.GameObject;
import boundary.Panel;
import entity.Player;

public class RollDicePhase extends Phase {
	
	private Player player1;
	private Player player2;
	private Player rollWinner;
	private Player rollLoser;
	
	private boolean dice1Stopped;
	private boolean dice2Stopped;
	public int player1CurrentDice;
	public int player2CurrentDice;
	public int currentState;
	
	private ArrayList<GameObject> objectList;
	
	public static final int ROLLING_STATE = 0;
	public static final int ROLLING_AGAIN_STATE = 1;
	public static final int DISPLAY_WINNER_STATE = 2;
	
	
	public static final int DICE1_POSITION_X = Turn.PANEL_1_POSITION_X + Panel.WIDTH - DiceObject.WIDTH - 10;
	public static final int DICE1_POSITION_Y = Turn.PANEL_1_POSITION_Y + 10;
	public static final int DICE2_POSITION_X = Turn.PANEL_2_POSITION_X + 10;
	public static final int DICE2_POSITION_Y = Turn.PANEL_2_POSITION_Y + 10;

	public RollDicePhase(Player player1, Player player2, Player rollWinner, Player rollLoser, ArrayList<GameObject> objectList){
		this.player1 = player1;
		this.player2 = player2;
		this.objectList = objectList;
		this.dice1Stopped = false;
		this.dice2Stopped = false;
		this.player1CurrentDice = player1.getDice().roll();
		this.player2CurrentDice = player2.getDice().roll();
		this.currentState = ROLLING_STATE;
		
	}
	
	public void render(){
				
		if(dice1Stopped == true && dice2Stopped == true){
			if(setWinner() == true){
				setCompleted();
			} else {
				rollAgain();
			}
			
		} else {
			
			// Keep rolling until players press stop.
			if(dice1Stopped == false ){
				player1CurrentDice =  player1.getDice().roll();
			}
			
			if(dice2Stopped == false){
				player2CurrentDice =  player2.getDice().roll();			
			}

		}

		Panel player1Panel = new Panel(1, Turn.PANEL_1_POSITION_X, Turn.PANEL_1_POSITION_Y);
		Panel player2Panel = new Panel(2, Turn.PANEL_2_POSITION_X, Turn.PANEL_2_POSITION_Y);
		
		
		DiceObject dice1Object = new DiceObject(DICE1_POSITION_X, DICE1_POSITION_Y);
		dice1Object.setImageByDiceNum(player1CurrentDice);

		DiceObject dice2Object = new DiceObject(DICE2_POSITION_X, DICE2_POSITION_Y);
		dice2Object.setImageByDiceNum(player2CurrentDice);
		
		objectList.add(player1Panel);
		objectList.add(player2Panel);
		
		objectList.add(dice1Object);
		objectList.add(dice2Object);
		
	}
	
	private boolean setWinner(){
		boolean hasWinner = false;
		if(player1CurrentDice > player2CurrentDice ){
			rollWinner = player1;
			rollLoser = player2;
			hasWinner = true;
		} else if(player1CurrentDice < player2CurrentDice){
			rollWinner = player2;
			rollLoser = player1;
			hasWinner = true;
		}
		return hasWinner;
	}
	
	private void rollAgain(){
		dice1Stopped = false;
		dice2Stopped = false;
	}

	@Override
	public void onKeyPressed(KeyEvent keyEvent) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onKeyReleased(KeyEvent keyEvent) {

		int keyCode = keyEvent.getKeyCode();
		if(currentState == ROLLING_STATE){
			switch(keyCode){
				case 87: //w
					dice1Stopped = true;
					break;
				case 73: //i
					dice2Stopped = true;
					break;
			}
		}		
	}

	@Override
	public void onKeyTyped(KeyEvent keyEvent) {
		// TODO Auto-generated method stub
		
	}

}
