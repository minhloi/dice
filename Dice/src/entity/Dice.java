package entity;

import java.util.Random;

/**
 * The Dice class is where all the rolling happen.
 * 
 * @author Thien Duc Phung
 * @author Minh Loi
 * @author Daniel Enriquez
 * @author Brett Bauman
 * @author Tanner Siffren
 */

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
