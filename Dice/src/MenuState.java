
public class MenuState extends GameState{

	private String[] menuList; 
	private int menuLength;
	
	public MenuState(){
		
		menuLength = 3;
		menuList = new String[menuLength];
		menuList[0] = "Start game";
		menuList[1] = "View ranking";
		menuList[2] = "Exit";
		
	}
	
	public void print(){
		
		System.out.print("Select menu to start: \n");
		for(int i = 0; i < menuLength; i++){
			
			System.out.print(i + ". " + menuList[i]+ "\n");
			
		}
						
			
	}
	
	
}
