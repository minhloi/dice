package boundary;

public class PlayerObject extends GameObject{
	
	private int playerNumber;
	private String resourceFolder;
	private int currentState;
	private int attackState;

	private int currentPositionX;
	private int currentPositionY;
	
	public static final int HEIGHT = 220;
	public static final int WIDTH = 240;
	
	public static final int IDLE = 0;
	public static final int RUNNING = 1;
	public static final int ATTACKING = 2;
	
	public static final int PLAYER1_DEFAULT_POSITION_X = 0;
	public static final int PLAYER1_DEFAULT_POSITION_Y = 220;
	public static final int PLAYER2_DEFAULT_POSITION_X = GameCanvas.WIDTH - WIDTH;
	public static final int PLAYER2_DEFAULT_POSITION_Y = 220;
	public static final int FRONT_OF_PLAYER1 = 80;
	public static final int FRONT_OF_PLAYER2 = 480;
	
	// There are a total of 8 states in one running step
	public static final int STATES_PER_STEP = 8;
	
	// Step per pixel: How big a step is.
	public static final int STEP_PER_PX = 50;
	
	// How fast does a state change depends on how big the step is.
	// For example, if the step is small then the state will change very fast.
	public static final int STATE_CHANGE_SPEED = STEP_PER_PX / STATES_PER_STEP;
	
	// Running speed: How many pixels it runs per 25 ms (The game loop runs every 25 ms).
	public static final int RUNNING_SPEED = 6;
	
	public static final int ATTACK_STATE_NUM = 7;
	
	public static final String IDLE_IMAGE = "idle.png";
	
	public PlayerObject(int playerNumber) throws Exception{
		
		if(playerNumber != 1 && playerNumber != 2){
			throw new Exception("Player number" + playerNumber + " is not allowed");
		}
		
		this.playerNumber = playerNumber;
		this.resourceFolder = "/character/player" + this.playerNumber + "/";
	}
	
	public void setIdle(){
		
		if(playerNumber == 1){
			currentPositionX = PLAYER1_DEFAULT_POSITION_X;
			currentPositionY = PLAYER1_DEFAULT_POSITION_Y;
		} else {
			currentPositionX = PLAYER2_DEFAULT_POSITION_X;
			currentPositionY = PLAYER2_DEFAULT_POSITION_Y;
		}
		
		currentState = IDLE;
		
		setPosition(currentPositionX, currentPositionY);
		setImageByPath(resourceFolder + IDLE_IMAGE);		
	}
	
	public void setIdle(int positionX, int positionY){
		
		currentPositionX = positionX;
		currentPositionY = positionY;
	
		setPosition(currentPositionX, currentPositionY);
		setImageByPath(resourceFolder + IDLE_IMAGE);		
	
	}
		
	public boolean runRight(int destinationX){
		
		boolean completed;
		
		currentState = RUNNING;
		currentPositionX += RUNNING_SPEED;
			
		if(currentPositionX >= destinationX){
			completed = true;	
		} else {
			completed = false;
			
			int currentRunningState = ((destinationX - currentPositionX) / STATE_CHANGE_SPEED) % STATES_PER_STEP + 1 ;
			setImageByPath(resourceFolder + "run_right_" + currentRunningState + ".png");
			
			setPositionX(currentPositionX);
		}
		return completed;
	}
	
	public boolean runLeft(int destinationX){
		
		boolean completed;
		
		currentState = RUNNING;
		currentPositionX -= RUNNING_SPEED;

		int currentRunningState = ((currentPositionX - destinationX) / STATE_CHANGE_SPEED) % STATES_PER_STEP + 1 ;
		setPositionX(currentPositionX);
		setImageByPath(resourceFolder + "run_left_" + currentRunningState + ".png");
	
		if(currentPositionX <= destinationX){
			completed = true;
		} else {
			completed = false;
		}
		
		return completed;
	}
	
	public boolean attack(){
		
		boolean completed;
		
		currentState = ATTACKING;
		attackState++;
		setImageByPath(resourceFolder + "attack_" + attackState + ".png");
		
		if(attackState >= ATTACK_STATE_NUM){
			resetAttackState();
			completed = true; 
		} else {
			completed = false;
		}
		
		return completed;
	}
			
	public int getState(){
		return currentState;
	}
	
	public boolean isIdle(){
		boolean isIdle;
		if(currentState == IDLE){
			isIdle = true;
		} else {
			isIdle = false;
		}
		return isIdle;	 
	}
	
	private void resetAttackState(){
		attackState = 0;
	}
		
}