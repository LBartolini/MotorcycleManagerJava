package core;

import static org.junit.Assert.*;

import org.junit.Test;

import Exceptions.ValueNotInRangeException;

public class MeteoTest {

	@Test
	public void testMeteoNonVariabile() {
		Meteo meteo = null;
		try {
			meteo = new Meteo(25, 0, 20, false);
		} catch (ValueNotInRangeException e) {fail();}
		
		assertEquals(25, meteo.getTemperaturaFinale());
		assertEquals(25, meteo.getTemperatura(10));
	}
	
	@Test
	public void testMeteoVariabile() {
		Meteo meteo = null;
		try {
			meteo = new Meteo(25, 0, 20, true);
		} catch (ValueNotInRangeException e) {fail();}
		
		assertTrue(Math.abs(meteo.getTemperaturaFinale()-25) <= 25*(100 - Meteo.MASSIMA_VARIAZIONE_METEO) / 100);
	}

}
