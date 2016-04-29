package control;

import java.awt.event.KeyEvent;
import java.util.ArrayList;

import boundary.Background;
import boundary.GameObject;
import boundary.ProfileTextField;
import entity.Player;

/**
 * The BattlePhase class demonstates a phase of a match, where the rollWinner
 * causes damage to the rollLoser.
 * 
 * @author Thien Duc Phung
 * @author Minh Loi
 * @author Daniel Enriquez
 * @author Brett Bauman
 * @author Tanner Siffren
 */

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
		this.background = new Background("create_profiles.png");
		this.completed = false;
		
		createNewProfileFor(this.player1);
		
	}
	
	public void render(){
		
		objectList.add(background);
		
		profileTextField = new ProfileTextField();
		profileTextField.drawUsername(currentPlayer.getNumber(), currentText);
		objectList.add(profileTextField);		
	}
	
	public void createNewProfileFor(Player player){
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
					currentPlayer.setUsername(currentText.trim());
					if(currentPlayer.getNumber() == 1){
						createNewProfileFor(player2);
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
				if(keycode >= 65 && keycode <= 90 || keycode == KeyEvent.VK_SPACE)
					currentText = currentText + (char)keycode;
		}
				
	}

	@Override
	public void onKeyTyped(KeyEvent keyEvent) {
		// TODO Auto-generated method stub
		
	}
}
