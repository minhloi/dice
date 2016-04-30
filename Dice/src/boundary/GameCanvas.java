package boundary;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.JPanel;
import javax.swing.Timer;

import control.GameController;

/**
 * The GameCanvas class is use for creating the entire game screen
 * 
 * @author Thien Duc Phung
 * @author Minh Loi
 * @author Daniel Enriquez
 * @author Brett Bauman
 * @author Tanner Siffren
 */
@SuppressWarnings("serial")
public class GameCanvas extends JPanel {
	
	// Game screen size
	public static final int WIDTH = 1024;
	public static final int HEIGHT = 650;
	
	// Timer every round of games
	public static final int TIMER = 25; // in ms
	
	private GameController gameController;
	private ArrayList<GameObject> objectList;
	private Timer timer;
	
	// Create the game screen 
	public GameCanvas(){
		
		setBackground(Color.WHITE);
		setPreferredSize(new Dimension(WIDTH, HEIGHT));
		setFocusable(true);
		
		objectList = new ArrayList<GameObject>();
		gameController = new GameController(objectList);
		timer = new Timer(TIMER, new GameLoop());
	}
	
	public void render(){
		
		// Load data
		gameController.init();
		
		// Add game listener
		addKeyListener(new CanvasKeyListener());
		
		// Start timer
		timer.start();
					
	}
	
	// Paint method to paint the background of the game screen
	public void paintComponent(Graphics graphics){
		
		super.paintComponent(graphics);
		
		Iterator<GameObject> iterator = objectList.iterator();
		while(iterator.hasNext()){
			GameObject object = iterator.next();
			graphics.drawImage(object.getImage(), object.getPositionX(), object.getPositionY(), null);
		}
		
		objectList.clear();
	}
		
	private class GameLoop implements ActionListener{
		public void actionPerformed(ActionEvent event){
			gameController.renderCurrentState();
			repaint();
		}
	}
	
	// Key methods for actions picking between two players
	private class CanvasKeyListener implements KeyListener{

		@Override
		public void keyPressed(KeyEvent keyEvent) {
			gameController.getCurrentStateObject().onKeyPressed(keyEvent);
		}

		@Override
		public void keyReleased(KeyEvent keyEvent) {
			gameController.getCurrentStateObject().onKeyReleased(keyEvent);
		}

		@Override
		public void keyTyped(KeyEvent keyEvent) {
			gameController.getCurrentStateObject().onKeyTyped(keyEvent);
		}
	}
}