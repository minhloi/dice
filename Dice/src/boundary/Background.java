package boundary;

/**
 * The Background class is used to add an image as a background
 * 
 * @author Thien Duc Phung
 * @author Minh Loi
 * @author Daniel Enriquez
 * @author Brett Bauman
 * @author Tanner Siffren
 */

public class Background extends GameObject {
	
	/**
	 * The Background constructor initializes image by filename
	 * @param filename the filename of the image
	 */
	public Background(String filename){
		setImageByPath("/background/" + filename);
	}
	
	/**
	 * Set background image by filename
	 * @param filename the filename of the image
	 */
	public void setBackground(String filename){
		setImageByPath("/background/" + filename);
	}
}
