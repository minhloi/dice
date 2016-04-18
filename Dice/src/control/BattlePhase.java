package control;

import java.awt.event.KeyEvent;
import java.util.ArrayList;

import boundary.DiceObject;
import boundary.GameObject;
import boundary.Panel;
import boundary.PlayerObject;
import entity.Player;

public class BattlePhase extends Phase {
	
	private Player player1;
	private Player player2;
	private PlayerObject player1Object;
	private PlayerObject player2Object;
	
	private int currentState;
	private Panel winnerPanel;
	private DiceObject winnerDiceObject;
	private int winnerCurrentDice;
	
	public static final int ROLLING = 0;
	public static final int RUNNING_TOWARDS_OPPONENT = 1;
	public static final int ATTACKING = 2;
	public static final int RETURNING = 3;
	
	private ArrayList<GameObject> objectList;
	
	public BattlePhase(Player player1, Player player2, PlayerObject player1Object, PlayerObject player2Object, ArrayList<GameObject> objectList){
		this.player1 = player1;
		this.player2 = player2;
		this.player1Object = player1Object;
		this.player2Object = player2Object;
		this.objectList = objectList;
		
		this.currentState = ROLLING;
		
	}	
	
	public void render(){
		
		if(currentState == ROLLING){
			
			winnerCurrentDice = getTurnWinner().getDice().roll();
			
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
				++currentState;
			}
			
		} else if(currentState == RETURNING){
			boolean completed = runBack();
			if(completed == true){
				setCompleted();
			}
		}
				
		renderWinnerPanel();
		renderWinnerDiceObject();
				
		objectList.add(player1Object);
		objectList.add(player2Object);
		
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
			winnerPanel.drawString("Press W to stop.", Panel.ALIGN_LEFT, Panel.ALIGN_TOP);
			winnerDiceObject = new DiceObject(DiceObject.DICE1_POSITION_X, DiceObject.DICE1_POSITION_Y );
		} else {
			winnerPanel = new Panel(Panel.PANEL_2_POSITION_X, Panel.PANEL_2_POSITION_Y);
			winnerPanel.drawString("Press I to stop.", Panel.ALIGN_LEFT, Panel.ALIGN_TOP);
			winnerDiceObject = new DiceObject(DiceObject.DICE2_POSITION_X, DiceObject.DICE2_POSITION_Y );
		}
				
	}
	
	private void renderWinnerDiceObject(){
		
		if(player1.getTurnInfo().isTurnWinner()){
			winnerDiceObject = new DiceObject(DiceObject.DICE1_POSITION_X, DiceObject.DICE1_POSITION_Y );
		} else {
			winnerDiceObject = new DiceObject(DiceObject.DICE2_POSITION_X, DiceObject.DICE2_POSITION_Y );
		}
		
		winnerDiceObject.setImageByDiceNum(winnerCurrentDice);
				
	}
		
	/**
	 * Method to calculate damage dealt to other player
	 * @throws Exception exception throws when either players has not selected their move.
	 */
	private void calculateDamage(int initialDamage) throws Exception {
		
		Player turnWinner = getTurnWinner();
		Player turnLoser = getTurnLoser();
		
		if(turnWinner.getTurnInfo().getMove() == Player.NOT_SELECT || turnLoser.getTurnInfo().getMove() == Player.NOT_SELECT) {
			throw new Exception("One of the players have not selected move");
		}
		
		// CASE 1: Winner selected ATTACK.
		if (turnWinner.getTurnInfo().getMove() == Player.ATTACK) {
			
			// Loser selected ATTACK or SPECIAL_ATTACK takes full damage.
			if (turnLoser.getTurnInfo().getMove() == Player.ATTACK || turnLoser.getTurnInfo().getMove() == Player.SPECIAL_ATTACK) {
				
				int damage = initialDamage;
				// Set damage.
				turnLoser.setHealth(turnLoser.getHealth() - damage);
				// Print damage.
				System.out.println("Therefore, player " + turnLoser.getNumber() + " takes " + damage + " damage (full damage).");
			
			// Loser selected BLOCK takes half damage.
			} else if (turnLoser.getTurnInfo().getMove() == Player.BLOCK) {
				
				int damage = (int) Math.ceil(initialDamage * (float) 1/2);
				// Set damage.
				turnLoser.setHealth(turnLoser.getHealth() - damage);
				// Print damage.
				System.out.println("Therefore, player " + turnLoser.getNumber() + " takes " + damage + " damage (half damage).");
								
			}
			
		// CASE 2: Winner selected BLOCK.	
		} else if (turnWinner.getTurnInfo().getMove() == Player.BLOCK) {
			
			// Loser selected ATTACK or SPECIAL_ATTACK takes half damage.
			if (turnLoser.getTurnInfo().getMove() == Player.ATTACK || turnLoser.getTurnInfo().getMove() == Player.SPECIAL_ATTACK) {
				
				int damage = (int) Math.ceil(initialDamage * (float) 1/2);
				// Set damage.
				turnLoser.setHealth(turnLoser.getHealth() - damage);
				// Print damage.
				System.out.println("Therefore, player " + turnLoser.getNumber() + " takes " + (damage) + " damage (half damage).");
			
			// Loser selected BLOCK takes a quarter of damage.
			} else if (turnLoser.getTurnInfo().getMove() == Player.BLOCK) {
				
				int damage = (int) Math.ceil(initialDamage * (float) 1/4);
				// Set damage.
				turnLoser.setHealth(turnLoser.getHealth() - damage);
				// Print damage.
				System.out.println("Therefore, player " + turnLoser.getNumber() + " takes " + (damage) + " damage (1/4 damage).");
								
			}
		

		// CASE 3: Winner selected SPECIAL_ATTACK.	
		} else if (turnWinner.getTurnInfo().getMove() == Player.SPECIAL_ATTACK) {
			
			// Loser selected ATTACK or SPECIAL_ATTACK takes doubled damage.
			if (turnLoser.getTurnInfo().getMove() == Player.ATTACK || turnLoser.getTurnInfo().getMove() == Player.SPECIAL_ATTACK) {
						
				int damage = 2 * initialDamage;
				// Set damage.
				turnLoser.setHealth(turnLoser.getHealth() - damage);
				// Print damage.
				System.out.println("Therefore, player " + turnLoser.getNumber() + " takes " + damage + " damage (doubled damage).");
			
			// Loser selected BLOCK takes full normal damage.
			} else if (turnLoser.getTurnInfo().getMove() == Player.BLOCK) {
				
				int damage = initialDamage;
				// Set damage.
				turnLoser.setHealth(turnLoser.getHealth() - damage);
				// Print damage.
				System.out.println("Therefore, player " + turnLoser.getNumber() + " takes " + damage + " damage (normal damage).");
								
			}
		
		}
		
	}

	@Override
	public void onKeyPressed(KeyEvent keyEvent) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onKeyReleased(KeyEvent keyEvent) {
		int keyCode = keyEvent.getKeyCode();
		
		if(player1.getTurnInfo().isTurnWinner() && keyCode == 87){
			currentState++;
		} else if(player2.getTurnInfo().isTurnWinner() && keyCode == 73){
			currentState++;
		}
				
	}

	@Override
	public void onKeyTyped(KeyEvent keyEvent) {
		// TODO Auto-generated method stub
		
	}

}