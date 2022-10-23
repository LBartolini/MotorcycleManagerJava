package core.utils;

import static org.junit.Assert.*;

import org.junit.Test;

import Exceptions.ValueNotInRangeException;
import core.utils.tempo.Tempo;
import core.utils.tempo.TempoInterface;

public class TempoSuGiroTest {

	@Test
	public void testTempoInMillisecondi() {
		TempoInterface tempoSuGiro = new Tempo(5603);
		
		assertEquals(5603, tempoSuGiro.getMillisecondi());
	}
	
	@Test
	public void testToString() {
		TempoInterface tempoSuGiro = null;
		try {
			tempoSuGiro = new Tempo(1, 4, 59);
		} catch (ValueNotInRangeException e) {
			fail();
		}
		
		assertEquals("1:04:059", tempoSuGiro.toString());
	}
	
	@Test
	public void testConstructorBadPathSecondiNegativi() {
		try {
			new Tempo(1, -4, 59);
			fail();
		} catch (ValueNotInRangeException e) {}
	}
	
	@Test
	public void testConstructorBadPathSecondiMaggMassimo() {
		try {
			new Tempo(1, 71, 59);
			fail();
		} catch (ValueNotInRangeException e) {}
	}
	
	@Test
	public void testConstructorBadPathMillisecondiNegativi() {
		try {
			new Tempo(1, 5, -100);
			fail();
		} catch (ValueNotInRangeException e) {}
	}
	
	@Test
	public void testConstructorBadPathMillisecondiMaggMassimo() {
		try {
			new Tempo(1, 5, 2000);
			fail();
		} catch (ValueNotInRangeException e) {}
	}
	
	@Test
	public void testCompareTo() {
		Tempo t1 = new Tempo(10100);
		Tempo t2 = new Tempo(10100);
		Tempo t3 = new Tempo(100);
		
		assertTrue(t1.compareTo(t2) == 0);
		assertTrue(t1.compareTo(t3) >= 0);
		assertTrue(t3.compareTo(t1) <= 0);
	}

}
