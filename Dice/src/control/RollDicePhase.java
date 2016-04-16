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
	private int player1CurrentDice;
	private int player2CurrentDice;
	
	private ArrayList<GameObject> objectList;
	
	public static final int DICE1_POSITION_X = 0;
	public static final int DICE1_POSITION_Y = 0;
	public static final int DICE2_POSITION_X = 0;
	public static final int DICE2_POSITION_Y = 0;

	public RollDicePhase(Player player1, Player player2, Player rollWinner, Player rollLoser, ArrayList<GameObject> objectList){
		this.player1 = player1;
		this.player2 = player2;
		this.objectList = objectList;
		this.dice1Stopped = false;
		this.dice2Stopped = false;
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
		
		Panel player1RollPanel = new Panel(1, Turn.PANEL_1_POSITION_X, Turn.PANEL_1_POSITION_Y);
		Panel player2RollPanel = new Panel(2, Turn.PANEL_2_POSITION_X, Turn.PANEL_2_POSITION_Y);

		player1SelectPanel.setState(Panel.SELECTING);
		
		DiceObject dice1Object = new DiceObject(DICE1_POSITION_X, DICE1_POSITION_Y);
		dice1Object.setImageByDiceNum(player1CurrentDice);

		DiceObject dice2Object = new DiceObject(DICE2_POSITION_X, DICE2_POSITION_Y);
		dice2Object.setImageByDiceNum(player2CurrentDice);
		
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
		switch(keyCode){
			case 87: //w
				dice1Stopped = true;
				break;
			case 73: //i
				dice2Stopped = true;
				break;
		}
		
	}

	@Override
	public void onKeyTyped(KeyEvent keyEvent) {
		// TODO Auto-generated method stub
		
	}

}
