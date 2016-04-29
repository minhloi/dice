package control;

import java.awt.event.KeyEvent;

/**
 * The Listenable class is for keys actions
 * 
 * @author Thien Duc Phung
 * @author Minh Loi
 * @author Daniel Enriquez
 * @author Brett Bauman
 * @author Tanner Siffren
 */

public interface Listenable {
	public void onKeyPressed(KeyEvent keyEvent);
	public void onKeyReleased(KeyEvent keyEvent);
	public void onKeyTyped(KeyEvent keyEvent);
}
