package boundary;

public class LargePanel extends GameObject {

	public static final int WIDTH = 468;
	public static final int HEIGHT = 346;
	
	public LargePanel(int positionX, int positionY){
		setPosition(positionX, positionY);
		setImageByPath("/big_panel.png");
	}
	
	
}
