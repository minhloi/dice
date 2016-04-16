package boundary;

public class SelectPanel extends GameObject {
	
	public static final int SELECTING = 0;
	public static final int READY = 1;
	
	private int playerNumber;
	private String resourceFolder;
	
	public static final int WIDTH = 280;
	public static final int HEIGHT = 80;
		
	public SelectPanel(int playerNumber, int positionX, int positionY){
		this.playerNumber = playerNumber;
		this.positionX = positionX;
		this.positionY = positionY;
		this.resourceFolder = "/panel/player" + playerNumber + "/";
	}
	
	public void setState(int state){
		if(state == SELECTING){
			setImageByPath(resourceFolder + "selectPanel.png");
		} else if(state == READY){
			setImageByPath(resourceFolder + "readyPanel.png");
		}
	}
	
}
