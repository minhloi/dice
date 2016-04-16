package boundary;

public class Panel extends GameObject {
	
	public static final int SELECTING = 0;
	public static final int READY = 1;
	public static final int ROLLING = 2;
	
	private int playerNumber;
	private String resourceFolder;
	
	public static final int WIDTH = 280;
	public static final int HEIGHT = 80;
		
	public Panel(int playerNumber, int positionX, int positionY){
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
		} else if(state == ROLLING){
			setImageByPath(resourceFolder + "readyPanel.png");
		}
	}
	
}
