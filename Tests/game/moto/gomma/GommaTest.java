package game.moto.gomma;

import static org.junit.Assert.*;

import org.junit.Test;

import game.moto.gomma.mescole.GommaSoft;
import game.moto.gomma.mescole.GommaStradale;

public class GommaTest {

	@Test
	public void testGommeEquals() {
		Gomma stradale1 = new GommaStradale();
		Gomma stradale2 = new GommaStradale();
		Gomma soft = new GommaSoft();
		
		assertTrue(stradale1.equalsTo(stradale2));
		assertFalse(stradale1.equalsTo(soft));
	}

}
