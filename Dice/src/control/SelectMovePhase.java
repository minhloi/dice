package control;

import java.awt.Color;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import boundary.GameCanvas;
import boundary.GameObject;
import boundary.Panel;
import entity.Player;

public class SelectMovePhase extends Phase {
	
	private Player player1;
	private Player player2;
	private ArrayList<GameObject> objectList;
	
	// Player move-set definition
	public static final char[] PLAYER1_MOVE_SET = {'a', 's', 'd'};
	public static final char[] PLAYER2_MOVE_SET = {'j', 'k', 'l'};
	
	public SelectMovePhase(Player player1, Player player2, ArrayList<GameObject> objectList){
		this.player1 = player1;
		this.player2 = player2;
		this.objectList = objectList;
		
	}
	
	public void render(){
		
		Panel player1Panel = new Panel(Panel.PANEL_1_POSITION_X, Panel.PANEL_1_POSITION_Y);
		Panel player2Panel = new Panel(Panel.PANEL_2_POSITION_X, Panel.PANEL_2_POSITION_Y);
		
		if(player1.getMove() == Player.NOT_SELECT){
			player1Panel.drawString("Press a key to select move.", Panel.ALIGN_LEFT, Panel.ALIGN_TOP);
			player1Panel.drawString(PLAYER1_MOVE_SET[Player.ATTACK] + ": atk  " + PLAYER1_MOVE_SET[Player.BLOCK] + ": block  " + PLAYER1_MOVE_SET[Player.SPECIAL_ATTACK] + ": special atk" , Panel.ALIGN_LEFT, Panel.ALIGN_BOTTOM, new Color(0x3b7d86));
		} else {
			player1Panel.drawString("Ready.", Panel.ALIGN_LEFT, Panel.ALIGN_TOP, new Color(0x3b7d86));
			player1Panel.drawString("Waiting for Player 2.", Panel.ALIGN_LEFT, Panel.ALIGN_BOTTOM);
		}
		
		if(player2.getMove() == Player.NOT_SELECT){
			player2Panel.drawString("Press a key to select move.", Panel.ALIGN_LEFT, Panel.ALIGN_TOP);
			player2Panel.drawString(PLAYER2_MOVE_SET[Player.ATTACK] + ": atk  " + PLAYER2_MOVE_SET[Player.BLOCK] + ": block  " + PLAYER2_MOVE_SET[Player.SPECIAL_ATTACK] + ": special atk" , Panel.ALIGN_LEFT, Panel.ALIGN_BOTTOM,  new Color(0x3b7d86));
		} else {
			player2Panel.drawString("Ready.", Panel.ALIGN_LEFT, Panel.ALIGN_TOP, new Color(0x3b7d86));
			player2Panel.drawString("Waiting for Player 1.", Panel.ALIGN_LEFT, Panel.ALIGN_BOTTOM);
			
		}
		
		objectList.add(player1Panel);
		objectList.add(player2Panel);
	
	}
		
	@Override
	public void onKeyPressed(KeyEvent keyEvent) {
		
	}

	@Override
	public void onKeyReleased(KeyEvent keyEvent) {
		int keyCode = keyEvent.getKeyCode();
		switch(keyCode){
			case 65: //a
				player1.setMove(Player.ATTACK);
				break;
			case 83: //s
				player1.setMove(Player.BLOCK);
				break;
			case 68: //d
				player1.setMove(Player.SPECIAL_ATTACK);
				break;
			case 74: //j
				player2.setMove(Player.ATTACK);
				break;
			case 75: //k
				player2.setMove(Player.BLOCK);
				break;
			case 76: //l
				player2.setMove(Player.SPECIAL_ATTACK);
				break;
		}
		
		if(player1.getMove() != Player.NOT_SELECT && player2.getMove() != Player.NOT_SELECT){
			setCompleted();			
		}
		
	}

	@Override
	public void onKeyTyped(KeyEvent keyEvent) {
		
	}
	
}
