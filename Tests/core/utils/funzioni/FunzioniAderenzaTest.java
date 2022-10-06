package core.utils.funzioni;

import static org.junit.Assert.*;

import org.junit.Test;

import core.utils.funzioni.FunzioneCostante;
import core.utils.funzioni.FunzioneLineare;

public class FunzioniAderenzaTest {

	@Test
	public void testFunzioneCostante() {
		FunzioneCostante funzioneCostante = new FunzioneCostante(50, 10);
		
		assertEquals(50, funzioneCostante.getValue(1));
	}
	
	@Test
	public void testFunzioneLineare() {
		FunzioneLineare funzioneLineare = new FunzioneLineare(100, 30, 40);
		
		assertEquals(100, funzioneLineare.getValue(1));
		assertEquals(30, funzioneLineare.getValue(40));
	}

}
