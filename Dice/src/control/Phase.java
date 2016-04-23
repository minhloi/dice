package control;

/**
 * The Phase class is an abstract class, which is used
 * to create different phase of a match. All subclasses
 * must override render() method.
 * 
 * @author Thien Duc Phung
 * @author Minh Loi
 * @author Daniel Enriquez
 * @author Brett Bauman
 * @author Tanner Siffren
 */
public abstract class Phase implements Listenable {
	
	public static final int LENGTH = 3;
	public static final int SELECT_MOVE_PHASE = 0;
	public static final int ROLL_DICE_PHASE = 1;
	public static final int BATTLE_PHASE = 2;
	
	protected boolean isCompleted = false;
	
	public abstract void render();
	
	public boolean isCompleted(){
		return isCompleted;
	}
	
	public void setCompleted(){
		isCompleted = true;
	}
}

