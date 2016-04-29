package control;

import java.awt.event.KeyEvent;

/**
 * The BattlePhase class demonstates a phase of a match, where the rollWinner
 * causes damage to the rollLoser.
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
