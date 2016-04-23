package boundary;

public class DiceObject extends GameObject {
	
	private String resourceFolder;

	public static final int HEIGHT = 60;
	public static final int WIDTH = 60;
	
	public static final int DICE1_POSITION_X = Panel.PANEL_1_POSITION_X + Panel.WIDTH - WIDTH - 10;
	public static final int DICE1_POSITION_Y = Panel.PANEL_1_POSITION_Y + 10;
	public static final int DICE2_POSITION_X = Panel.PANEL_2_POSITION_X + Panel.WIDTH - WIDTH - 10;
	public static final int DICE2_POSITION_Y = Panel.PANEL_2_POSITION_Y + 10;
		
	public DiceObject(int positionX, int positionY){
		
		setPosition(positionX, positionY);
		this.resourceFolder = "/dice/";
	}
	
	public void setImageByDiceNum(int diceNum){
		setImageByPath(resourceFolder + diceNum + ".png");		
	}
		
}
