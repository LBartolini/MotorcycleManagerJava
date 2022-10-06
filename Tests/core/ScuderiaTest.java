package core;

import static org.junit.Assert.*;

import org.junit.Test;

import Exceptions.LivelloMassimoDelParametroException;
import core.moto.Moto;
import core.utils.constants.difficolta.Difficolta;

public class ScuderiaTest {

	@Test
	public void testAggiuntaMoto() {
		Scuderia s = new Scuderia("test");
		Moto m = new Moto(10, s, null, Difficolta.DIFF_FACILE);
		
		try {
			s.addMoto(m);
		} catch (LivelloMassimoDelParametroException e) {
			fail("Exception raised!");
		}
		
		assertTrue(s.getMoto().contains(m));
	}

}
