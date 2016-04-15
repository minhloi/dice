package boundary;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;
import javax.swing.Timer;

import control.GameController;
import control.PlayState;

@SuppressWarnings("serial")
public class GameCanvas extends JPanel {
	
	public static final int HEIGHT = 600;
	public static final int WIDTH = 800;
	
	private GameController gameController;
	private GameObject objects;
	
	public GameCanvas(){
		setBackground(Color.BLACK);
		setPreferredSize(new Dimension(WIDTH, HEIGHT));
		gameController = new GameController();
		
	}
	
	public void render(){
		
		// Load data
		gameController.init();
		
		Timer timer = new Timer(1000, new GameActionListener());
		timer.start();
		
		PlayState playState = (PlayState) gameController.getState(GameController.PLAY_STATE);
		playState.startNew();
		gameController.setState(GameController.PLAY_STATE);
		
	}
	
	private class GameActionListener implements ActionListener{
		public void actionPerformed(ActionEvent event){
			System.out.println("Test");
		}
	}
	
}
