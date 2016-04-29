package boundary;

/**
 * The WinnerTitle displays the player who wins the game at the end of a match
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
	
	/**
 	* WinnerTitle displays the image of who won at the end of a match
	* 
	* @param playerNumber - The number of the player who wins the game
	* @param positionX - The x position of the winner image
	* @param positionY - The y position of the winner image
	**/	
	public WinnerTitle(int playerNumber, int positionX, int positionY){
		
		setPosition(positionX, positionY);
		
		if(playerNumber == 1){
			setImageByPath("/win_title/player1wins.png");
		} else if(playerNumber == 2){
			setImageByPath("/win_title/player2wins.png");
		}
		
	}
}
