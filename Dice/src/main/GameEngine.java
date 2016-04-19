package main;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JFrame;

import boundary.GameCanvas;
import control.GameController;

/**
 * The GameEngine class is simply a starter of the game.
 * 
 * @author Thien Duc Phung
 * @author Minh Loi
 * @author Daniel Enriquez
 * @author Brett Bauman
 * @author Tanner Siffren
 */

public class GameEngine {
	
	public static void main(String[] args) {
	
		JFrame gameFrame = new JFrame("Fighting Dice");	
		gameFrame.setSize(new Dimension(GameCanvas.WIDTH, GameCanvas.HEIGHT));
		gameFrame.setResizable(false);
		gameFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		GameCanvas gameCanvas = new GameCanvas();
		gameFrame.add(gameCanvas);
		gameFrame.pack();
		gameFrame.setLocationRelativeTo(null);
		gameFrame.setVisible(true);
		
		gameCanvas.render();
					
	}

}
