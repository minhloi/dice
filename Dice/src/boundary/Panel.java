package boundary;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

public class Panel extends GameObject {
	
	private Color defaultColor;
	private Font defaultFont;

	public static final int WIDTH = 280;
	public static final int HEIGHT = 80;
	
	public static final int PANEL_1_POSITION_X = 30;
	public static final int PANEL_1_POSITION_Y = GameCanvas.HEIGHT - HEIGHT - 240;
	public static final int PANEL_2_POSITION_X = GameCanvas.WIDTH - WIDTH - 30;
	public static final int PANEL_2_POSITION_Y = GameCanvas.HEIGHT - HEIGHT - 240;
	
	public static final int ALIGN_TOP = 30;
	public static final int ALIGN_BOTTOM = 60;
	public static final int ALIGN_LEFT = 15;
		
	public Panel(int positionX, int positionY){
		this.positionX = positionX;
		this.positionY = positionY;
		this.defaultColor = new Color(0x333333);
		this.defaultFont = new Font("SansSerif", Font.BOLD, 16);
		setImageByPath("/panel.png");
		
	}
		
	public void drawString(String string, int positionX, int positionY){
		drawString(string, positionX, positionY, defaultColor, defaultFont);
	}
	
	public void drawString(String string, int positionX, int positionY, Color color){
		drawString(string, positionX, positionY, color, defaultFont);
	}
	
	public void drawString(String string, int positionX, int positionY, Font font){
		drawString(string, positionX, positionY, defaultColor, font);
	}
		
	public void drawString(String string, int positionX, int positionY, Color color, Font font){
		Graphics2D graphics = image.createGraphics();
		
		// Make font rendered better
		graphics.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
		
		graphics.setColor(color);
		graphics.setFont(font);
		
		graphics.drawString(string, positionX, positionY);
		graphics.dispose();
	}
	
}