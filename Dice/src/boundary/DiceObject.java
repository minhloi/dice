package boundary;

public class DiceObject extends GameObject {
	
	private String resourceFolder;
		
	public DiceObject(int positionX, int positionY){
		
		setPosition(positionX, positionY);
		this.resourceFolder = "/dice/";
	}
	
	public void setImageByDiceNum(int diceNum){
		setImageByPath(resourceFolder + diceNum + ".png");		
	}
		
}
