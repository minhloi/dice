package entity;

import java.util.Random;

/**
 * Dice class - Six sided Dice object that can roll
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
	
	/**
	 * roll - Generate a number within the range of 1-6
	 * 
	 * @return Returns a random number within the range 1-6
	 */
	public int roll(){
		current = random.nextInt(6) + 1;
		return current;		
	}
	
}
