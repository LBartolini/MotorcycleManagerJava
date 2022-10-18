package core;

import static org.junit.Assert.*;

import org.junit.Test;

import core.moto.Moto;
import core.scuderia.Scuderia;
import core.scuderia.ScuderiaInterface;
import core.utils.difficolta.Facile;

public class ScuderiaTest {

	@Test
	public void testAggiuntaMoto() {
		ScuderiaInterface s = new Scuderia("test", new Facile());
		Moto m1 = new Moto(s, new Facile());
		Moto m2 = s.getMoto(1);
		
		assertFalse(s.isMotoIn(m1));
		
		assertTrue(s.isMotoIn(m2));
	}

}
