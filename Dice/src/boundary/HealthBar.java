package boundary;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import entity.Player;

public class HealthBar extends GameObject {

	public static final int IMAGE_HEIGHT = 50;
	public static final int IMAGE_WIDTH = 280;
	
	public static final int HEALTH_NUM_WIDTH = 50;
	public static final int BAR_MAX_WIDTH = IMAGE_WIDTH - HEALTH_NUM_WIDTH;
	public static final int BAR_HEIGHT = 10;
	
	public static final int PLAYER1_POSITION_X = 60;
	public static final int PLAYER1_POSITION_Y = 60;
	public static final int PLAYER2_POSITION_X = GameCanvas.WIDTH - IMAGE_WIDTH - 60;
	public static final int PLAYER2_POSITION_Y = 60;
	
	public HealthBar(int positionX, int positionY){
		setPosition(positionX, positionY);
	}
	
	public void setHealthBar(int healthPoint){
		
		if(healthPoint < 0 ){
			healthPoint = 0;
		}
		
		image = new BufferedImage(IMAGE_WIDTH, IMAGE_HEIGHT, BufferedImage.TYPE_INT_ARGB);		
		
		Graphics graphics = image.createGraphics();
		
		graphics.setFont(new Font("SansSerif", Font.BOLD, 32));
		graphics.setColor(Color.BLUE);
		
		int barWidth = BAR_MAX_WIDTH*(healthPoint)/ Player.DEFAULT_HEALTH_POINT;
		
		graphics.fillRect(HEALTH_NUM_WIDTH, 8, barWidth ,BAR_HEIGHT);
		graphics.drawString("" + healthPoint, 0, 25);
		
		graphics.dispose();
	}
	
}
