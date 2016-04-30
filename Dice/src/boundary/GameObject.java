package boundary;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

/**
 * GameObject class is the parent class of all game objects
 * 
 * @author Thien Duc Phung
 * @author Minh Loi
 * @author Daniel Enriquez
 * @author Brett Bauman
 * @author Tanner Siffren
 */

public abstract class GameObject {
	
	protected int positionX;
	protected int positionY;
	protected BufferedImage image;
	
	/**
	 * Set position of the object
	 * @param x position in the x-axis
	 * @param y position in the y-axis
	 */
	public void setPosition(int x, int y){
		positionX = x;
		positionY = y;
	}
	
	/**
	 * Set position in the x-axis of the object
	 * @param x position in the x-axis
	 */
	public void setPositionX(int x){
		positionX = x;
	}

	/**
	 * Set position in the y-axis of the object
	 * @param y position in the y-axis
	 */
	public void setPositionY(int y){
		positionY = y;
	}
	
	/**
	 * Read image and set to buffer.
	 * @param path the location of the image
	 */
	public void setImageByPath(String path){
		try {
			image = ImageIO.read(getClass().getResourceAsStream(path));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Get position in the x-axis of the object 
	 */
	public int getPositionX(){
		return positionX;
	}
	
	/**
	 * Get position in the y-axis of the object 
	 */
	public int getPositionY(){
		return positionY;
	}
	
	/**
	 * Get BufferedImage of the object 
	 */
	public BufferedImage getImage(){
		return image;
	}
	
}
