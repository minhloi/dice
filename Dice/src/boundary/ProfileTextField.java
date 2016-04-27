package boundary;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;

public class ProfileTextField extends GameObject {

	private static final int WIDTH = GameCanvas.WIDTH;
	private static final int HEIGHT = 200;
		
	private static final int DEFAULT_POSITION_X = 0;
	private static final int DEFAULT_POSITION_Y = (GameCanvas.HEIGHT - HEIGHT) / 2;
	
	private static final int MARGIN_TOP = 80;
	
	public ProfileTextField(){
		setPosition(DEFAULT_POSITION_X, DEFAULT_POSITION_Y);
	}
	public ProfileTextField(int positionX, int postionY){
		setPosition(positionX, positionY);
	}
	
	public void drawUsername(int playerNumber, String username){
		
		image = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_ARGB);		
		Graphics2D graphics = image.createGraphics();
		
		graphics.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
		graphics.setColor(new Color(0x2b759a));
		graphics.setFont(new Font("Arial", Font.BOLD, 38));
		
		FontMetrics labelMetrics = graphics.getFontMetrics();
		int fontHeight = labelMetrics.getHeight();
		
		String label = "Player " + playerNumber + " please enter your username";
		int labelWidth = labelMetrics.stringWidth(label);
		graphics.drawString(label, (WIDTH - labelWidth) / 2, fontHeight );
		
		graphics.setColor(new Color(0x184257));
		graphics.setFont(new Font("Tahoma", Font.BOLD, 50));
		FontMetrics usernameMetrics = graphics.getFontMetrics();
		int usernameWidth = usernameMetrics.stringWidth(username);
		graphics.drawString(username, (WIDTH - usernameWidth) / 2, fontHeight + MARGIN_TOP );
		
		graphics.dispose();
	}
}