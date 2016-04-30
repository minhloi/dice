package boundary;

/**
 * The DiceObject class renders dice image
 * and sets location in the panel
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
	
	// Position of the dice objects relative to the game panel
	public static final int DICE1_POSITION_X = Panel.PANEL_1_POSITION_X + Panel.WIDTH - WIDTH - 10;
	public static final int DICE1_POSITION_Y = Panel.PANEL_1_POSITION_Y + 10;
	public static final int DICE2_POSITION_X = Panel.PANEL_2_POSITION_X + Panel.WIDTH - WIDTH - 10;
	public static final int DICE2_POSITION_Y = Panel.PANEL_2_POSITION_Y + 10;
		

	/**
	 * The DiceObject constructor initializes position of the dice
	 * and locattion of resource folder
	 * 
	 * @param positionX position of the dice in the x-axis
	 * @param positionY position of the dice in the y-axis
	 */
	public DiceObject(int positionX, int positionY){
		
		setPosition(positionX, positionY);
		this.resourceFolder = "/dice/";
	}
	
	/**
	 * Render dice image by its number
	 * @param diceNum the dice number
	 */
	public void setImageByDiceNum(int diceNum){
		setImageByPath(resourceFolder + diceNum + ".png");		
	}
		
}