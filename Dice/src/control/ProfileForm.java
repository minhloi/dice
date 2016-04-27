package control;

import java.awt.event.KeyEvent;
import java.util.ArrayList;

import boundary.Background;
import boundary.GameObject;
import boundary.ProfileTextField;
import entity.Player;

public class ProfileForm implements Listenable {
	
	private Player player1;
	private Player player2;
	private Background background;
	private ArrayList<GameObject> objectList;
	private ProfileTextField profileTextField;
	private Player currentPlayer;
	private String currentText;
	private boolean completed;
	
	public ProfileForm(Player player1, Player player2, ArrayList<GameObject> objectList){
		
		this.player1 = player1;
		this.player2 = player2;
		this.objectList = objectList;
		this.background = new Background("main_background.png");
		this.profileTextField = new ProfileTextField();
		this.completed = false;
		
		createProfileFor(player1);
		
	}
	
	public void render(){
		
		objectList.add(background);
		
		profileTextField.drawUsername(currentPlayer.getNumber(), currentText);
		objectList.add(profileTextField);		
	}
	
	public void createProfileFor(Player player){
		this.currentText = "";
		this.currentPlayer = player;
	}

	public boolean isCompleted(){
		return completed;
	}
	
	private void setCompleted(){
		completed = true;
	}
	
	@Override
	public void onKeyPressed(KeyEvent keyEvent) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onKeyReleased(KeyEvent keyEvent) {
		int keycode = keyEvent.getKeyCode();
		switch (keycode){
			case KeyEvent.VK_ENTER:
				if(currentText != ""){
					currentPlayer.setUsername(currentText);
					if(currentPlayer.getNumber() == 1){
						createProfileFor(player2);
					} else if(currentPlayer.getNumber() == 2){
						setCompleted();
					}
				}
				break;
				
			case KeyEvent.VK_BACK_SPACE:
			case KeyEvent.VK_DELETE:
				if(currentText != ""){
					currentText = currentText.substring(0, currentText.length()-1);
				}
				break;
			
			default:
				currentText = currentText + (char)keycode;
		}
				
	}

	@Override
	public void onKeyTyped(KeyEvent keyEvent) {
		// TODO Auto-generated method stub
		
	}
}
