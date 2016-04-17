package boundary;

public class PlayerObject extends GameObject{
	
	private int idlePositionX;
	private int idlePositionY;
	private int playerNumber;
	private String resourceFolder;
	
	public static final int PLAYER1_IDLE_POSITION_X = 0;
	public static final int PLAYER1_IDLE_POSITION_Y = 250;
	public static final int PLAYER2_IDLE_POSITION_X = 600;
	public static final int PLAYER2_IDLE_POSITION_Y = 250;
		
	public static final String IDLE = "idle.png";
	
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
		setImageByPath(resourceFolder + IDLE);		
	}
	
	
	
}
