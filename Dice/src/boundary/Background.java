package boundary;

public class Background extends GameObject {

	private String filename;
	
	public Background(String filename){
		this.filename = filename;
		setImageByPath("/background/" + filename);
	}
	
	public void setBackground(String filename){
		setImageByPath("/background/" + filename);
	}
}
