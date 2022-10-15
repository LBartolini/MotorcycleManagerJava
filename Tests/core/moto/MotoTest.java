package core.moto;

import static org.junit.Assert.*;

import org.junit.Test;

import Exceptions.GommaSceltaNotInMarcaGommeException;
import Exceptions.ValueNotInRangeException;
import core.Meteo;
import core.Scuderia;
import core.moto.gomma.Gomma;
import core.moto.gomma.mescole.GommaBagnatoPesante;
import core.moto.gomma.mescole.GommaStradale;
import core.utils.difficolta.Facile;
import core.utils.difficolta.Impossibile;

public class MotoTest {

	@Test
	public void testPreGara() {
		Moto m = null;
		try {
			m = new Moto(new Scuderia("Pippo"), new Facile());
		} catch (ValueNotInRangeException e1) {
			fail();
		}
		
		
		try {
			m.preGara(new GommaStradale(), new Meteo(15, 0, 20, false), 20);
		} catch (GommaSceltaNotInMarcaGommeException | ValueNotInRangeException e) {
			fail();
		}

		Gomma gommaStradale = new GommaStradale();

		assertTrue(m.getGommaScelta().equals(gommaStradale));
		 
	}
	
	@Test
	public void testPreGaraBadPath() {
		Moto m = null;
		try {
			m = new Moto(new Scuderia("Pippo"), new Impossibile());
		} catch (ValueNotInRangeException e1) {
			fail();
		}
		
		
		try {
			m.preGara(new GommaBagnatoPesante(), new Meteo(15, 0, 20, false), 20);
			fail();
		} catch (GommaSceltaNotInMarcaGommeException | ValueNotInRangeException e) {}
		 
	}
	
	@Test
	public void testEquals() {
		Moto m1 = null, m2 = null;
		try {
			m1 = new Moto(new Scuderia("Pippo"), new Impossibile());
			m2 = new Moto(new Scuderia("Pippo2"), new Impossibile());		
		}catch(ValueNotInRangeException e) {
			fail();
		}
		
		assertEquals(m1, m1);
		assertNotEquals(m1, m2);
		assertNotEquals(m1, null);
		assertNotEquals(m1, "test");
	}

}
