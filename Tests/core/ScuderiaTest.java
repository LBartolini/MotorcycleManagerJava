package core;

import static org.junit.Assert.*;

import org.junit.Test;

import Exceptions.ValueNotInRangeException;
import core.moto.Moto;
import core.utils.Difficolta;

public class ScuderiaTest {

	@Test
	public void testAggiuntaMoto() {
		Scuderia s = new Scuderia("test");
		Moto m = new Moto(s, null, Difficolta.FACILE);
		
		try {
			s.addMoto(m);
		} catch (ValueNotInRangeException e) {
			fail("Exception raised!");
		}
		
		assertTrue(s.getMoto().contains(m));
	}

}
