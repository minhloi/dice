package boundary;

import static org.junit.Assert.*;

import org.junit.Test;

import entity.Player;

public class MoveTest {

	@Test
	public void testMove() {
		Move move = new Move(Player.ATTACK, 0 , 0);
		assertNotNull(move);
	}
	
	
	
	public void testSetPosition(){
		Move move = new Move(Player.ATTACK, 0 , 0);
		move.setPosition(10, 20);
		
		assertEquals(10, move.getPositionX());
		assertEquals(20, move.getPositionY());
	}
	
	public void testSetPositionX(){
		Move move = new Move(Player.ATTACK, 0 , 0);
		move.setPositionX(10);
		
		assertEquals(10, move.getPositionX());

	}
	
	public void testSetPositionY(){
		Move move = new Move(Player.ATTACK, 0 , 0);
		move.setPositionY(15);
		
		assertEquals(15, move.getPositionY());

	}
		
}
