package boundary;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;

public class Panel extends GameObject {
	
	public static final int SELECTING = 0;
	public static final int READY = 1;
	public static final int ROLLING = 2;
	
	private int playerNumber;
	private String resourceFolder;
	
	private Color defaultColor;
	private Font defaultFont;
	
	public static final int WIDTH = 280;
	public static final int HEIGHT = 80;
	
	public static final int ALIGN_TOP = 30;
	public static final int ALIGN_BOTTOM = 60;
	public static final int ALIGN_LEFT = 15;
		
	public Panel(int playerNumber, int positionX, int positionY){
		this.playerNumber = playerNumber;
		this.positionX = positionX;
		this.positionY = positionY;
		this.defaultColor = new Color(0x787038);
		this.defaultFont = new Font("Arial", Font.PLAIN, 18);
		setImageByPath("/panel.png");
	}
	
	/*public void setState(int state){
		switch(state){
			case SELECTING:
				setImageByPath(resourceFolder + "selectPanel.png");
				break;
			case READY:
				setImageByPath(resourceFolder + "readyPanel.png");
				break;
			case ROLLING:
				setImageByPath(resourceFolder + "rollingPanel.png");
				break;
		}
	}*/
	
	public void drawString(String string, int positionX, int positionY){
		drawString(string, positionX, positionY, defaultColor, defaultFont);
	}
	
	public void drawString(String string, int positionX, int positionY, Color color, Font font){
		Graphics graphics = image.getGraphics();
		graphics.setColor(color);
		graphics.setFont(font);
		
		graphics.drawString(string, positionX, positionY);
		graphics.dispose();
	}
	
	
	
}