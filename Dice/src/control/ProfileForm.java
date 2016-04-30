package control;

import java.awt.event.KeyEvent;
import java.util.ArrayList;

import boundary.Background;
import boundary.GameObject;
import boundary.ProfileTextField;
import entity.Player;

/**
 * The ProfileForm class is the form for players 
 * to create profiles 
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
	
	/**
	 * The ProfileForm constructor initializes its properties
	 * @param player1 the Player object of the first player
	 * @param player2 the Player object of the second player
	 * @param objectList the ArrayList of all game objects
	 */
	public ProfileForm(Player player1, Player player2, ArrayList<GameObject> objectList){
		
		this.player1 = player1;
		this.player2 = player2;
		this.objectList = objectList;
		this.background = new Background("create_profiles.png");
		this.completed = false;
		
		createNewProfileFor(this.player1);
		
	}
	
	 /**
	  * Render the profile form
	  */
	public void render(){
		
		objectList.add(background);
		
		profileTextField = new ProfileTextField();
		profileTextField.drawUsername(currentPlayer.getNumber(), currentText);
		objectList.add(profileTextField);		
	}
	
	 /**
	 * createNewProfileFor creates a new profile for a player
	 *  
	 * @param player - the desired player to create profile for
	 */
	public void createNewProfileFor(Player player){
		this.currentText = "";
		this.currentPlayer = player;
	}
	
	 /**
	  * Returns true when both players complete the profiles
	  */
	public boolean isCompleted(){
		return completed;
	}
	
	 /**
	  * Set completed when two players create profiles successfully
	  */
	private void setCompleted(){
		completed = true;
	}
	
	@Override
	public void onKeyPressed(KeyEvent keyEvent) {
		// TODO Auto-generated method stub
		
	}
	
	 /**
	 *  onKeyReleased listens to input key when creating profiles 
	 *  
	 * @param keyEvent - keyEvent object
	 */
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
	}
}
