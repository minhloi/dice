package boundary;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;

public class RankingTable extends GameObject {
	
	private static final int WIDTH = GameCanvas.WIDTH;
	private static final int HEIGHT = GameCanvas.HEIGHT - 180;
	
	private static final int DEFAULT_POSITION_X = 0;
	private static final int DEFAULT_POSITION_Y = (GameCanvas.HEIGHT - HEIGHT);
	
	private static final int NAME_WIDTH = 400;
	
	private static final int COLUMN_WIDTH = (WIDTH - NAME_WIDTH) / 3;
	private static final int COLUMN_1 = NAME_WIDTH;
	private static final int COLUMN_2 = COLUMN_1 + COLUMN_WIDTH;
	private static final int COLUMN_3 = COLUMN_2 + COLUMN_WIDTH;
		
	private static final int PADDING_LEFT = 50;
	private static final int PADDING_TOP = 30;
	
	private int currentLine;
	
	public RankingTable(){
		
		image = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_ARGB);		
		setPosition(DEFAULT_POSITION_X, DEFAULT_POSITION_Y);
		
	}
	
	public void drawHeader(){
		
		Graphics2D graphics = image.createGraphics();
		
		graphics.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
		graphics.setFont(new Font("Tahoma", Font.BOLD, 32));
		
		FontMetrics headerMetrics = graphics.getFontMetrics();
		int fontHeight = headerMetrics.getHeight();
		
		currentLine += fontHeight;
		graphics.setColor(new Color(0x2b759a));
		graphics.drawString("Name", PADDING_LEFT, currentLine);
		
		graphics.drawString("Wins", COLUMN_1, currentLine);
		graphics.drawString("Lossess", COLUMN_2, currentLine);
		graphics.drawString("DIFF", COLUMN_3, currentLine);
				
		graphics.dispose();
	}
	
	public void drawPlayerScore(String username, int wins, int losses, int diff){
		
		Graphics2D graphics = image.createGraphics();
		
		graphics.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
		graphics.setFont(new Font("Tahoma", Font.BOLD, 28));
		
		FontMetrics headerMetrics = graphics.getFontMetrics();
		int fontHeight = headerMetrics.getHeight();
		
		currentLine += fontHeight + PADDING_TOP; 
		graphics.setColor(new Color(0x184257));
		graphics.drawString(username, PADDING_LEFT, currentLine);
		graphics.drawString("" + wins, COLUMN_1, currentLine);
		graphics.drawString("" + losses, COLUMN_2, currentLine);
		
		graphics.setColor(Color.BLACK);
		graphics.drawString("" + diff, COLUMN_3, currentLine);
		
		graphics.dispose();
	}
	
	public void drawNoRecords(){
		
Graphics2D graphics = image.createGraphics();
		
		graphics.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
		graphics.setFont(new Font("Tahoma", Font.BOLD, 32));
		
		FontMetrics headerMetrics = graphics.getFontMetrics();
		int fontHeight = headerMetrics.getHeight();
		
		currentLine += fontHeight;
		graphics.setColor(new Color(0x2b759a));
		graphics.drawString("No records found in database.", PADDING_LEFT, currentLine);
		
		graphics.dispose();
	}
	
}
