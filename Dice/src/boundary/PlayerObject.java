package boundary;

public class PlayerObject extends GameObject{
	
	private int idlePositionX;
	private int idlePositionY;
	private int playerNumber;
	private String resourceFolder;
	
	public static final String IDLE_FILE = "idle.png";
	
	public PlayerObject(int playerNumber, int idlePositionX, int idlePositionY) throws Exception{
		
		if(playerNumber != 1 && playerNumber != 2){
			throw new Exception("Player number" + playerNumber + " is not allowed");
		}
		
		this.playerNumber = playerNumber;
		this.idlePositionX = idlePositionX;
		this.idlePositionY = idlePositionY;
		
		this.resourceFolder = "/character/player" + this.playerNumber + "/";
	}
	
	public void setIdle(){
		setPosition(idlePositionX, idlePositionY);
		setImageByPath(resourceFolder + IDLE_FILE);		
	}
	
	
	
}
