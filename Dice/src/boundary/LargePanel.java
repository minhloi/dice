package boundary;

/**
 * LargePanel class - Displays a large panel for after-game instructions
 * 
 * @author Thien Duc Phung
 * @author Minh Loi
 * @author Daniel Enriquez
 * @author Brett Bauman
 * @author Tanner Siffren
 */

public class LargePanel extends GameObject {

	public static final int WIDTH = 468;
	public static final int HEIGHT = 346;
	
	/**
	 * Constructor - Set image as the panel
	 * 
	 * @param positionX Horizontal position in pixels 
	 * @param positionY Vertical position in pixels
	 */
	public LargePanel(int positionX, int positionY){
		setPosition(positionX, positionY);
		setImageByPath("/big_panel.png");
	}
		
}