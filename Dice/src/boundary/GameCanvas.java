package boundary;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.Timer;

import control.GameController;
import control.PlayState;

@SuppressWarnings("serial")
public class GameCanvas extends JPanel {
	
	public static final int HEIGHT = 600;
	public static final int WIDTH = 800;
	
	public static final int TIMER = 25; // in ms
	
	private GameController gameController;
	private ArrayList<GameObject> objectList;
	private Timer timer;
	
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
		
		PlayState playState = (PlayState) gameController.getState(GameController.PLAY_STATE);
		playState.startNew();
		gameController.setState(GameController.PLAY_STATE);
		
		// Start timer
		timer.start();
				
	}
	
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
			gameController.render();
			repaint();
		}
	}
	
	private class CanvasKeyListener implements KeyListener{

		@Override
		public void keyPressed(KeyEvent keyEvent) {
			GameCanvas.this.gameController.getCurrentStateObject().onKeyPressed(keyEvent);
		}

		@Override
		public void keyReleased(KeyEvent keyEvent) {
			GameCanvas.this.gameController.getCurrentStateObject().onKeyReleased(keyEvent);
		}

		@Override
		public void keyTyped(KeyEvent keyEvent) {
			GameCanvas.this.gameController.getCurrentStateObject().onKeyTyped(keyEvent);
		}
		
	}
}
