package control;

import java.awt.event.KeyEvent;
import java.util.ArrayList;

import boundary.GameCanvas;
import boundary.GameObject;
import boundary.SelectPanel;
import entity.Player;

public class SelectMovePhase extends Phase {
	
	private Player player1;
	private Player player2;
	private ArrayList<GameObject> objectList;
	
	// Player move-set definition
	public static final char[] PLAYER1_MOVE_SET = {'a', 's', 'd'};
	public static final char[] PLAYER2_MOVE_SET = {'j', 'k', 'l'};
	
	public static final int PANEL_1_POSITION_X = 20;
	public static final int PANEL_1_POSITION_Y = GameCanvas.HEIGHT - SelectPanel.HEIGHT - 80;
	public static final int PANEL_2_POSITION_X = GameCanvas.WIDTH - SelectPanel.WIDTH - 20;
	public static final int PANEL_2_POSITION_Y = GameCanvas.HEIGHT - SelectPanel.HEIGHT - 80;
	
	public SelectMovePhase(Player player1, Player player2, ArrayList<GameObject> objectList){
		this.player1 = player1;
		this.player2 = player2;
		this.objectList = objectList;
		
	}
	
	public void render(){
		
		if(player1.getMove() != Player.NOT_SELECT && player2.getMove() != Player.NOT_SELECT){
			setCompleted();			
		} else {
			
			SelectPanel player1SelectPanel = new SelectPanel(1, PANEL_1_POSITION_X, PANEL_1_POSITION_Y);
			SelectPanel player2SelectPanel = new SelectPanel(2, PANEL_2_POSITION_X, PANEL_2_POSITION_Y);
			
			if(player1.getMove() == Player.NOT_SELECT){
				player1SelectPanel.setState(SelectPanel.SELECTING);
			} else {
				player1SelectPanel.setState(SelectPanel.READY);
			}
			
			if(player2.getMove() == Player.NOT_SELECT){
				player2SelectPanel.setState(SelectPanel.SELECTING);
			} else {
				player2SelectPanel.setState(SelectPanel.READY);
			}
			
			objectList.add(player1SelectPanel);
			objectList.add(player2SelectPanel);
			
		}	
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

	}

	@Override
	public void onKeyTyped(KeyEvent keyEvent) {
		
	}
	
}
