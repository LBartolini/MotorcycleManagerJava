package core;

import static org.junit.Assert.*;

import org.junit.Test;

import Exceptions.ValueNotInRangeException;
import core.moto.Moto;
import core.utils.difficolta.Facile;

public class ScuderiaTest {

	@Test
	public void testAggiuntaMoto() {
		Scuderia s = new Scuderia("test");
		Moto m = new Moto(s, new Facile());
		
		try {
			s.addMoto(m);
		} catch (ValueNotInRangeException e) {
			fail("Exception raised!");
		}
		
		assertTrue(s.getMoto().contains(m));
	}

}
