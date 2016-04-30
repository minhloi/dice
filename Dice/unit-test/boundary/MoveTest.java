package boundary;

import static org.junit.Assert.*;

import org.junit.Test;

import entity.Player;

public class MoveTest {

	@Test
	public void testMove() {
		
		// Test if a Move object is created.
		Move move = new Move(Player.ATTACK, 0 , 0);
		assertNotNull(move);
	}
	
	public void testBufferedImageCreated(){
		
		// Test if the BufferedImage is created successfully.
		Move move = new Move(Player.ATTACK, 0 , 0);
		assertNotNull(move.getImage());
	
	}
	
	public void testSetPosition(){
		
		Move move = new Move(Player.ATTACK, 0 , 0);
		
		// Test if the position for a Move object is set
		move.setPosition(10, 20);
		
		assertEquals(10, move.getPositionX());
		assertEquals(20, move.getPositionY());
	
	}
	
	public void testSetPositionX(){
		Move move = new Move(Player.ATTACK, 0 , 0);
		
		// Test if the positionX for a Move object is set
		move.setPositionX(10);
		assertEquals(10, move.getPositionX());

	}
	
	public void testSetPositionY(){
		Move move = new Move(Player.ATTACK, 0 , 0);
		
		// Test if the positionY for a Move object is set
		move.setPositionY(15);
		assertEquals(15, move.getPositionY());

	}
	
	public void testGetPositionX(){
		Move move = new Move(Player.ATTACK, 0 , 0);
		
		// Test if the positionX for a Move object is returned correctly
		move.setPositionX(10);
		assertEquals(10, move.getPositionX());

	}
	
	public void testGetPositionY(){
		Move move = new Move(Player.ATTACK, 0 , 0);
		
		// Test if the positionY for a Move object is returned correctly
		move.setPositionY(15);
		assertEquals(15, move.getPositionY());
	}
}