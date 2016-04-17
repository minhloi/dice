package boundary;

public class PlayerObject extends GameObject{
	
	private int playerNumber;
	private String resourceFolder;
	private int currentState;
	private int currentPositionX;
	private int currentPositionY;
	
	public static final int HEIGHT = 220;
	public static final int WIDTH = 240;
	
	public static final int IDLE = 0;
	public static final int WALKING = 1;
	public static final int ATTACKING = 2;
	public static final int WALKING_BACK = 3;	
	
	public static final int PLAYER1_DEFAULT_POSITION_X = 0;
	public static final int PLAYER1_DEFAULT_POSITION_Y = 220;
	public static final int PLAYER2_DEFAULT_POSITION_X = GameCanvas.WIDTH - WIDTH;
	public static final int PLAYER2_DEFAULT_POSITION_Y = 220;
	
	public static final double VELOCITY = 0.16; // in px/ms 
	
	public static final String IDLE_IMAGE = "idle.png";
	
	public PlayerObject(int playerNumber) throws Exception{
		
		if(playerNumber != 1 && playerNumber != 2){
			throw new Exception("Player number" + playerNumber + " is not allowed");
		}
		
		this.playerNumber = playerNumber;
		this.resourceFolder = "/character/player" + this.playerNumber + "/";
	}
	
	public void setIdle(int positionX, int positionY){
		currentPositionX = positionX;
		currentPositionY = positionY;
		currentState = IDLE;
		
		setPosition(currentPositionX, currentPositionY);
		setImageByPath(resourceFolder + IDLE_IMAGE);		
	}
	
	public void moveTo(int destinationX){
		
		if(currentPositionX >= destinationX){
			currentState = IDLE;	
		} else {
			currentState = WALKING;
			currentPositionX +=
		}
	}
	
	public void moveBack(int destinationX){
		
	
	}
	
	public int getState(){
		return currentState;
	}
	
}