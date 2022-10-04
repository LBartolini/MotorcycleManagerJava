package game.moto.gomma;

import static org.junit.Assert.*;

import org.junit.Test;

import game.moto.gomma.mescole.GommaSoft;
import game.moto.gomma.mescole.GommaStradale;

public class GommaTest {

	@Test
	public void testGommeEqualsStradaleStradale() {
		Gomma stradale1 = new GommaStradale();
		Gomma stradale2 = new GommaStradale();
		
		assertTrue(stradale1.equals(stradale2));
	}
	
	@Test
	public void testGommeEqualsStradaleSoft() {
		Gomma stradale = new GommaStradale();
		Gomma soft = new GommaSoft();
		
		assertFalse(stradale.equals(soft));
	}
	
	@Test
	public void testGommeEqualsDifferentObject() {
		Gomma stradale = new GommaStradale();
		
		assertFalse(stradale.equals("Gomma Stradale"));
	}

}
