package boundary;

import entity.Player;

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
