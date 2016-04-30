package boundary;

/**
 * PlayerObject class - Player image at different states in the game
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
	
	/**
	 * Identify the player and map character image
	 * 
	 * @param playerNumber Player identification number
	 * @throws Exception Player identification number isn't valid
	 */
	public PlayerObject(int playerNumber) throws Exception{
		
		if(playerNumber != 1 && playerNumber != 2){
			throw new Exception("Player number" + playerNumber + " is not allowed");
		}
		
		this.playerNumber = playerNumber;
		this.resourceFolder = "/character/player" + this.playerNumber + "/";
	}
	
	/**
	 * setIdle - Set character's position to default when idle
	 */
	public void setIdle(){
		
		if(playerNumber == 1){
			positionX = PLAYER1_DEFAULT_POSITION_X;
			positionY = PLAYER1_DEFAULT_POSITION_Y;
		} else {
			positionX = PLAYER2_DEFAULT_POSITION_X;
			positionY = PLAYER2_DEFAULT_POSITION_Y;
		}
		
		currentState = IDLE;
		
		setPosition(positionX, positionY);
		setImageByPath(resourceFolder + "idle.png");		
	}
	
	/**
	 * setIdle - Set and move character to certain position when idle
	 * 
	 * @param positionX
	 * @param positionY
	 */
	public void setIdle(int positionX, int positionY){
		
		this.positionX = positionX;
		this.positionY = positionY;
	
		setPosition(positionX, positionY);
		setImageByPath(resourceFolder + "idle.png");		
	
	}
	
	/**
	 * setDead - Set character image as dead
	 * 
	 */
	public void setDead(){
		
		setImageByPath(resourceFolder + "dead_10.png");		
	
	}
	
	/**
	 * runRight - Move character to the right position
	 * 
	 * @param destinationX Destination position
	 * @return Returns true or false if completed
	 */
	public boolean runRight(int destinationX){
		
		boolean completed;
		
		currentState = RUNNING;
		positionX += RUNNING_SPEED;
		
		int currentRunningState = (((runState / 2) + 1) % NUM_OF_RUN_STATE) + 1;
		
		setImageByPath(resourceFolder + "run_right_" + currentRunningState + ".png");
			
		setPositionX(positionX);
		
		if(positionX >= destinationX){
			completed = true;	
		} else {
			completed = false;
		}
		
		++runState;
		
		return completed;
	}
	
	/**
	 * runLeft - Move character to the left position
	 * 
	 * @param destinationX Destination position
	 * @return Returns true or false if completed
	 */
	public boolean runLeft(int destinationX){
		
		boolean completed;
		
		currentState = RUNNING;
		positionX -= RUNNING_SPEED;

		int currentRunningState = (((runState / 2) + 1) % NUM_OF_RUN_STATE) + 1;
		
		setPositionX(positionX);
		setImageByPath(resourceFolder + "run_left_" + currentRunningState + ".png");
	
		if(positionX <= destinationX){
			completed = true;
			resetRunState();;
		} else {
			completed = false;
			++runState;
		}
				
		return completed;
	}
	
	/**
	 * dying - Set the character's image to a dead character 
	 * 
	 * @return Returns true or false if completed
	 */
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
	
	/**
	 * attack - Set character's image to a character in attack mode
	 * 
	 * @return Returns true or false if completed
	 */
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
	/**
	 * isIdle - Check if state is idle
	 *  
	 * @return Returns true or false if state is idle
	 */
	public boolean isIdle(){
		boolean isIdle;
		if(currentState == IDLE){
			isIdle = true;
		} else {
			isIdle = false;
		}
		return isIdle;	 
	}
	
	/**
	 * resetRunState - Set run state to zero (0)
	 */
	private void resetRunState(){
		runState = 0;
	}
	
	/**
	 * resetAttackState - Set attack state to zero (0)
	 */
	private void resetAttackState(){
		attackState = 0;
	}
	
	/**
	 * resetDyingState - Set dying state to zero (0)
	 */
	private void resetDyingState(){
		dyingState = 0;
	}
		
}