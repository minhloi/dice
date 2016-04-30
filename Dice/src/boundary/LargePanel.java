package boundary;

/**
 * The LargePanel class - use to render a large panel  
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
	 * Set image as the panel
	 * 
	 * @param positionX Horizontal position in pixels 
	 * @param positionY Vertical position in pixels
	 */
	public LargePanel(int positionX, int positionY){
		setPosition(positionX, positionY);
		setImageByPath("/big_panel.png");
	}
		
}