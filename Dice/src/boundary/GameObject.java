package boundary;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

/**
 * 
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
	
	public void setPosition(int x, int y){
		positionX = x;
		positionY = y;
	}
	
	public void setPositionX(int x){
		positionX = x;
	}

	public void setPositionY(int y){
		positionY = y;
	}
	
	public void setImageByPath(String path){
		try {
			image = ImageIO.read(getClass().getResourceAsStream(path));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public int getPositionX(){
		return positionX;
	}
	
	public int getPositionY(){
		return positionY;
	}
	
	public BufferedImage getImage(){
		return image;
	}
	
}
