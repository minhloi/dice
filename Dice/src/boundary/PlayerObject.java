package boundary;

public class PlayerObject extends GameObject{
	
	private int idlePositionX;
	private int idlePositionY;
	
	private int playerNumber;
	
	private String resourceFolder;
	
	public PlayerObject(int playerNumber, int idlePositionX, int idlePositionY){
		this.playerNumber = playerNumber;
		this.idlePositionX = idlePositionX;
		this.idlePositionY = idlePositionY;
	}
	
	
	
}
