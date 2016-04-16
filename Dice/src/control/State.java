package control;

import java.util.ArrayList;
import java.util.Scanner;

import boundary.GameObject;

public abstract class State {

	protected ArrayList<GameObject> gameObjects;
	
	public abstract void print();
		
	
}
