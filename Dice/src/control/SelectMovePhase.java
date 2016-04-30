package control;

import java.awt.Color;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import boundary.GameObject;
import boundary.Panel;
import boundary.PlayerObject;
import entity.Player;

/**
 * SelectMovePhase class - Capture each of the player's choice of action. Such 
 * 						   as selecting actions for the game.
 * 
 * @author Thien Duc Phung
 * @author Minh Loi
 * @author Daniel Enriquez
 * @author Brett Bauman
 * @author Tanner Siffren
 */
public class SelectMovePhase extends Phase {
	
	private Player player1;
	private Player player2;
	private PlayerObject player1Object;
	private PlayerObject player2Object;
	private ArrayList<GameObject> objectList;
	
	// Player move-set definition
	public static final char[] PLAYER1_MOVE_SET = {'A', 'S', 'D'};
	public static final char[] PLAYER2_MOVE_SET = {'J', 'K', 'L'};
	
	/**
	 * Constructor - receives Players, PlayerObjects and 
	 * 
	 * @param player1 the Player object of player 1
	 * @param player2 the Player object of player 2
	 * @param player1Object character object of player 1 
	 * @param player2Object character object of player 2
	 * @param objectList the ArrayList of all game object
	 */
	public SelectMovePhase(Player player1, Player player2, PlayerObject player1Object, PlayerObject player2Object, ArrayList<GameObject> objectList){
		this.player1 = player1;
		this.player2 = player2;
		this.player1Object = player1Object;
		this.player2Object = player2Object;
		this.objectList = objectList;
		
	}
	
	/**
	 * render - Display instructions in the panels for each players 
	 */
	public void render(){
		
		this.player1Object.setIdle();
		this.player2Object.setIdle();
		
		Panel player1Panel = new Panel(Panel.PANEL_1_POSITION_X, Panel.PANEL_1_POSITION_Y);
		Panel player2Panel = new Panel(Panel.PANEL_2_POSITION_X, Panel.PANEL_2_POSITION_Y);
		
		if(player1.getTurnInfo().getMove() == Player.NOT_SELECT){
			String moveSet = getAvailabelMoveSet(1);
			player1Panel.drawString("Press a key to select move.", Panel.ALIGN_LEFT, Panel.ALIGN_TOP);
			player1Panel.drawString( moveSet, Panel.ALIGN_LEFT, Panel.ALIGN_BOTTOM, new Color(0x3b7d86));
		} else {
			player1Panel.drawString("Ready.", Panel.ALIGN_LEFT, Panel.ALIGN_TOP, new Color(0x3b7d86));
			player1Panel.drawString("Waiting for Player 2.", Panel.ALIGN_LEFT, Panel.ALIGN_BOTTOM);
		}
		
		if(player2.getTurnInfo().getMove() == Player.NOT_SELECT){
			String moveSet = getAvailabelMoveSet(2);
			player2Panel.drawString("Press a key to select move.", Panel.ALIGN_LEFT, Panel.ALIGN_TOP);
			player2Panel.drawString( moveSet, Panel.ALIGN_LEFT, Panel.ALIGN_BOTTOM,  new Color(0x3b7d86));
		} else {
			player2Panel.drawString("Ready.", Panel.ALIGN_LEFT, Panel.ALIGN_TOP, new Color(0x3b7d86));
			player2Panel.drawString("Waiting for Player 1.", Panel.ALIGN_LEFT, Panel.ALIGN_BOTTOM);
			
		}
		
		objectList.add(player1Panel);
		objectList.add(player2Panel);
	
	}
	
	/**
	 *  getAvailabelMoveSet print out all available moves
	 *  
	 * @param playerNum - the number of the player
	 */
	private String getAvailabelMoveSet(int playerNum){
		String moveSet;
		if(playerNum == player1.getNumber()){
			moveSet = PLAYER1_MOVE_SET[Player.ATTACK] + ": Attack";
			if(player1.getTurnInfo().isBlockDisabled() == false){
				moveSet += "   " + PLAYER1_MOVE_SET[Player.BLOCK] + ": Block";
			}
			if(player1.canUseSpecial() == true){
				moveSet += "   " + PLAYER1_MOVE_SET[Player.SPECIAL_ATTACK] + ": Special";
			}
		} else {
			moveSet = PLAYER2_MOVE_SET[Player.ATTACK] + ": Attack";
			if(player2.getTurnInfo().isBlockDisabled() == false){
				moveSet += "   " + PLAYER2_MOVE_SET[Player.BLOCK] + ": Block";
			}
			if(player2.canUseSpecial() == true){
				moveSet += "   " + PLAYER2_MOVE_SET[Player.SPECIAL_ATTACK] + ": Special";
			}
		}
		return moveSet;
	}
	
	/**
	 * Checks to see if player 1 has selected a move
	 */
	private boolean isPlayer1Selected(){
		boolean result;
		if(player1.getTurnInfo().getMove() != Player.NOT_SELECT){
			result = true;
		} else {
			result = false;
		}
		return result;
	}
	
	/**
	 * Checks to see if player 2 has selected a move
	 */
	private boolean isPlayer2Selected(){
		boolean result;
		if(player2.getTurnInfo().getMove() != Player.NOT_SELECT){
			result = true;
		} else {
			result = false;
		}
		return result;
	}
	
	/**
	 * Checks to see if both players have selected their moves
	 */
	private boolean isBothSelected(){
		boolean result;
		
		if(player1.getTurnInfo().getMove() != Player.NOT_SELECT && player2.getTurnInfo().getMove() != Player.NOT_SELECT){
			result = true;
		} else {
			result = false;
		}
		return result;
	}
		
	@Override
	public void onKeyPressed(KeyEvent keyEvent) {
		
	}
	
	/**
	 *  onKeyReleased checks to see which key was selected
	 *  
	 * @param keyEvent the key that gets selected
	 */
	@Override
	public void onKeyReleased(KeyEvent keyEvent) {
		int keyCode = keyEvent.getKeyCode();
		
		try {
			switch(keyCode){
				case KeyEvent.VK_A: //a
					if(!isPlayer1Selected())
						player1.getTurnInfo().setMove(Player.ATTACK);
					break;
				case KeyEvent.VK_S: //s
					if(!isPlayer1Selected() && player1.getTurnInfo().isBlockDisabled() == false)
						player1.getTurnInfo().setMove(Player.BLOCK);
					break;
				case KeyEvent.VK_D: //d
					if(!isPlayer1Selected() && player1.canUseSpecial() == true)
						player1.getTurnInfo().setMove(Player.SPECIAL_ATTACK);
					break;
				case KeyEvent.VK_J: //j
					if(!isPlayer2Selected())
						player2.getTurnInfo().setMove(Player.ATTACK);
					break;
				case KeyEvent.VK_K: //k
					if(!isPlayer2Selected() && player2.getTurnInfo().isBlockDisabled() == false)
						player2.getTurnInfo().setMove(Player.BLOCK);
					break;
				case KeyEvent.VK_L: //l
					if(!isPlayer2Selected() && player2.canUseSpecial() == true)
						player2.getTurnInfo().setMove(Player.SPECIAL_ATTACK);
					break;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		if(isBothSelected()){
			setCompleted();
		}
		
	}

	@Override
	public void onKeyTyped(KeyEvent keyEvent) {
		
	}
	
}
