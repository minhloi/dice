package Entity;

public class Dice {

	private int current;
	
	public Dice(){
			
	}
	
	public int roll(){
		current = (int)(Math.random() * 5 + 1);
		return current;		
	}
	
}
