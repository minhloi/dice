package control;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import boundary.GameObject;
import entity.Database;

/**
 * Junit test for ViewRankState class
 * 
 * @author Thien Duc Phung
 * @author Minh Loi
 * @author Daniel Enriquez
 * @author Brett Bauman
 * @author Tanner Siffren
 */

public class ViewRankStateTest {

	@Test
	public void testViewRankState() {
		
		ArrayList<GameObject> objectList = new ArrayList<GameObject>();
		GameController controller = new GameController(objectList);
		Database database = new Database();
		
		// Test if a ViewRankState object is created
		ViewRankState viewRankState = new ViewRankState(controller, objectList, database);
		assertNotNull(viewRankState);
			
	}
	
	@Test
	public void render(){
		
		ArrayList<GameObject> objectList = new ArrayList<GameObject>();
		GameController controller = new GameController(objectList);
		Database database = new Database();
		
		ViewRankState viewRankState = new ViewRankState(controller, objectList, database);
		int initial = objectList.size();
		
		// Test if render method() can add objects to list
		viewRankState.render();
		assertTrue(objectList.size() > initial);
	}
			
}
