package control;

public abstract class Phase {
	
	protected boolean isCompleted = false;
	
	public abstract void render();
	
	public boolean isCompleted(){
		return isCompleted;
	}
	
	public void setCompleted(){
		isCompleted = true;
	}
}

