package control;

import java.util.Scanner;

public abstract class State {

	protected Scanner scanner;
	
	public abstract void print();
	
	public Scanner getScanner(){
		return scanner;		
	}
	
}
