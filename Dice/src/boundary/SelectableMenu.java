package boundary;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Iterator;

public class SelectableMenu extends GameObject {

	private int height;
	private int width;
	
	private int selectedIndex;
	
	public SelectableMenu(int width, int height, int positionX, int positionY){
		this.width = width;
		this.height = height;
		this.positionX = positionX;
		this.positionY = positionY;
		this.selectedIndex = -1;
		image = new BufferedImage(this.width, this.height, BufferedImage.TYPE_INT_ARGB);
	}
	
	public void drawMenu(String[] itemList){
		
		Graphics2D graphics = image.createGraphics();
		graphics.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
		graphics.setFont(new Font("Impact", Font.BOLD, 32));
		FontMetrics fontMetrics = graphics.getFontMetrics();
		int fontHeight = fontMetrics.getHeight();

		int marginTop = 0;
		int length = itemList.length;
		for (int index = 0; index < length; index++){
			String item = itemList[index];
			int stringWidth = fontMetrics.stringWidth(item);
			int alignCenter = (width - stringWidth) / 2;
			marginTop += fontHeight + 25;
			if(selectedIndex == index){
				graphics.setColor(Color.WHITE);
			} else {
				graphics.setColor(new Color(0x8fbfd9));
			}
			graphics.drawString(item, alignCenter , marginTop);
			
		}
		
		graphics.dispose();
	}
		
	public void setSelectedIndex(int index){
		selectedIndex = index;
	}
}
