package boundary;

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

public class Background extends GameObject {

	public Background(String filename){
		setImageByPath("/background/" + filename);
	}
	
	public void setBackground(String filename){
		setImageByPath("/background/" + filename);
	}
}
