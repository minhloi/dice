package entity;

import java.util.Random;

public class Dice {

	private int current;
	private Random random;
	public Dice(){
		random = new Random();
	}
	
	public int roll(){
		current = random.nextInt(6) + 1;
		return current;		
	}
	
}
