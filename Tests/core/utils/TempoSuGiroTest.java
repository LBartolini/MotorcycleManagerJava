package core.utils;

import static org.junit.Assert.*;

import org.junit.Test;

import core.utils.TempoSuGiro;

public class TempoSuGiroTest {

	@Test
	public void testTempoInMillisecondi() {
		TempoSuGiro tempoSuGiro = new TempoSuGiro(5603);
		
		assertEquals(5603, tempoSuGiro.getTempoInMillisecondi());
	}

}
