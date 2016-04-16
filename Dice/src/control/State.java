package control;

import java.util.ArrayList;

import boundary.GameObject;

public abstract class State implements Listenable {

	protected ArrayList<GameObject> gameObjects;
	
	public abstract void print();
	
	
}
