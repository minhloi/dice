package control;

import static org.junit.Assert.*;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Scanner;

import org.junit.Test;

/**
 * Junit test of MenuState class
 * 
 * @author Thien Duc Phung
 * @author Minh Loi
 * @author Daniel Enriquez
 * @author Brett Bauman
 * @author Tanner Siffren
 */

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
		assertNotEquals("", outContent.toString());
		
	}
	
	@Test
	public void testOptionNotExist() {
		
		ByteArrayOutputStream outContent = new ByteArrayOutputStream();
		System.setOut(new PrintStream(outContent));
		
		// Mock an input for a menu option does not exist (such as 100) 
		// and a valid input (such as 0, which is MenuState.EXIT)
		// If the first input is invalid, the console asks to provide a valid input.
		String selectedOption = "100" + "\n"+ MenuState.EXIT;
		System.setIn(new ByteArrayInputStream(selectedOption.getBytes()));
		
		GameController controller = new GameController();
		Scanner scanner = new Scanner(System.in);
		
		MenuState menu = new MenuState(controller, scanner);
		menu.print();
		
		// Menu is printing
		assertNotEquals("", outContent.toString());

		// Exactly two inputs are scanned because the first one is invalid.
		assertFalse(scanner.hasNext());
	
	}
	
	@Test
	public void testInvalidInput() {
		
		ByteArrayOutputStream outContent = new ByteArrayOutputStream();
		System.setOut(new PrintStream(outContent));
		
		// Mock an input for a menu option is a string (such as "you") 
		// and a valid input (such as 0, which is MenuState.EXIT)
		// If the first input is invalid, the console asks to provide a valid input.
		String selectedOption = "you" + "\n"+ MenuState.EXIT;
		System.setIn(new ByteArrayInputStream(selectedOption.getBytes()));
		
		GameController controller = new GameController();
		Scanner scanner = new Scanner(System.in);
		
		MenuState menu = new MenuState(controller, scanner);
		menu.print();
		
		// Menu is printing
		assertNotEquals("", outContent.toString());

		// Exactly two inputs are scanned because the first one is invalid.
		assertFalse(scanner.hasNext());
	
	}

}
