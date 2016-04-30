package entity;
/**
 * TurnInfo class - Set and return each turn's winner, blocking and move info
 * 
 * @author Thien Duc Phung
 * @author Minh Loi
 * @author Daniel Enriquez
 * @author Brett Bauman
 * @author Tanner Siffren
 */
public class TurnInfo {
	
	private int currentMove;
	private boolean blockDisabled;
	private boolean turnWinner;
	private boolean moveAlreadySet;
	
	/**
	 * Set blockDisabled, turnWinner, and moveAlreadySet to false. Also, set currentMove to not selected
	 */
	public TurnInfo(){
		blockDisabled = false;
		turnWinner = false;
		moveAlreadySet = false;
		currentMove = Player.NOT_SELECT;
	}
	
	/**
	 * isBlockDisabled - Return whether or not block is disabled 
	 * 
	 * @return Returns true if block is disabled and false if it isn't
	 */
	public boolean isBlockDisabled(){
		return blockDisabled;
	}
	
	/**
	 * getMove - Get the current move
	 * 
	 * @return Returns the current move
	 */
	public int getMove(){
		return currentMove;
	}
	
	/**
	 * setTurnWinner - Set turnWinner to true
	 */
	public void setTurnWinner(){
		turnWinner = true;
	}
	
	/**
	 * isTurnWinner - Check if player is turn's winner
	 * 
	 * @return Returns true if a player is the turn's winner or false otherwise
	 */
	public boolean isTurnWinner(){
		return turnWinner;
	}
	
	/**
	 * getMoveInString - Match string to either attack, block, and special attack
	 * 
	 * @return Returns string of the appropriate move
	 */
	public String getMoveInString(){
		String moveString;
		switch (currentMove){
			case Player.ATTACK:
				moveString = "ATTACK";
				break;
			case Player.BLOCK:
				moveString = "BLOCK";
				break;
			case Player.SPECIAL_ATTACK:
				moveString = "SPECIAL_ATTACK";
				break;
			default:
				moveString = "NOT_SELECTED";
		}
		return moveString;
	}
	
	/**
	 * setMove - Set the current move
	 * 
	 * @param move Move identification integer
	 * @throws Exception Move has already been set by player
	 */
	public void setMove(int move) throws Exception{
		
		if(moveAlreadySet == true ){
			throw new Exception("Player has already set move. Overriding move is not allowed.");
		} else {
			currentMove = move;
		}
	}
	
	/**
	 * disableBlock - Block has been disabled
	 */
	public void disableBlock(){
		blockDisabled = true;
	}
	
	/**
	 * enableBlock - block has been enabled
	 */
	public void enableBlock(){
		blockDisabled = false;
	}
	
}
