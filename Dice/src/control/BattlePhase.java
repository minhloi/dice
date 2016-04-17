package control;

import java.awt.event.KeyEvent;
import java.util.ArrayList;

import boundary.DiceObject;
import boundary.GameObject;
import boundary.Panel;
import entity.Player;

public class BattlePhase extends Phase {
	
	private Player player1;
	private Player player2;
	private Player turnWinner;
	private Player turnLoser;
	
	private int winnerCurrentDice;
	private boolean winnerDiceStopped;
	
	private ArrayList<GameObject> objectList;
	
	public BattlePhase(Player player1, Player player2, ArrayList<GameObject> objectList){
		this.player1 = player1;
		this.player2 = player2;
		this.objectList = objectList;
		winnerDiceStopped = false;
		
	}	
	public void render(){
		
		Panel winnerPanel;
		DiceObject winnerDice;
		
		if(player1.getTurnInfo().isTurnWinner()){
			turnWinner = player1;
			turnLoser = player2;
		} else {
			turnWinner = player2;
			turnLoser = player1;
		}
		
		if(player1.getTurnInfo().isTurnWinner()){
			winnerPanel = new Panel(Panel.PANEL_1_POSITION_X, Panel.PANEL_1_POSITION_Y);
			winnerDice = new DiceObject(DiceObject.DICE1_POSITION_X, DiceObject.DICE1_POSITION_Y );
		} else {
			winnerPanel = new Panel(Panel.PANEL_2_POSITION_X, Panel.PANEL_2_POSITION_Y);
			winnerDice = new DiceObject(DiceObject.DICE2_POSITION_X, DiceObject.DICE2_POSITION_Y );
		}
		
		if(winnerDiceStopped == false){
			winnerCurrentDice = turnWinner.getDice().roll();
		}
		
		winnerDice.setImageByDiceNum(winnerCurrentDice);
		
		objectList.add(winnerPanel);
		objectList.add(winnerDice);
											
	}
	
	/**
	 * Method to calculate damage dealt to other player
	 * @throws Exception exception throws when either players has not selected their move.
	 */
	private void calculateDamage(int initialDamage) throws Exception {
		
		
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
			winnerDiceStopped = true;
		} else if(player2.getTurnInfo().isTurnWinner() && keyCode == 73){
			winnerDiceStopped = true;
		}
				
	}

	@Override
	public void onKeyTyped(KeyEvent keyEvent) {
		// TODO Auto-generated method stub
		
	}

}