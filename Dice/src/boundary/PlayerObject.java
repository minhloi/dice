package boundary;

/**
 * The BattlePhase class demonstates a phase of a match, where the rollWinner
 * causes damage to the rollLoser.
 * 
 * @author Thien Duc Phung
 * @author Minh Loi
 * @author Daniel Enriquez
 * @author Brett Bauman
 * @author Tanner Siffren
 */

public class PlayerObject extends GameObject{
	
	private int playerNumber;
	private String resourceFolder;
	private int currentState;
	private int runState;
	private int attackState;
	private int dyingState;

	private int currentPositionX;
	private int currentPositionY;
	
	public static final int HEIGHT = 110;
	public static final int WIDTH = 120;
	
	private static final int IDLE = 0;
	private static final int RUNNING = 1;
	private static final int ATTACKING = 2;
	private static final int DYING = 3;
	
	public static final int PLAYER1_DEFAULT_POSITION_X = 180;
	public static final int PLAYER1_DEFAULT_POSITION_Y = GameCanvas.HEIGHT - 200;
	public static final int PLAYER2_DEFAULT_POSITION_X = GameCanvas.WIDTH - WIDTH - 180;
	public static final int PLAYER2_DEFAULT_POSITION_Y = GameCanvas.HEIGHT - 200;
	
	public static final int FRONT_OF_PLAYER1 = PLAYER1_DEFAULT_POSITION_X + 50;
	public static final int FRONT_OF_PLAYER2 = PLAYER2_DEFAULT_POSITION_X - 50;
	
	private static final int NUM_OF_RUN_STATE = 8;
	private static final int NUM_OF_ATTACK_STATE = 7;
	private static final int NUM_OF_DYING_STATE = 10;
	
	// Running speed: How many pixels it moves in the x-axis per 25 ms (The game loop runs every 25 ms).
	public static final int RUNNING_SPEED = 8;
	
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
		setImageByPath(resourceFolder + "idle.png");		
	}
	
	public void setIdle(int positionX, int positionY){
		
		currentPositionX = positionX;
		currentPositionY = positionY;
	
		setPosition(currentPositionX, currentPositionY);
		setImageByPath(resourceFolder + "idle.png");		
	
	}
	
	public void setDead(){
		
		setImageByPath(resourceFolder + "dead_10.png");		
	
	}
		
	public boolean runRight(int destinationX){
		
		boolean completed;
		
		currentState = RUNNING;
		currentPositionX += RUNNING_SPEED;
		
		int currentRunningState = (((runState / 2) + 1) % NUM_OF_RUN_STATE) + 1;
		
		setImageByPath(resourceFolder + "run_right_" + currentRunningState + ".png");
			
		setPositionX(currentPositionX);
		
		if(currentPositionX >= destinationX){
			completed = true;	
		} else {
			completed = false;
		}
		
		++runState;
		
		return completed;
	}
	
	public boolean runLeft(int destinationX){
		
		boolean completed;
		
		currentState = RUNNING;
		currentPositionX -= RUNNING_SPEED;

		int currentRunningState = (((runState / 2) + 1) % NUM_OF_RUN_STATE) + 1;
		
		setPositionX(currentPositionX);
		setImageByPath(resourceFolder + "run_left_" + currentRunningState + ".png");
	
		if(currentPositionX <= destinationX){
			completed = true;
			resetRunState();;
		} else {
			completed = false;
			++runState;
		}
				
		return completed;
	}
	
	public boolean dying(){
		
		boolean completed;
		
		currentState = DYING;
		
		++dyingState;
		setImageByPath(resourceFolder + "dead_" + dyingState + ".png");
		
		if(dyingState >= NUM_OF_DYING_STATE){
			resetDyingState();
			completed = true; 
		} else {
			completed = false;
		}
		
		return completed;
			
	}
	
	public boolean attack(){
		
		boolean completed;
		
		currentState = ATTACKING;
		
		++attackState;
		setImageByPath(resourceFolder + "attack_" + attackState + ".png");
		
		if(attackState >= NUM_OF_ATTACK_STATE){
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
	
	private void resetRunState(){
		runState = 0;
	}
	
	private void resetAttackState(){
		attackState = 0;
	}
	
	private void resetDyingState(){
		dyingState = 0;
	}
		
}