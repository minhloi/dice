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
 * The GameCanvas class is used to render game objects
 * in a loop for the game
 * 
 * @author Thien Duc Phung
 * @author Minh Loi
 * @author Daniel Enriquez
 * @author Brett Bauman
 * @author Tanner Siffren
 */
@SuppressWarnings("serial")
public class GameCanvas extends JPanel {
	
	// Game window size
	public static final int WIDTH = 1024;
	public static final int HEIGHT = 650;
	
	// Timer used for the game loop
	public static final int TIMER = 25; // in ms
	
	private GameController gameController;
	private ArrayList<GameObject> objectList;
	private Timer timer;
	
	/**
	 * The GameCanvas constructor initializes its properties.
	 */
	public GameCanvas(){
		
		setBackground(Color.WHITE);
		setPreferredSize(new Dimension(WIDTH, HEIGHT));
		setFocusable(true);
		
		objectList = new ArrayList<GameObject>();
		gameController = new GameController(objectList);
		timer = new Timer(TIMER, new GameLoop());
	}
	
	/**
	 * Call necessary functions for the game to begin
	 */
	public void render(){
		
		// Load data
		gameController.init();
		
		// Add game listener
		addKeyListener(new CanvasKeyListener());
		
		// Start timer
		timer.start();
					
	}
	
	/**
	 * Paint all GameObjects in the ArrayList.
	 */
	@Override
	public void paintComponent(Graphics graphics){
		
		super.paintComponent(graphics);
		
		Iterator<GameObject> iterator = objectList.iterator();
		while(iterator.hasNext()){
			GameObject object = iterator.next();
			graphics.drawImage(object.getImage(), object.getPositionX(), object.getPositionY(), null);
		}
		
		objectList.clear();
	}
		
	/**
	 * Render the current game state
	 * and repaint all components in the loop.
	 */
	private class GameLoop implements ActionListener{
		public void actionPerformed(ActionEvent event){
			gameController.renderCurrentState();
			repaint();
		}
	}
	
	/**
	 * Listen to key events and pass them to the current game state
	 */
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