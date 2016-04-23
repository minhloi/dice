package boundary;

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
