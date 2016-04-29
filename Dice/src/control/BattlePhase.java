package control;

import java.awt.event.KeyEvent;
import java.util.ArrayList;

import boundary.DiceObject;
import boundary.GameObject;
import boundary.Panel;
import boundary.PlayerObject;
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
public class BattlePhase extends Phase {
	
	private Player player1;
	private Player player2;
	private PlayerObject player1Object;
	private PlayerObject player2Object;
	
	private int currentState;
	private Panel winnerPanel;
	private DiceObject winnerDiceObject;
	private boolean loserDead;
	
	public static final int ROLLING = 0;
	public static final int RUNNING_TOWARDS_OPPONENT = 1;
	public static final int ATTACKING = 2;
	public static final int RETURNING = 3;
	
	/**
	 * The class constructor initializes rollWinner and rollLoser objects.
	 */
	private ArrayList<GameObject> objectList;
	
	public BattlePhase(Player player1, Player player2, PlayerObject player1Object, PlayerObject player2Object, ArrayList<GameObject> objectList){
		this.player1 = player1;
		this.player2 = player2;
		this.player1Object = player1Object;
		this.player2Object = player2Object;
		this.objectList = objectList;
		this.loserDead = false;
		this.currentState = ROLLING;
		
	}	
	
	/**
	 * render - Render all actions in the battle phase. 
	 */ 
	public void render(){
		
		if(currentState == ROLLING){
			
			getTurnWinner().getDice().roll();
			
			player1Object.setIdle();
			player2Object.setIdle();
		
		} else if(currentState == RUNNING_TOWARDS_OPPONENT) {

			boolean completed = runTowardsOpponent();
			if(completed == true){
				++currentState;
			}
			
		} else if(currentState == ATTACKING){
			boolean completed = getTurnWinnerObject().attack();
			if(completed == true){
				try {
					calculateDamage(getTurnWinner().getDice().getCurrent());
				} catch (Exception e) {
					e.printStackTrace();
				}
				++currentState;
			}
			
		} else if(currentState == RETURNING){
			
			boolean completed = runBack();
			
			if(isLoserDead()){
				setLoserDeadPosition();
			} else if(hasWinner()) {
				loserDying();
			}
			
			if(completed == true){
				setCompleted();
			}
		}
				
		renderWinnerPanel();
		renderWinnerDiceObject();
		
		objectList.add(winnerPanel);
		objectList.add(winnerDiceObject);
											
	}
	
	private boolean runTowardsOpponent(){
		
		boolean completed;
		if(player1.getTurnInfo().isTurnWinner()){
			completed = player1Object.runRight(PlayerObject.FRONT_OF_PLAYER2);
		} else {
			completed = player2Object.runLeft(PlayerObject.FRONT_OF_PLAYER1);
		}
		return completed;
		
	}
	
	private boolean runBack(){
		
		boolean completed;
		if(player1.getTurnInfo().isTurnWinner()){
			completed = player1Object.runLeft(PlayerObject.PLAYER1_DEFAULT_POSITION_X);
		} else {
			completed = player2Object.runRight(PlayerObject.PLAYER2_DEFAULT_POSITION_X);
		}
		return completed;
		
	}
	
	private boolean hasWinner(){
		boolean hasWinner = false;
		if(getTurnLoser().getHealth() <= 0){
			hasWinner = true;
		}
		return hasWinner;
	}
	
	private void loserDying(){
		if(getTurnLoser().getNumber() == 1){
			loserDead = player1Object.dying();
		} else {
			loserDead = player2Object.dying();
		}
	}
	
	private boolean isLoserDead(){
		return loserDead;
	}
	
	private void setLoserDeadPosition(){
		if(getTurnLoser().getNumber() == 1){
			player1Object.setDead();
		} else {
			player2Object.setDead();
		}
	}
	
	private Player getTurnLoser(){
		Player turnLoser;
		if(!player1.getTurnInfo().isTurnWinner()){
			turnLoser = player1;
		} else {
			turnLoser = player2;
		}
		return turnLoser;
	}
	
	private Player getTurnWinner(){
		Player turnWinner;
		if(player1.getTurnInfo().isTurnWinner()){
			turnWinner = player1;
		} else {
			turnWinner = player2;
		}
		return turnWinner;
	}
	
	private PlayerObject getTurnWinnerObject(){
		PlayerObject turnWinnerObject;
		if(player1.getTurnInfo().isTurnWinner()){
			turnWinnerObject = player1Object;
		} else {
			turnWinnerObject = player2Object;
		}
		return turnWinnerObject;
	}
	
