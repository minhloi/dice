package boundary;

public class Background extends GameObject {

	public Background(String filename){
		setImageByPath("/background/" + filename);
	}
	
	public void setBackground(String filename){
		setImageByPath("/background/" + filename);
	}
}
