package boundary;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;

/**
 * The SelectableMenu is a menu with the various options available to select from
 * 
 * @author Thien Duc Phung
 * @author Minh Loi
 * @author Daniel Enriquez
 * @author Brett Bauman
 * @author Tanner Siffren
 */

public class SelectableMenu extends GameObject {

	private int height;
	private int width;
	
	private Color selectedColor;
	private Color unselectedColor;
	private int selectedIndex;
	private int marginTop;
	private Font font;
	
	/**
 	 * SelectableMenu is the position and color of the options on the menu
	 *  
	 * @param width - The width of the menu to be displayed
	 * @param height - The height of the menu to be displayed
	 * @param positionX - The x position of the menu to be displayed
	 * @param positionY - The y position of the menu to be displayed
	 */
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
	
	/**
 	 * drawMenu is the actual drawing of the options onto the menu
	 */
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
	
	/**
 	 * setFont sets the font of the text on the option
	 * 
	 * @param font - the current font of the main menu buttons
	 */
	public void setFont(Font font){
		this.font = font;
	}
	
	/**
 	 * setMarginTop sets the margin top of each option
	 * 
	 * @param marginTop - the desired margin top 
	 */
	public void setMarginTop(int marginTop){
		this.marginTop = marginTop;
	}
	
	/**
 	 * setSelectedColor is the color given to an option that has been selected
	 * 
	 * @param color - the color of an selected button
	 */
	public void setSelectedColor(Color color){
		this.selectedColor = color;
	}
	
	/**
 	 * setUnselectedColor is the color given to an unselected option
	 */
	public void setUnselectedColor(Color color){
		this.unselectedColor = color;
	}
	
	/**
 	* setSelectedIndex shows if an index of the option has been selected
	* 
	* @param index - The index of the option that is set to be selected
	**/
	public void setSelectedIndex(int index){
		selectedIndex = index;
	}
}
