package core.utils.funzioni;

import static org.junit.Assert.*;

import org.junit.Test;

import core.Meteo;
import core.moto.gomma.Gomma;

public class FunzioniTest {

	@Test
	public void testFunzioneCostante() {
		Funzione funzioneCostante = new FunzioneCostante(50, 10);
		
		assertEquals(50, funzioneCostante.getValue(1));
	}
	
	@Test
	public void testFunzioneLineare() {
		Funzione funzioneLineare = new FunzioneLineare(100, 30, 40);
		
		assertEquals(100, funzioneLineare.getValue(1));
		assertEquals(30, funzioneLineare.getValue(40));
	}
	
	@Test
	public void testFunzioneParabola() {
		FunzioneParabola funzioneParabola = new FunzioneParabola(
				(Meteo.MAX_TEMPERATURA-Meteo.MIN_TEMPERATURA)/2, 100, 
				Meteo.MAX_TEMPERATURA, Gomma.RIDUZIONE_ADERENZA_CAUSA_TEMPERATURA);
		
		assertEquals(100, funzioneParabola.getValue((Meteo.MAX_TEMPERATURA-Meteo.MIN_TEMPERATURA)/2));
		assertEquals(Gomma.RIDUZIONE_ADERENZA_CAUSA_TEMPERATURA, funzioneParabola.getValue(Meteo.MAX_TEMPERATURA));
		assertEquals(Gomma.RIDUZIONE_ADERENZA_CAUSA_TEMPERATURA, funzioneParabola.getValue(0));
	}

}
