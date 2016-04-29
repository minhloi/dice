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

}
