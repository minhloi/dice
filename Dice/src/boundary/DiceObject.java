package boundary;

/**
 * The DiceObject class is setting dice location in the game panel
 * 
 * @author Thien Duc Phung
 * @author Minh Loi
 * @author Daniel Enriquez
 * @author Brett Bauman
 * @author Tanner Siffren
 */

public class DiceObject extends GameObject {
	
	private String resourceFolder;

	// Size of the dice panel
	public static final int HEIGHT = 60;
	public static final int WIDTH = 60;
	
	// Position variables of the dice panel in game panel
	public static final int DICE1_POSITION_X = Panel.PANEL_1_POSITION_X + Panel.WIDTH - WIDTH - 10;
	public static final int DICE1_POSITION_Y = Panel.PANEL_1_POSITION_Y + 10;
	public static final int DICE2_POSITION_X = Panel.PANEL_2_POSITION_X + Panel.WIDTH - WIDTH - 10;
	public static final int DICE2_POSITION_Y = Panel.PANEL_2_POSITION_Y + 10;
		
	// Create the dice panel for dice image
	public DiceObject(int positionX, int positionY){
		
		setPosition(positionX, positionY);
		this.resourceFolder = "/dice/";
	}
	
	// Assign dice image into dice panel
	public void setImageByDiceNum(int diceNum){
		setImageByPath(resourceFolder + diceNum + ".png");		
	}
		
}