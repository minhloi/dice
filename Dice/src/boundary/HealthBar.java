package boundary;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;

import entity.Player;

/**
 * The HealthBar class to render health bars of players.
 * 
 * @author Thien Duc Phung
 * @author Minh Loi
 * @author Daniel Enriquez
 * @author Brett Bauman
 * @author Tanner Siffren
 */

public class HealthBar extends GameObject {

	// Size of the HealthBar image
	public static final int HEIGHT = 50;
	public static final int WIDTH = 280;
	
	// Size of the Health Bar
	public static final int HEALTH_NUM_WIDTH = 50;
	public static final int BAR_MAX_WIDTH = WIDTH - HEALTH_NUM_WIDTH;
	public static final int BAR_HEIGHT = 12;
	
	// Default positions of two health bars
	public static final int PLAYER1_POSITION_X = 30;
	public static final int PLAYER1_POSITION_Y = 60;
	public static final int PLAYER2_POSITION_X = GameCanvas.WIDTH - WIDTH - 30;
	public static final int PLAYER2_POSITION_Y = 60;
	
	/**
	 * The HealthBar constructor initializes position of health bar
	 * @param positionX
	 * @param positionY
	 */
	public HealthBar(int positionX, int positionY){
		
		setPosition(positionX, positionY);
		
		
	}
	
	/**
	 * Render health bar with health point aside.
	 * @param healthPoint current health point of the players
	 */
	public void setHealthBar(int healthPoint){
		
		if(healthPoint < 0 ){
			healthPoint = 0;
		}
		
		image = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_ARGB);		
		
		Graphics2D graphics = image.createGraphics();
		// Make font rendered better
		graphics.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
		
		graphics.setColor(Color.WHITE);
		graphics.fillRect(HEALTH_NUM_WIDTH, 18, BAR_MAX_WIDTH ,BAR_HEIGHT);
		
		graphics.setFont(new Font("SansSerif", Font.BOLD, 32));
		graphics.setColor(Color.BLUE);
		
		int barWidth = BAR_MAX_WIDTH*(healthPoint)/ Player.DEFAULT_HEALTH_POINT;
		graphics.fillRect(HEALTH_NUM_WIDTH, 18, barWidth ,BAR_HEIGHT);
		graphics.drawString("" + healthPoint, 0, 35);
		
		graphics.dispose();
	}
	
}
