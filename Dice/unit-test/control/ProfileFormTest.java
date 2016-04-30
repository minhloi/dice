package control;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import boundary.GameObject;
import entity.Player;

public class ProfileFormTest {

	@Test
	public void testProfileForm() {
		Player player1 = new Player(1);
		Player player2 = new Player(2);
		ArrayList<GameObject> objectList = new ArrayList<GameObject>();
		
		// Test if a ProfileForm object is created successfully
		ProfileForm form = new ProfileForm(player1, player2, objectList);
		assertNotNull(form);
		
	}

	@Test
	public void testRender() {
		
		Player player1 = new Player(1);
		Player player2 = new Player(2);
		ArrayList<GameObject> objectList = new ArrayList<GameObject>();
		
		ProfileForm form = new ProfileForm(player1, player2, objectList);
		int initial = objectList.size();
		
		// Test if render method add objects to list.
		form.render();
		assertTrue(objectList.size() > initial);
	}

}
