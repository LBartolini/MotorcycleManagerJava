package core.utils;

import static org.junit.Assert.*;

import org.junit.Test;

import Exceptions.ValueNotInRangeException;

public class TempoSuGiroTest {

	@Test
	public void testTempoInMillisecondi() {
		TempoSuGiro tempoSuGiro = new TempoSuGiro(5603);
		
		assertEquals(5603, tempoSuGiro.getTempoInMillisecondi());
	}
	
	@Test
	public void testToString() {
		TempoSuGiro tempoSuGiro = null;
		try {
			tempoSuGiro = new TempoSuGiro(1, 4, 59);
		} catch (ValueNotInRangeException e) {
			fail();
		}
		
		assertEquals("1:04:059", tempoSuGiro.toString());
	}
	
	@Test
	public void testConstructorBadPathSecondiNegativi() {
		try {
			new TempoSuGiro(1, -4, 59);
			fail();
		} catch (ValueNotInRangeException e) {}
	}
	
	@Test
	public void testConstructorBadPathSecondiMaggMassimo() {
		try {
			new TempoSuGiro(1, 71, 59);
			fail();
		} catch (ValueNotInRangeException e) {}
	}
	
	@Test
	public void testConstructorBadPathMillisecondiNegativi() {
		try {
			new TempoSuGiro(1, 5, -100);
			fail();
		} catch (ValueNotInRangeException e) {}
	}
	
	@Test
	public void testConstructorBadPathMillisecondiMaggMassimo() {
		try {
			new TempoSuGiro(1, 5, 2000);
			fail();
		} catch (ValueNotInRangeException e) {}
	}
	
	@Test
	public void testCompareTo() {
		TempoSuGiro t1 = new TempoSuGiro(10100);
		TempoSuGiro t2 = new TempoSuGiro(10100);
		TempoSuGiro t3 = new TempoSuGiro(100);
		
		assertTrue(t1.compareTo(t2) == 0);
		assertTrue(t1.compareTo(t3) >= 0);
		assertTrue(t3.compareTo(t1) <= 0);
	}

}
