package game.moto.gomma.funzioni_aderenza;

import static org.junit.Assert.*;

import org.junit.Test;

public class FunzioniAderenzaTest {

	@Test
	public void testFunzioneCostante() {
		FunzioneCostante funzioneCostante = new FunzioneCostante(50);
		
		assertEquals(50, funzioneCostante.getAderenza(1));
	}
	
	@Test
	public void testFunzioneLineare() {
		FunzioneLineare funzioneLineare = new FunzioneLineare(100, 30, 40);
		
		assertEquals(100, funzioneLineare.getAderenza(1));
		assertEquals(30, funzioneLineare.getAderenza(40));
	}

}
