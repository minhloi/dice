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

public class WinnerTitle extends GameObject {
	
	public static final int HEIGHT = 37;
	public static final int WIDTH = 273;
		
	public WinnerTitle(int playerNumber, int positionX, int positionY){
		
		setPosition(positionX, positionY);
		
		if(playerNumber == 1){
			setImageByPath("/win_title/player1wins.png");
		} else if(playerNumber == 2){
			setImageByPath("/win_title/player2wins.png");
		}
		
	}
}
