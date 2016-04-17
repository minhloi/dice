package control;

public abstract class Phase implements Listenable {
	
	public static final int LENGTH = 4;
	public static final int SELECT_MOVE_PHASE = 0;
	public static final int ROLL_DICE_PHASE = 1;
	public static final int BATTLE_PHASE = 2;
	public static final int RESET_PHASE = 3;
	
	protected boolean isCompleted = false;
	
	public abstract void render();
	
	public boolean isCompleted(){
		return isCompleted;
	}
	
	public void setCompleted(){
		isCompleted = true;
	}
}

