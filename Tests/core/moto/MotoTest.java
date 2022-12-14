package core.moto;

import static org.junit.Assert.*;

import org.junit.Test;

import Exceptions.GommaSceltaNotInMarcaGommeException;
import core.meteo.Meteo;
import core.moto.gomma.Gomma;
import core.moto.gomma.mescole.GommaBagnatoPesante;
import core.moto.gomma.mescole.GommaStradale;
import core.pilota.Pilota;
import core.scuderia.Scuderia;
import core.scuderia.ScuderiaInterface;
import core.utils.difficolta.Facile;
import core.utils.difficolta.Impossibile;

public class MotoTest {

	@Test
	public void testPreGara() {
		ScuderiaInterface s = Scuderia.create("Pippo", Facile.create());
		Moto m = s.getMoto(0);
		m.setPilota(new Pilota("Lorenzo", "Bartolini", m, 5, 5, 5));
		
		try {
			m.preGara(new GommaStradale(), Meteo.create(15, 0, 20, false), 20);
		} catch (Exception e) {
			fail();
		}

		Gomma gommaStradale = new GommaStradale();

		assertTrue(m.getGommaScelta().equals(gommaStradale));
		 
	}
	
	@Test
	public void testPreGaraBadPath() {
		ScuderiaInterface s = Scuderia.create("Pippo", Impossibile.create());
		Moto m = s.getMoto(0);
		m.setPilota(new Pilota("Lorenzo", "Bartolini", m, 5, 5, 5));
		
		try {
			m.preGara(new GommaBagnatoPesante(), Meteo.create(15, 0, 20, false), 20);
			fail();
		} catch (GommaSceltaNotInMarcaGommeException e) {
			
		} catch (Exception e) {
			fail();
		}
		 
	}
	
	@Test
	public void testEquals() {
		ScuderiaInterface s = Scuderia.create("Pippo", Impossibile.create());
		MotoInterface m1 = null, m2 = null;
		m1 = s.getMoto(0);
		m2 = s.getMoto(1);
		
		assertEquals(m1, m1);
		assertNotEquals(m1, m2);
		assertNotEquals(m1, null);
		assertNotEquals(m1, "test");
	}

}
