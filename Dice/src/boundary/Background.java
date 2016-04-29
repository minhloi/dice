package boundary;

/**
 * The Background class is use for adding image as a background
 * 
 * @author Thien Duc Phung
 * @author Minh Loi
 * @author Daniel Enriquez
 * @author Brett Bauman
 * @author Tanner Siffren
 */

public class Background extends GameObject {

	public Background(String filename){
		setImageByPath("/background/" + filename);
	}
	
	public void setBackground(String filename){
		setImageByPath("/background/" + filename);
	}
}
