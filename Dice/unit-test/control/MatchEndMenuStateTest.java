package control;

import static org.junit.Assert.*;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Scanner;

import org.junit.Test;

public class MatchEndMenuStateTest {

	@Test
	public void testMatchEndMenuState() {
		GameController controller = new GameController();
		Scanner scanner = new Scanner(System.in);
		
		// Test if a MatchEndMenuState object is created
		MatchEndMenuState menu = new MatchEndMenuState(controller, scanner);
		assertNotNull(menu);
	}

	@Test
	public void testPrint() {
		
		ByteArrayOutputStream outContent = new ByteArrayOutputStream();
		System.setOut(new PrintStream(outContent));
		
		String selectedOption = "" + MatchEndMenuState.EXIT;
		System.setIn(new ByteArrayInputStream(selectedOption.getBytes()));
		
		GameController controller = new GameController();
		Scanner scanner = new Scanner(System.in);
		
		MatchEndMenuState menu = new MatchEndMenuState(controller, scanner);
		menu.print();
		
		// Test if menu is printing
		assertNotEquals("", outContent.toString());
	}
	
	@Test
	public void testInvalidInput() {
		
		ByteArrayOutputStream outContent = new ByteArrayOutputStream();
		System.setOut(new PrintStream(outContent));
		
		// Mock inputs
		String selectedOption = "-1" + "\n"+ MatchEndMenuState.EXIT;
		System.setIn(new ByteArrayInputStream(selectedOption.getBytes()));
		
		GameController controller = new GameController();
		Scanner scanner = new Scanner(System.in);
		
		MatchEndMenuState menu = new MatchEndMenuState(controller, scanner);
		menu.print();
		
		// Menu is printing
		assertNotEquals("", outContent.toString());

		// Exactly two inputs are scanned because the first one is invalid.
		assertFalse(scanner.hasNext());
	
	}

	
	
		
}