	private void renderWinnerPanel(){
		
		if(player1.getTurnInfo().isTurnWinner()){
			winnerPanel = new Panel(Panel.PANEL_1_POSITION_X, Panel.PANEL_1_POSITION_Y);
			if(currentState == ROLLING){
				winnerPanel.drawString("Press E to stop.", Panel.ALIGN_LEFT, Panel.ALIGN_TOP);
			} else {
				winnerPanel.drawString("Opponent takes" , Panel.ALIGN_LEFT, Panel.ALIGN_TOP);
				winnerPanel.drawString(getDamageRatioInString() + " damage." , Panel.ALIGN_LEFT, Panel.ALIGN_BOTTOM);
			}
			
		} else {
			winnerPanel = new Panel(Panel.PANEL_2_POSITION_X, Panel.PANEL_2_POSITION_Y);
			if(currentState == ROLLING){
				winnerPanel.drawString("Press U to stop.", Panel.ALIGN_LEFT, Panel.ALIGN_TOP);
			} else {
				winnerPanel.drawString("Opponent takes" , Panel.ALIGN_LEFT, Panel.ALIGN_TOP);
				winnerPanel.drawString(getDamageRatioInString() + " damage." , Panel.ALIGN_LEFT, Panel.ALIGN_BOTTOM);
			}
		}
				
	}
	
	private void renderWinnerDiceObject(){
		
		if(player1.getTurnInfo().isTurnWinner()){
			winnerDiceObject = new DiceObject(DiceObject.DICE1_POSITION_X, DiceObject.DICE1_POSITION_Y );
		} else {
			winnerDiceObject = new DiceObject(DiceObject.DICE2_POSITION_X, DiceObject.DICE2_POSITION_Y );
		}
		
		winnerDiceObject.setImageByDiceNum(getTurnWinner().getDice().getCurrent());
				
	}
	
	private float getDamageRatio(){
		
		Player turnWinner = getTurnWinner();
		Player turnLoser = getTurnLoser();
		
		float damageRatio = 1 ;
		
		// CASE 1: Winner selected ATTACK.
		if (turnWinner.getTurnInfo().getMove() == Player.ATTACK) {
			
			// Loser selected ATTACK or SPECIAL_ATTACK takes full damage.
			if (turnLoser.getTurnInfo().getMove() == Player.ATTACK || turnLoser.getTurnInfo().getMove() == Player.SPECIAL_ATTACK) {
				
				damageRatio = 1;
			
			// Loser selected BLOCK takes half damage.
			} else if (turnLoser.getTurnInfo().getMove() == Player.BLOCK) {
				
				damageRatio = 1/2;			
			
			}
			
		// CASE 2: Winner selected BLOCK.	
		} else if (turnWinner.getTurnInfo().getMove() == Player.BLOCK) {
			
			// Loser selected ATTACK or SPECIAL_ATTACK takes half damage.
			if (turnLoser.getTurnInfo().getMove() == Player.ATTACK || turnLoser.getTurnInfo().getMove() == Player.SPECIAL_ATTACK) {
				
				damageRatio = 1/2;
				
			// Loser selected BLOCK takes a quarter of damage.
			} else if (turnLoser.getTurnInfo().getMove() == Player.BLOCK) {
				
				damageRatio = 1/4;
								
			}
		

		// CASE 3: Winner selected SPECIAL_ATTACK.	
		} else if (turnWinner.getTurnInfo().getMove() == Player.SPECIAL_ATTACK) {
			
			// Loser selected ATTACK or SPECIAL_ATTACK takes doubled damage.
			if (turnLoser.getTurnInfo().getMove() == Player.ATTACK || turnLoser.getTurnInfo().getMove() == Player.SPECIAL_ATTACK) {
						
				damageRatio = 2;
				
			// Loser selected BLOCK takes full normal damage.
			} else if (turnLoser.getTurnInfo().getMove() == Player.BLOCK) {
				
				damageRatio = 1;
				
			}
		
		}
		
		return damageRatio;
		
	}
	
	private String getDamageRatioInString(){
		String ratio = "";
		if( getDamageRatio()== (float)1 ){
			ratio = "full";
		} else if( getDamageRatio()== (float)1/2 ){
			ratio = "half";
		} else if( getDamageRatio()== (float)1/4 ){
			ratio = "1/4";
		} else if( getDamageRatio()== (float)2 ){
			ratio = "double";
		}
		return ratio;
	}
		
	/**
	 * calculateDamage - Calculate damage dealt to rollLoser
	 */
	private void calculateDamage(int initialDamage) {
		
		Player turnLoser = getTurnLoser();
		
		int damage = (int) Math.ceil( getDamageRatio() * (float) initialDamage);
		turnLoser.setHealth(turnLoser.getHealth() - damage);
	}
	
	@Override
	public void onKeyPressed(KeyEvent keyEvent) {
	}

	@Override
	public void onKeyReleased(KeyEvent keyEvent) {
		int keyCode = keyEvent.getKeyCode();
		
		if(currentState == ROLLING){
			if(player1.getTurnInfo().isTurnWinner() && keyCode == 69){
				currentState++;
			} else if(player2.getTurnInfo().isTurnWinner() && keyCode == 85){
				currentState++;
			}
		}
				
	}

	@Override
	public void onKeyTyped(KeyEvent keyEvent) {
	}

}
