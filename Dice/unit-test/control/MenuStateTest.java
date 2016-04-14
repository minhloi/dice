package control;

import static org.junit.Assert.*;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Scanner;

import org.junit.Test;

public class MenuStateTest {

	
	@Test
	public void testMenuState() {
		
		GameController controller = new GameController();
		Scanner scanner = new Scanner(System.in);
		
		// Test if a MenuState object is created
		MenuState menu = new MenuState(controller, scanner);
		assertNotNull(menu);
		
	}
	
	@Test
	public void testPrint() {
		
		ByteArrayOutputStream outContent = new ByteArrayOutputStream();
		System.setOut(new PrintStream(outContent));
		
		String selectedOption = "" + MenuState.EXIT;
		System.setIn(new ByteArrayInputStream(selectedOption.getBytes()));
		
		GameController controller = new GameController();
		Scanner scanner = new Scanner(System.in);
		
		MenuState menu = new MenuState(controller, scanner);
		menu.print();
		
		// Test if menu is printing
		assertNotEquals("", outContent);
		
	}
	
	@Test
	public void testInvalidInput() {
		
		ByteArrayOutputStream outContent = new ByteArrayOutputStream();
		System.setOut(new PrintStream(outContent));
		
		// Mock option inputs.
		String selectedOption = "-1" + "\n"+ MenuState.EXIT;
		System.setIn(new ByteArrayInputStream(selectedOption.getBytes()));
		
		GameController controller = new GameController();
		Scanner scanner = new Scanner(System.in);
		
		MenuState menu = new MenuState(controller, scanner);
		menu.print();
		
		// Menu is printing
		assertNotEquals("", outContent);

		// Exactly two inputs are scanned because the first one is invalid.
		assertFalse(scanner.hasNext());
	
	}

}
