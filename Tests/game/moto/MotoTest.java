package game.moto;

import static org.junit.Assert.*;

import org.junit.Test;

import Exceptions.GommaSceltaNotInMarcaGommeException;
import game.moto.gomma.Gomma;
import game.moto.gomma.mescole.GommaBagnatoPesante;
import game.moto.gomma.mescole.GommaStradale;
import game.utils.constants.difficolta.Difficolta;

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

		assertTrue(m.getGommaScelta().equalsTo(gommaStradale));
		 
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
