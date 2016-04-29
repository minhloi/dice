package boundary;

import static org.junit.Assert.*;

import org.junit.Test;

public class ProfileTextFieldTest {

	@Test
	public void testProfileTextField() {
		// Test if a ProfileTextField object is created.
		ProfileTextField textField = new ProfileTextField();
		assertNotNull(textField);
	}

	@Test
	public void testProfileTextField2() {

		// Test if a ProfileTextField object is created.
		ProfileTextField textField = new ProfileTextField(10, 20);
		
		assertEquals(10, textField.getPositionX());
		assertEquals(20, textField.getPositionY());
		
	}
	
	@Test
	public void testImageCreated() {
		// Test if image is created when a ProfileTextField object is created.
		ProfileTextField textField = new ProfileTextField();
		assertNotNull(textField.getImage());
	}

}
