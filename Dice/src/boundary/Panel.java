package boundary;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

/**
 * Panel class - Displays a panel for in-game instructions 
 * 
 * @author Thien Duc Phung
 * @author Minh Loi
 * @author Daniel Enriquez
 * @author Brett Bauman
 * @author Tanner Siffren
 */
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
	
	/**
	 * Set the panel's coordinates and image
	 * 
	 * @param positionX Horizontal position in pixels
	 * @param positionY Vertical position in pixels
	 */	
	public Panel(int positionX, int positionY){
		this.positionX = positionX;
		this.positionY = positionY;
		this.defaultColor = new Color(0x333333);
		this.defaultFont = new Font("SansSerif", Font.BOLD, 16);
		setImageByPath("/panel.png");
	}
	
	/**
	 * drawString - Displays a string
	 * 
	 * @param string String to be displayed
	 * @param positionX Horizontal position in pixels
	 * @param positionY Vertical position in pixels
	 */
	public void drawString(String string, int positionX, int positionY){
		drawString(string, positionX, positionY, defaultColor, defaultFont);
	}
	
	/**
	 * drawString - Displays a string with color
	 * 
	 * @param string String to be displayed
	 * @param positionX Horizontal position in pixels
	 * @param positionY Vertical position in pixels
	 * @param color Color object
	 */
	public void drawString(String string, int positionX, int positionY, Color color){
		drawString(string, positionX, positionY, color, defaultFont);
	}
	
	/**
	 * drawString - Displays a string with a font
	 * 
	 * @param string String to be displayed
	 * @param positionX Horizontal position in pixels
	 * @param positionY Vertical position in pixels
	 * @param font Font object
	 */	
	public void drawString(String string, int positionX, int positionY, Font font){
		drawString(string, positionX, positionY, defaultColor, font);
	}
		
	/**
	 * drawString - Displays a rendered string with color and font
	 * 
	 * @param string String to be displayed
	 * @param positionX Horizontal position in pixels
	 * @param positionY Vertical position in pixels
	 * @param color Color object
	 * @param font Font object
	 */
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