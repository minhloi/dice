package main;
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
		
		GameCanvas gameCanvas = new GameCanvas();
		gameFrame.add(gameCanvas);
		gameFrame.setVisible(true);
		
		gameCanvas.render();
		
		//GameController gameController = new GameController();
		
		// Load necessary data such as players' scores.
		//gameController.init();
		
		// Start by printing the menu first
		//gameController.setState(GameController.MENU_STATE);
		
	}

}
