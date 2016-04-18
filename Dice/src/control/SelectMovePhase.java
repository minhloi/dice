package control;

import java.awt.Color;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import boundary.GameObject;
import boundary.Panel;
import boundary.PlayerObject;
import entity.Player;

public class SelectMovePhase extends Phase {
	
	private Player player1;
	private Player player2;
	private PlayerObject player1Object;
	private PlayerObject player2Object;
	private ArrayList<GameObject> objectList;
	
	// Player move-set definition
	public static final char[] PLAYER1_MOVE_SET = {'A', 'S', 'D'};
	public static final char[] PLAYER2_MOVE_SET = {'J', 'K', 'L'};
	
	public SelectMovePhase(Player player1, Player player2, PlayerObject player1Object, PlayerObject player2Object, ArrayList<GameObject> objectList){
		this.player1 = player1;
		this.player2 = player2;
		this.player1Object = player1Object;
		this.player2Object = player2Object;
		this.objectList = objectList;
		
		this.player1Object.setIdle();
		this.player2Object.setIdle();
	}
	
	public void render(){
		
		Panel player1Panel = new Panel(Panel.PANEL_1_POSITION_X, Panel.PANEL_1_POSITION_Y);
		Panel player2Panel = new Panel(Panel.PANEL_2_POSITION_X, Panel.PANEL_2_POSITION_Y);
		
		if(player1.getTurnInfo().getMove() == Player.NOT_SELECT){
			player1Panel.drawString("Press a key to select move.", Panel.ALIGN_LEFT, Panel.ALIGN_TOP);
			player1Panel.drawString(PLAYER1_MOVE_SET[Player.ATTACK] + ": atk   " + PLAYER1_MOVE_SET[Player.BLOCK] + ": block   " + PLAYER1_MOVE_SET[Player.SPECIAL_ATTACK] + ": special atk" , Panel.ALIGN_LEFT, Panel.ALIGN_BOTTOM, new Color(0x3b7d86));
		} else {
			player1Panel.drawString("Ready.", Panel.ALIGN_LEFT, Panel.ALIGN_TOP, new Color(0x3b7d86));
			player1Panel.drawString("Waiting for Player 2.", Panel.ALIGN_LEFT, Panel.ALIGN_BOTTOM);
		}
		
		if(player2.getTurnInfo().getMove() == Player.NOT_SELECT){
			player2Panel.drawString("Press a key to select move.", Panel.ALIGN_LEFT, Panel.ALIGN_TOP);
			player2Panel.drawString(PLAYER2_MOVE_SET[Player.ATTACK] + ": atk   " + PLAYER2_MOVE_SET[Player.BLOCK] + ": block   " + PLAYER2_MOVE_SET[Player.SPECIAL_ATTACK] + ": special atk" , Panel.ALIGN_LEFT, Panel.ALIGN_BOTTOM,  new Color(0x3b7d86));
		} else {
			player2Panel.drawString("Ready.", Panel.ALIGN_LEFT, Panel.ALIGN_TOP, new Color(0x3b7d86));
			player2Panel.drawString("Waiting for Player 1.", Panel.ALIGN_LEFT, Panel.ALIGN_BOTTOM);
			
		}
		
		objectList.add(player1Object);
		objectList.add(player2Object);
		
		objectList.add(player1Panel);
		objectList.add(player2Panel);
	
	}
		
	@Override
	public void onKeyPressed(KeyEvent keyEvent) {
		
	}

	@Override
	public void onKeyReleased(KeyEvent keyEvent) {
		int keyCode = keyEvent.getKeyCode();
		
		try {
			switch(keyCode){
				case 65: //a
					player1.getTurnInfo().setMove(Player.ATTACK);
					break;
				case 83: //s
					player1.getTurnInfo().setMove(Player.BLOCK);
					break;
				case 68: //d
					player1.getTurnInfo().setMove(Player.SPECIAL_ATTACK);
					break;
				case 74: //j
					player2.getTurnInfo().setMove(Player.ATTACK);
					break;
				case 75: //k
					player2.getTurnInfo().setMove(Player.BLOCK);
					break;
				case 76: //l
					player2.getTurnInfo().setMove(Player.SPECIAL_ATTACK);
					break;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		if(player1.getTurnInfo().getMove() != Player.NOT_SELECT && player2.getTurnInfo().getMove() != Player.NOT_SELECT){
			setCompleted();			
		}
		
	}

	@Override
	public void onKeyTyped(KeyEvent keyEvent) {
		
	}
	
}
