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
	private Player rollWinner;
	private Player rollLoser;
	private int winnerCurrentDice;
	private boolean winnerDiceStopped;
	
	private ArrayList<GameObject> objectList;
	
	
	public BattlePhase(Player player1, Player player2, ArrayList<GameObject> objectList){
		this.player1 = player1;
		this.player2 = player2;
		this.objectList = objectList;
		winnerDiceStopped = false;
		
		if(player1.getTurnInfo().isTurnWinner()){
			rollWinner = player1;
			rollLoser = player2;
		} else {
			rollWinner = player2;
			rollLoser = player1;
		}
		
	}
	
	public void render(){
		
		Panel winnerPanel;
		DiceObject winnerDice;
		
		if(player1.getNumber() == 1){
			winnerPanel = new Panel(Panel.PANEL_1_POSITION_X, Panel.PANEL_1_POSITION_Y);
			winnerDice = new DiceObject(DiceObject.DICE1_POSITION_X, DiceObject.DICE1_POSITION_Y );
		} else {
			winnerPanel = new Panel(Panel.PANEL_2_POSITION_X, Panel.PANEL_2_POSITION_Y);
			winnerDice = new DiceObject(DiceObject.DICE2_POSITION_X, DiceObject.DICE2_POSITION_Y );
		}
		
		if(winnerDiceStopped == false){
			winnerCurrentDice = rollWinner.getDice().roll();
		}
		
		objectList.add(winnerPanel);
		objectList.add(winnerDice);
											
	}
	
	/**
	 * Method to calculate damage dealt to other player
	 * @throws Exception exception throws when either players has not selected their move.
	 */
	private void calculateDamage(int initialDamage) throws Exception {
		
		if(rollWinner.getTurnInfo().getMove() == Player.NOT_SELECT || rollLoser.getTurnInfo().getMove() == Player.NOT_SELECT) {
			throw new Exception("One of the players have not selected move");
		}
		
		// CASE 1: Winner selected ATTACK.
		if (rollWinner.getTurnInfo().getMove() == Player.ATTACK) {
			
			// Loser selected ATTACK or SPECIAL_ATTACK takes full damage.
			if (rollLoser.getTurnInfo().getMove() == Player.ATTACK || rollLoser.getTurnInfo().getMove() == Player.SPECIAL_ATTACK) {
				
				int damage = initialDamage;
				// Set damage.
				rollLoser.setHealth(rollLoser.getHealth() - damage);
				// Print damage.
				System.out.println("Therefore, player " + rollLoser.getNumber() + " takes " + damage + " damage (full damage).");
			
			// Loser selected BLOCK takes half damage.
			} else if (rollLoser.getTurnInfo().getMove() == Player.BLOCK) {
				
				int damage = (int) Math.ceil(initialDamage * (float) 1/2);
				// Set damage.
				rollLoser.setHealth(rollLoser.getHealth() - damage);
				// Print damage.
				System.out.println("Therefore, player " + rollLoser.getNumber() + " takes " + damage + " damage (half damage).");
								
			}
			
		// CASE 2: Winner selected BLOCK.	
		} else if (rollWinner.getTurnInfo().getMove() == Player.BLOCK) {
			
			// Loser selected ATTACK or SPECIAL_ATTACK takes half damage.
			if (rollLoser.getTurnInfo().getMove() == Player.ATTACK || rollLoser.getTurnInfo().getMove() == Player.SPECIAL_ATTACK) {
				
				int damage = (int) Math.ceil(initialDamage * (float) 1/2);
				// Set damage.
				rollLoser.setHealth(rollLoser.getHealth() - damage);
				// Print damage.
				System.out.println("Therefore, player " + rollLoser.getNumber() + " takes " + (damage) + " damage (half damage).");
			
			// Loser selected BLOCK takes a quarter of damage.
			} else if (rollLoser.getTurnInfo().getMove() == Player.BLOCK) {
				
				int damage = (int) Math.ceil(initialDamage * (float) 1/4);
				// Set damage.
				rollLoser.setHealth(rollLoser.getHealth() - damage);
				// Print damage.
				System.out.println("Therefore, player " + rollLoser.getNumber() + " takes " + (damage) + " damage (1/4 damage).");
								
			}
		

		// CASE 3: Winner selected SPECIAL_ATTACK.	
		} else if (rollWinner.getTurnInfo().getMove() == Player.SPECIAL_ATTACK) {
			
			// Loser selected ATTACK or SPECIAL_ATTACK takes doubled damage.
			if (rollLoser.getTurnInfo().getMove() == Player.ATTACK || rollLoser.getTurnInfo().getMove() == Player.SPECIAL_ATTACK) {
						
				int damage = 2 * initialDamage;
				// Set damage.
				rollLoser.setHealth(rollLoser.getHealth() - damage);
				// Print damage.
				System.out.println("Therefore, player " + rollLoser.getNumber() + " takes " + damage + " damage (doubled damage).");
			
			// Loser selected BLOCK takes full normal damage.
			} else if (rollLoser.getTurnInfo().getMove() == Player.BLOCK) {
				
				int damage = initialDamage;
				// Set damage.
				rollLoser.setHealth(rollLoser.getHealth() - damage);
				// Print damage.
				System.out.println("Therefore, player " + rollLoser.getNumber() + " takes " + damage + " damage (normal damage).");
								
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
		
		if(rollWinner.getNumber() == 1 && keyCode == 87){
			winnerDiceStopped = true;
		} else if(rollWinner.getNumber() == 2 && keyCode == 73){
			winnerDiceStopped = true;
		}
				
	}

	@Override
	public void onKeyTyped(KeyEvent keyEvent) {
		// TODO Auto-generated method stub
		
	}

}