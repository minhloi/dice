package control;

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
		
		if(player1.getMove() != Player.NOT_SELECT && player2.getMove() != Player.NOT_SELECT){
			setCompleted();			
		} else {
			
			Panel player1SelectPanel = new Panel(1, Turn.PANEL_1_POSITION_X, Turn.PANEL_1_POSITION_Y);
			Panel player2SelectPanel = new Panel(2, Turn.PANEL_2_POSITION_X, Turn.PANEL_2_POSITION_Y);
			
			if(player1.getMove() == Player.NOT_SELECT){
				player1SelectPanel.setState(Panel.SELECTING);
			} else {
				player1SelectPanel.setState(Panel.READY);
			}
			
			if(player2.getMove() == Player.NOT_SELECT){
				player2SelectPanel.setState(Panel.SELECTING);
			} else {
				player2SelectPanel.setState(Panel.READY);
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
		
		if(player1.getMove() != Player.NOT_SELECT && player2.getMove() != Player.NOT_SELECT){
			setCompleted();			
		}
		
	}

	@Override
	public void onKeyTyped(KeyEvent keyEvent) {
		
	}
	
}
