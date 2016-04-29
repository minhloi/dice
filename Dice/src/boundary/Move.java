package boundary;

import entity.Player;

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

public class Move extends GameObject {

	private String resourceFolder;
	
	public Move(int move, int positionX, int positionY){
		
		setPosition(positionX, positionY);
		resourceFolder = "/move";
		
		switch(move){
			case Player.ATTACK:
				setImageByPath(resourceFolder + "/attack.png");
				break;
				
			case Player.BLOCK:
				setImageByPath(resourceFolder + "/block.png");
				break;
				
			case Player.SPECIAL_ATTACK:
				setImageByPath(resourceFolder + "/special.png");
				break;
		}
	}
}
