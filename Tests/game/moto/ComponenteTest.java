package game.moto;

import static org.junit.Assert.*;

import org.junit.Test;

import Exceptions.LivelloMassimoDelParametroException;
import game.utils.constants.ConstComponente;
import game.utils.constants.difficolta.Difficile;
import game.utils.constants.difficolta.Facile;
import game.utils.constants.difficolta.Impossibile;
import game.utils.constants.difficolta.Intermedia;

public class ComponenteTest {

	@Test
	public void testMinimaResistenzaFacile() {
		Componente componente = new Componente("Test", 1, 1, 
				Facile.MIN_PROB_GUASTO, Facile.MAX_PROB_GUASTO);
		
		assertEquals(Facile.MAX_PROB_GUASTO, componente.getProbabilitaGuasto());
	}
	
	@Test
	public void testMassimaResistenzaFacile() {
		Componente componente = new Componente("Test", 1, ConstComponente.MAX_RESISTENZA, 
				Facile.MIN_PROB_GUASTO, Facile.MAX_PROB_GUASTO);
		
		assertEquals(Facile.MIN_PROB_GUASTO, componente.getProbabilitaGuasto());
	}
	
	@Test
	public void testMinimaResistenzaIntermedia() {
		Componente componente = new Componente("Test", 1, 1, 
				Intermedia.MIN_PROB_GUASTO, Intermedia.MAX_PROB_GUASTO);
		
		assertEquals(Intermedia.MAX_PROB_GUASTO, componente.getProbabilitaGuasto());
	}
	
	@Test
	public void testMassimaResistenzaIntermedia() {
		Componente componente = new Componente("Test", 1, ConstComponente.MAX_RESISTENZA, 
				Intermedia.MIN_PROB_GUASTO, Intermedia.MAX_PROB_GUASTO);
		
		assertEquals(Intermedia.MIN_PROB_GUASTO, componente.getProbabilitaGuasto());
	}
	
	@Test
	public void testMinimaResistenzaDifficile() {
		Componente componente = new Componente("Test", 1, 1, 
				Difficile.MIN_PROB_GUASTO, Difficile.MAX_PROB_GUASTO);
		
		assertEquals(Difficile.MAX_PROB_GUASTO, componente.getProbabilitaGuasto());
	}
	
	@Test
	public void testMassimaResistenzaDifficile() {
		Componente componente = new Componente("Test", 1, ConstComponente.MAX_RESISTENZA, 
				Difficile.MIN_PROB_GUASTO, Difficile.MAX_PROB_GUASTO);
		
		assertEquals(Difficile.MIN_PROB_GUASTO, componente.getProbabilitaGuasto());
	}
	
	@Test
	public void testMinimaResistenzaImpossibile() {
		Componente componente = new Componente("Test", 1, 1, Impossibile.MIN_PROB_GUASTO, Impossibile.MAX_PROB_GUASTO);
		
		assertEquals(Impossibile.MAX_PROB_GUASTO, componente.getProbabilitaGuasto());
	}
	
	@Test
	public void testMassimaResistenzaImpossibile() {
		Componente componente = new Componente("Test", 1, ConstComponente.MAX_RESISTENZA, Impossibile.MIN_PROB_GUASTO, Impossibile.MAX_PROB_GUASTO);
		
		assertEquals(Impossibile.MIN_PROB_GUASTO, componente.getProbabilitaGuasto());
	}
	
	@Test
	public void testIncrementoGrado() {
		Componente componente = new Componente("Test", 3, 1, 1, 1);
		
		try{
			componente.upgradeGrado();
		}catch(Exception e) {}
		
		assertEquals(4, componente.getGrado());
	}
	
	@Test
	public void testIncrementoGradoErroreGradoMassimo() {
		Componente componente = new Componente("Test", ConstComponente.MAX_GRADO, 1, 1, 1);
		
		try{
			componente.upgradeGrado();
			fail("Should raise an Exception");
		}catch(LivelloMassimoDelParametroException exception){
			assertTrue(true);
		}
		
	}
	
	@Test
	public void testIncrementoResistenza() {
		Componente componente = new Componente("Test", 1, 3, 1, 1);
		
		try{
			componente.upgradeResistenza();
		}catch(Exception e) {}
		
		assertEquals(4, componente.getResistenza());
	}
	
	@Test
	public void testIncrementoResistenzaErroreResistenzaMassima() {
		Componente componente = new Componente("Test", 1, ConstComponente.MAX_RESISTENZA, 1, 1);
		
		try{
			componente.upgradeResistenza();
			fail("Should raise an Exception");
		}catch(LivelloMassimoDelParametroException exception){
			assertTrue(true);
		}
	}
	

}
