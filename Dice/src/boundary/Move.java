package boundary;

import entity.Player;

/**
 * Move class - Display the type of move selected
 * 
 * @author Thien Duc Phung
 * @author Minh Loi
 * @author Daniel Enriquez
 * @author Brett Bauman
 * @author Tanner Siffren
 */

public class Move extends GameObject {

	private String resourceFolder;
	
	/**
	 * Find and set the appropriate move image  
	 * 
	 * @param move Move type
	 * @param positionX Horizontal position in pixels
	 * @param positionY Vertical position in pixels
	 */
	public Move(int move, int positionX, int positionY){
		
		setPosition(positionX, positionY);
		resourceFolder = "/move";
		
		switch(move){
			case Player.ATTACK:
				setImageByPath(resourceFolder + "/attack.png");
				break;
				
			case Player.BLOCK:
				setImageByPath(resourceFolder + "/block.png");
				break;
				
			case Player.SPECIAL_ATTACK:
				setImageByPath(resourceFolder + "/special.png");
				break;
		}
	}
}
