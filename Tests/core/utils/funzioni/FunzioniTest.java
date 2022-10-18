package core.utils.funzioni;

import static org.junit.Assert.*;

import org.junit.Test;

import core.Meteo;
import core.moto.gomma.mescole.GommaHard;

public class FunzioniTest {

	@Test
	public void testFunzioneCostante() {
		Funzione<Integer> funzioneCostante = new FunzioneCostanteInt(50, 10);
		
		assertEquals(50, (int) funzioneCostante.getValue(1));
	}
	
	@Test
	public void testFunzioneLineare() {
		Funzione<Integer> funzioneLineare = new FunzioneLineareInt(100, 30, 40);
		
		assertEquals(100, (int) funzioneLineare.getValue(1));
		assertEquals(30, (int) funzioneLineare.getValue(40));
	}
	
	@Test
	public void testFunzioneParabola() {
		FunzioneParabolaInt funzioneParabola = new FunzioneParabolaInt(
				(Meteo.MAX_TEMPERATURA-Meteo.MIN_TEMPERATURA)/2, 100, 
				Meteo.MAX_TEMPERATURA, GommaHard.RIDUZIONE_ADERENZA_TEMPERATURA);
		
		assertEquals(100, (int) funzioneParabola.getValue((Meteo.MAX_TEMPERATURA-Meteo.MIN_TEMPERATURA)/2));
		assertEquals(GommaHard.RIDUZIONE_ADERENZA_TEMPERATURA, (int) funzioneParabola.getValue(Meteo.MAX_TEMPERATURA));
		assertEquals(GommaHard.RIDUZIONE_ADERENZA_TEMPERATURA, (int) funzioneParabola.getValue(0));
	}

}
