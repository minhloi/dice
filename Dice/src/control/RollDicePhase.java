package control;

import java.awt.Color;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import boundary.DiceObject;
import boundary.GameObject;
import boundary.Panel;
import boundary.PlayerObject;
import entity.Player;

/**
 * RollDicePhase class - Trigger Dice class to generate the value and display 
 * 						 who win the roll
 * 
 * @author Thien Duc Phung
 * @author Minh Loi
 * @author Daniel Enriquez
 * @author Brett Bauman
 * @author Tanner Siffren
 */
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
	
	private static final int ROLLING = 0;
	private static final int TIE_ROLLING_AGAIN = 1;
	private static final int HAS_WINNER = 2;
	
	private static final Color GREEN = new Color(0x398564);
	private static final Color RED = new Color(0x90243a);
	private static final Color BLUE = new Color(0x3b7d86);
	
	
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
	
	/**
	 * render - Render roll-dice phase.
	 */
	public void render(){
				
		Panel player1Panel = new Panel(Panel.PANEL_1_POSITION_X, Panel.PANEL_1_POSITION_Y);
		Panel player2Panel = new Panel(Panel.PANEL_2_POSITION_X, Panel.PANEL_2_POSITION_Y);
		
		if(currentState == ROLLING){
			rollingDie();
			player1Panel.drawString("Press E to stop.", Panel.ALIGN_LEFT, Panel.ALIGN_TOP);
			player2Panel.drawString("Press U to stop.", Panel.ALIGN_LEFT, Panel.ALIGN_TOP);
		
		} else if(currentState == TIE_ROLLING_AGAIN){
			rollingDie();
			player1Panel.drawString("Tie. Rolling again.", Panel.ALIGN_LEFT, Panel.ALIGN_TOP, BLUE);
			player1Panel.drawString("Press E to stop.", Panel.ALIGN_LEFT, Panel.ALIGN_BOTTOM);
			
			player2Panel.drawString("Tie. Rolling again", Panel.ALIGN_LEFT, Panel.ALIGN_TOP, BLUE);
			player2Panel.drawString("Press U to stop.", Panel.ALIGN_LEFT, Panel.ALIGN_BOTTOM);
		
		} else if(currentState == HAS_WINNER){
			if(player1.getTurnInfo().isTurnWinner()){
				player1Panel.drawString("You win! Press E to", Panel.ALIGN_LEFT, Panel.ALIGN_TOP, GREEN);
				player1Panel.drawString("roll for damage.", Panel.ALIGN_LEFT, Panel.ALIGN_BOTTOM, GREEN);
			} else {
				player1Panel.drawString("You lose!", Panel.ALIGN_LEFT, Panel.ALIGN_TOP, RED);
			}
			
			if(player2.getTurnInfo().isTurnWinner()){
				player2Panel.drawString("You win! Press U to", Panel.ALIGN_LEFT, Panel.ALIGN_TOP, GREEN);
				player2Panel.drawString("roll for damage.", Panel.ALIGN_LEFT, Panel.ALIGN_BOTTOM, GREEN);
			} else {
				player2Panel.drawString("You Lose!", Panel.ALIGN_LEFT, Panel.ALIGN_TOP, RED);
			}
		}
		
		DiceObject dice1Object = new DiceObject(DiceObject.DICE1_POSITION_X, DiceObject.DICE1_POSITION_Y);
		dice1Object.setImageByDiceNum(player1CurrentDice);

		DiceObject dice2Object = new DiceObject(DiceObject.DICE2_POSITION_X, DiceObject.DICE2_POSITION_Y);
		dice2Object.setImageByDiceNum(player2CurrentDice);
		
		this.player1Object.setIdle();
		this.player2Object.setIdle();
				
		objectList.add(player1Panel);
		objectList.add(player2Panel);
		
		objectList.add(dice1Object);
		objectList.add(dice2Object);
		
	}
	
	/**
	*  rollingDie rolls the die until the players press the stop button
	*  
	*/
	private void rollingDie(){
		// Keep rolling until players press stop.
		if(dice1Stopped == false ){
			player1CurrentDice =  player1.getDice().roll();
		}
		if(dice2Stopped == false){
				player2CurrentDice =  player2.getDice().roll();			
		}
	}
	
	 /**
	 *  setwinner returns a boolean of true for the player that won the game
	 *  
	 * @return hasWinner - retruns true for the player that won the game
	 */
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
	
	 /**
	 *  setToRollAgain resets the dice from the stopped state in preparation to roll again
	 *  
	 */
	private void setToRollAgain(){
		dice1Stopped = false;
		dice2Stopped = false;
	}

	@Override
	public void onKeyPressed(KeyEvent keyEvent) {
		// TODO Auto-generated method stub
		
	}
	
	 /**
	 *  onKeyReleased listens for the key to be pressed to stop the die
	 *  
	 * @param keyEvent - the button that gets pressed
	 */
	@Override
	public void onKeyReleased(KeyEvent keyEvent) {

		int keyCode = keyEvent.getKeyCode();
		if(currentState == ROLLING || currentState == TIE_ROLLING_AGAIN){
			
			switch(keyCode){
				case 69: //e
					dice1Stopped = true;
					break;
				case 85: //u
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
				case 69: //e
					if(player1.getTurnInfo().isTurnWinner())
						setCompleted();
					break;
				case 85: //u
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
