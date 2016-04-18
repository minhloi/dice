package control;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Scanner;

import boundary.DiceObject;
import boundary.GameObject;
import boundary.Panel;
import boundary.PlayerObject;
import entity.Player;

public class RollDicePhase extends Phase {
	
	private Player player1;
	private Player player2;
	private PlayerObject player1Object;
	private PlayerObject player2Object;
	
	private boolean dice1Stopped;
	private boolean dice2Stopped;
	public int player1CurrentDice;
	public int player2CurrentDice;
	public int currentState;
	
	private ArrayList<GameObject> objectList;
	
	public static final int ROLLING = 0;
	public static final int TIE_ROLLING_AGAIN = 1;
	public static final int HAS_WINNER = 2;
		
	public RollDicePhase(Player player1, Player player2, PlayerObject player1Object, PlayerObject player2Object, ArrayList<GameObject> objectList){
		
		this.player1 = player1;
		this.player2 = player2;
		this.player1Object = player1Object;
		this.player2Object = player2Object;
		this.objectList = objectList;
		this.dice1Stopped = false;
		this.dice2Stopped = false;
		this.player1CurrentDice = player1.getDice().roll();
		this.player2CurrentDice = player2.getDice().roll();
		this.currentState = ROLLING;
		
	}
	
	public void render(){
				
		Panel player1Panel = new Panel(Panel.PANEL_1_POSITION_X, Panel.PANEL_1_POSITION_Y);
		Panel player2Panel = new Panel(Panel.PANEL_2_POSITION_X, Panel.PANEL_2_POSITION_Y);
		
		if(currentState == ROLLING){
			rollingDie();
			player1Panel.drawString("Press W to stop.", Panel.ALIGN_LEFT, Panel.ALIGN_TOP);
			player2Panel.drawString("Press I to stop.", Panel.ALIGN_LEFT, Panel.ALIGN_TOP);
		
		} else if(currentState == TIE_ROLLING_AGAIN){
			rollingDie();
			player1Panel.drawString("Tie. Rolling again.", Panel.ALIGN_LEFT, Panel.ALIGN_TOP, new Color(0x3b7d86));
			player1Panel.drawString("Press W to stop.", Panel.ALIGN_LEFT, Panel.ALIGN_BOTTOM);
			
			player2Panel.drawString("Tie. Rolling again", Panel.ALIGN_LEFT, Panel.ALIGN_TOP, new Color(0x3b7d86));
			player2Panel.drawString("Press I to stop.", Panel.ALIGN_LEFT, Panel.ALIGN_BOTTOM);
		
		} else if(currentState == HAS_WINNER){
			if(player1.getTurnInfo().isTurnWinner()){
				player1Panel.drawString("You win!", Panel.ALIGN_LEFT, Panel.ALIGN_TOP, new Color(0x449775));
				player1Panel.drawString("Press W to roll for damage.", Panel.ALIGN_LEFT, Panel.ALIGN_BOTTOM, new Font("Serif", Font.BOLD, 16));
			} else {
				player1Panel.drawString("You lose!", Panel.ALIGN_LEFT, Panel.ALIGN_TOP, new Color(0x90243a));
			}
			
			if(player2.getTurnInfo().isTurnWinner()){
				player2Panel.drawString("You win!", Panel.ALIGN_LEFT, Panel.ALIGN_TOP, new Color(0x449775));
				player2Panel.drawString("Press I to roll for damage.", Panel.ALIGN_LEFT, Panel.ALIGN_BOTTOM, new Font("Serif", Font.BOLD, 16));
			} else {
				player2Panel.drawString("You Lose!", Panel.ALIGN_LEFT, Panel.ALIGN_TOP, new Color(0x90243a));
			}
		}
		
		DiceObject dice1Object = new DiceObject(DiceObject.DICE1_POSITION_X, DiceObject.DICE1_POSITION_Y);
		dice1Object.setImageByDiceNum(player1CurrentDice);

		DiceObject dice2Object = new DiceObject(DiceObject.DICE2_POSITION_X, DiceObject.DICE2_POSITION_Y);
		dice2Object.setImageByDiceNum(player2CurrentDice);
		
		this.player1Object.setIdle();
		this.player2Object.setIdle();
				
		objectList.add(player1Object);
		objectList.add(player2Object);
		
		objectList.add(player1Panel);
		objectList.add(player2Panel);
		
		objectList.add(dice1Object);
		objectList.add(dice2Object);
		
	}
	
	private void rollingDie(){
		// Keep rolling until players press stop.
		if(dice1Stopped == false ){
			player1CurrentDice =  player1.getDice().roll();
		}
		if(dice2Stopped == false){
				player2CurrentDice =  player2.getDice().roll();			
		}
	}
	
	private boolean setWinner(){
		boolean hasWinner = false;
		if(player1CurrentDice > player2CurrentDice ){
			player1.getTurnInfo().setTurnWinner();
			hasWinner = true;
		} else if(player1CurrentDice < player2CurrentDice){
			player2.getTurnInfo().setTurnWinner();
			hasWinner = true;
		}
		return hasWinner;
	}
	
	private void setToRollAgain(){
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
		if(currentState == ROLLING || currentState == TIE_ROLLING_AGAIN){
			
			switch(keyCode){
				case 87: //w
					dice1Stopped = true;
					break;
				case 73: //i
					dice2Stopped = true;
					break;
			}
			
			if(dice1Stopped == true & dice2Stopped == true){
				if(setWinner()){
					currentState = HAS_WINNER;
				} else {
					currentState = TIE_ROLLING_AGAIN;
					setToRollAgain();
				}
			}

		} else if(currentState == HAS_WINNER){
			
			switch(keyCode){
				case 87: //w
					if(player1.getTurnInfo().isTurnWinner())
						setCompleted();
					break;
				case 73: //i
					if(player2.getTurnInfo().isTurnWinner())
						setCompleted();
					break;
			}

		}
				
	}

	@Override
	public void onKeyTyped(KeyEvent keyEvent) {
		// TODO Auto-generated method stub
		
	}

}
