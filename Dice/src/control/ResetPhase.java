package control;

import java.util.Scanner;

import entity.Player;

/**
 * ResetPhase class - Reset each players' moves
 * 
 * @author Thien Duc Phung
 * @author Minh Loi
 * @author Daniel Enriquez
 * @author Brett Bauman
 * @author Tanner Siffren
 */

public class ResetPhase extends Phase{
	
	private Player player1;
	private Player player2;

	/**
	 * Contructor - Prepare player1 and player2 objects 
	 * 
	 * @param player1 - Player object #1
	 * @param player2 - Player object #2
	 */
	public ResetPhase(Player player1, Player player2){
		this.player1 = player1;
		this.player2 = player2;
	}
	
	/**
	 * render - Render resetPhase which resets each of the players moves
	 */
	public void render(){
		player1.resetMove();
		player2.resetMove();
	}
}
