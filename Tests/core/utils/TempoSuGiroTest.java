package core.utils;

import static org.junit.Assert.*;

import org.junit.Test;

import Exceptions.ValueNotInRangeException;
import core.utils.tempo.Tempo;
import core.utils.tempo.TempoInterface;

public class TempoSuGiroTest {

	@Test
	public void testTempoInMillisecondi() {
		TempoInterface tempoSuGiro = Tempo.createTempoFromMillisecondi(5603);
		
		assertEquals(5603, tempoSuGiro.getMillisecondi());
	}
	
	@Test
	public void testToString() {
		TempoInterface tempoSuGiro = null;
		try {
			tempoSuGiro = Tempo.createTempo(1, 4, 59);
		} catch (ValueNotInRangeException e) {
			fail();
		}
		
		assertEquals("1:04:059", tempoSuGiro.toString());
	}
	
	@Test
	public void testConstructorBadPathSecondiNegativi() {
		try {
			Tempo.createTempo(1, -4, 59);
			fail();
		} catch (ValueNotInRangeException e) {}
	}
	
	@Test
	public void testConstructorBadPathSecondiMaggMassimo() {
		try {
			Tempo.createTempo(1, 71, 59);
			fail();
		} catch (ValueNotInRangeException e) {}
	}
	
	@Test
	public void testConstructorBadPathMillisecondiNegativi() {
		try {
			Tempo.createTempo(1, 5, -100);
			fail();
		} catch (ValueNotInRangeException e) {}
	}
	
	@Test
	public void testConstructorBadPathMillisecondiMaggMassimo() {
		try {
			Tempo.createTempo(1, 5, 2000);
			fail();
		} catch (ValueNotInRangeException e) {}
	}
	
	@Test
	public void testCompareTo() {
		Tempo t1 = Tempo.createTempoFromMillisecondi(10100);
		Tempo t2 = Tempo.createTempoFromMillisecondi(10100);
		Tempo t3 = Tempo.createTempoFromMillisecondi(100);
		
		assertTrue(t1.compareTo(t2) == 0);
		assertTrue(t1.compareTo(t3) >= 0);
		assertTrue(t3.compareTo(t1) <= 0);
	}

}
