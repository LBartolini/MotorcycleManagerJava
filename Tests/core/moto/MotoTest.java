package core.moto;

import static org.junit.Assert.*;

import org.junit.Test;

import Exceptions.GommaSceltaNotInMarcaGommeException;
import core.moto.gomma.Gomma;
import core.moto.gomma.mescole.GommaBagnatoPesante;
import core.moto.gomma.mescole.GommaStradale;
import core.utils.difficolta.Facile;
import core.utils.difficolta.Impossibile;

public class MotoTest {

	@Test
	public void testPreGara() {
		Moto m = new Moto(null, null, new Facile());
		
		
		try {
			m.preGara(new GommaStradale());
		} catch (GommaSceltaNotInMarcaGommeException e) {
			fail();
		}

		Gomma gommaStradale = new GommaStradale();

		assertTrue(m.getGommaScelta().equals(gommaStradale));
		 
	}
	
	@Test
	public void testPreGaraBadPath() {
		Moto m = new Moto(null, null, new Impossibile());
		
		
		try {
			m.preGara(new GommaBagnatoPesante());
			fail();
		} catch (GommaSceltaNotInMarcaGommeException e) {
			assertTrue(true);
		}
		 
	}
	
	@Test
	public void testEquals() {
		Moto m1 = new Moto(null, null, new Impossibile());
		Moto m2 = new Moto(null, null, new Impossibile());
		
		assertEquals(m1, m1);
		assertNotEquals(m1, m2);
		assertNotEquals(m1, null);
		assertNotEquals(m1, "test");
	}

}
