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
	
	private Color selectedColor;
	private Color unselectedColor;
	private int selectedIndex;
	private int marginTop;
	private Font font;
	
	public SelectableMenu(int width, int height, int positionX, int positionY){
		this.width = width;
		this.height = height;
		this.positionX = positionX;
		this.positionY = positionY;
		this.selectedIndex = -1;
		this.marginTop = 0;
		this.selectedColor = Color.WHITE;
		this.unselectedColor = Color.WHITE;
		this.font = new Font("Impact", Font.BOLD, 32);
		
		image = new BufferedImage(this.width, this.height, BufferedImage.TYPE_INT_ARGB);
	}
	
	public void drawMenu(String[] itemList){
		
		Graphics2D graphics = image.createGraphics();
		graphics.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
		graphics.setFont(font);
		FontMetrics fontMetrics = graphics.getFontMetrics();
		int fontHeight = fontMetrics.getHeight();

		int positionY = 0;
		int length = itemList.length;
		for (int index = 0; index < length; index++){
			String item = itemList[index];
			int stringWidth = fontMetrics.stringWidth(item);
			int alignCenter = (width - stringWidth) / 2;
			positionY += fontHeight + marginTop;
			if(selectedIndex == index){
				graphics.setColor(selectedColor);
			} else {
				graphics.setColor(unselectedColor);
			}
			graphics.drawString(item, alignCenter , positionY);
			
		}
		
		graphics.dispose();
	}
	
	public void setFont(Font font){
		this.font = font;
	}
	
	public void setMarginTop(int marginTop){
		this.marginTop = marginTop;
	}
	
	public void setSelectedColor(Color color){
		this.selectedColor = color;
	}
	
	public void setUnselectedColor(Color color){
		this.unselectedColor = color;
	}
	
	public void setSelectedIndex(int index){
		selectedIndex = index;
	}
}
