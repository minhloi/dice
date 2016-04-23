package control;

import java.util.ArrayList;

import boundary.GameObject;

/**
 * State class - An abstract class, which is used to create different game states. 
 * 				 All subclasses must override print method.
 * 
 * @author Thien Duc Phung
 * @author Minh Loi
 * @author Daniel Enriquez
 * @author Brett Bauman
 * @author Tanner Siffren
 */
public abstract class State implements Listenable {

	protected ArrayList<GameObject> gameObjects;
	
	// Game state definitions.
	public static final int LENGTH = 3;
	public static final int MENU_STATE = 0;
	public static final int PLAY_STATE = 1;
	public static final int VIEW_RANK_STATE = 2;
	
	public abstract void print();

}
