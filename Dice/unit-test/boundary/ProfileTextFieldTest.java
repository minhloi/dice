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
	
	@Test
	public void testSetPosition(){
		ProfileTextField textField = new ProfileTextField();
		
		// Test if the position for the text field is set correctly
		textField.setPosition(10, 20);
		assertEquals(10, textField.getPositionX());
		assertEquals(20, textField.getPositionY());
		
	}
	
	@Test
	public void testSetPositionX(){
		ProfileTextField textField = new ProfileTextField();
		textField.setPositionX(20);
		
		// Test if the positionX for the text field is set successfully
		assertEquals(10, textField.getPositionX());
	}
	
	@Test
	public void testSetPositionY(){
		ProfileTextField textField = new ProfileTextField();
		textField.setPositionY(40);
		
		// Test if the positionY for the text field is set successfully.
		assertEquals(40, textField.getPositionY());
	}
	
	@Test
	public void testGetPositionX(){
		ProfileTextField textField = new ProfileTextField();
		textField.setPositionX(20);
		
		// Test if the positionX for the text field is returned correctly
		assertEquals(10, textField.getPositionX());
	}
	
	@Test
	public void testGetPositionY(){
		ProfileTextField textField = new ProfileTextField();
		textField.setPositionY(40);
		
		// Test if the positionY for the text field is returned correctly
		assertEquals(40, textField.getPositionY());
	}

}
