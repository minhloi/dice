package control;

import java.awt.event.KeyEvent;
import java.util.ArrayList;

import boundary.Background;
import boundary.GameObject;
import entity.Player;

public class ProfileForm implements Listenable {
	
	private Player player1;
	private Player player2;
	private Background background;
	private ArrayList<GameObject> objectList;
	
	public ProfileForm(Player player1, Player player2, ArrayList<GameObject> objectList){
		
		this.player1 = player1;
		this.player2 = player2;
		this.objectList = objectList;
		this.background = new Background("main_background.png");
		
	}
	
	public void render(){
		
		objectList.add(background);
				
	}

	@Override
	public void onKeyPressed(KeyEvent keyEvent) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onKeyReleased(KeyEvent keyEvent) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onKeyTyped(KeyEvent keyEvent) {
		// TODO Auto-generated method stub
		
	}
}
