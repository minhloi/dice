package control;

import java.util.Scanner;

import entity.Player;

public class ResetPhase extends Phase{
	
	private Player player1;
	private Player player2;

	public ResetPhase(Player player1, Player player2){
		this.player1 = player1;
		this.player2 = player2;
	}
	
	public void render(){
		player1.resetMove();
		player2.resetMove();
	}
}
