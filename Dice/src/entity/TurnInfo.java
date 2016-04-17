package entity;

public class TurnInfo {
	
	private int currentMove;
	private boolean blockDisabled;
	private boolean turnWinner;
	private boolean moveAlreadySet;
	
	public TurnInfo(){
		blockDisabled = false;
		turnWinner = false;
		moveAlreadySet = false;
		currentMove = Player.NOT_SELECT;
	}
	
	public boolean isBlockDisabled(){
		return blockDisabled;
	}
	
	public int getMove(){
		return currentMove;
	}
	
	public void setTurnWinner(){
		turnWinner = true;
	}
	
	public boolean isTurnWinner(){
		return turnWinner;
	}
	
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
	
	public void setMove(int move) throws Exception{
		
		if(moveAlreadySet == true ){
			throw new Exception("Player has already set move. Overriding move is not allowed.");
		} else {
			currentMove = move;
		}
	}
	
	public void disableBlock(){
		blockDisabled = true;
	}
	
	public void enableBlock(){
		blockDisabled = false;
	}
	
	
}
