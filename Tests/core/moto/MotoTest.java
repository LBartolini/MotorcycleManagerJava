package core.moto;

import static org.junit.Assert.*;

import org.junit.Test;

import Exceptions.GommaSceltaNotInMarcaGommeException;
import core.moto.Moto;
import core.moto.gomma.Gomma;
import core.moto.gomma.mescole.GommaBagnatoPesante;
import core.moto.gomma.mescole.GommaStradale;
import core.utils.constants.difficolta.Difficolta;

public class MotoTest {

	@Test
	public void testPreGara() {
		Moto m = new Moto(5, null, null, Difficolta.DIFF_FACILE);
		
		
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
		Moto m = new Moto(5, null, null, Difficolta.DIFF_IMPOSSIBILE);
		
		
		try {
			m.preGara(new GommaBagnatoPesante());
			fail();
		} catch (GommaSceltaNotInMarcaGommeException e) {
			assertTrue(true);
		}
		 
	}

}
