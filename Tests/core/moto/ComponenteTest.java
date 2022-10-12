package core.moto;

import static org.junit.Assert.*;

import org.junit.Test;

import Exceptions.ValueNotInRangeException;
import core.moto.Componente;
import core.utils.difficolta.Difficile;
import core.utils.difficolta.Difficolta;
import core.utils.difficolta.Facile;
import core.utils.difficolta.Impossibile;
import core.utils.difficolta.Intermedia;

public class ComponenteTest {

	@Test
	public void testMinimaResistenzaFacile() {
		Difficolta diff = new Facile();
		Componente componente = new Componente("Test", 1, 1, 
				diff.getMinProbabiitaGuasto(), diff.getMaxProbabiitaGuasto());
		
		assertEquals(diff.getMaxProbabiitaGuasto(), componente.getProbabilitaGuasto());
	}
	
	@Test
	public void testMassimaResistenzaFacile() {
		Difficolta diff = new Facile();
		Componente componente = new Componente("Test", 1, Componente.MAX_RESISTENZA, 
				diff.getMinProbabiitaGuasto(), diff.getMaxProbabiitaGuasto());
		
		assertEquals(diff.getMinProbabiitaGuasto(), componente.getProbabilitaGuasto());
	}
	
	@Test
	public void testMinimaResistenzaIntermedia() {
		Difficolta diff = new Intermedia();
		Componente componente = new Componente("Test", 1, 1, 
				diff.getMinProbabiitaGuasto(), diff.getMaxProbabiitaGuasto());
		
		assertEquals(diff.getMaxProbabiitaGuasto(), componente.getProbabilitaGuasto());
	}
	
	@Test
	public void testMassimaResistenzaIntermedia() {
		Difficolta diff = new Intermedia();
		Componente componente = new Componente("Test", 1, Componente.MAX_RESISTENZA, 
				diff.getMinProbabiitaGuasto(), diff.getMaxProbabiitaGuasto());
		
		assertEquals(diff.getMinProbabiitaGuasto(), componente.getProbabilitaGuasto());
	}
	
	@Test
	public void testMinimaResistenzaDifficile() {
		Difficolta diff = new Difficile();
		Componente componente = new Componente("Test", 1, 1, 
				diff.getMinProbabiitaGuasto(), diff.getMaxProbabiitaGuasto());
		
		assertEquals(diff.getMaxProbabiitaGuasto(), componente.getProbabilitaGuasto());
	}
	
	@Test
	public void testMassimaResistenzaDifficile() {
		Difficolta diff = new Difficile();
		Componente componente = new Componente("Test", 1, Componente.MAX_RESISTENZA, 
				diff.getMinProbabiitaGuasto(), diff.getMaxProbabiitaGuasto());
		
		assertEquals(diff.getMinProbabiitaGuasto(), componente.getProbabilitaGuasto());
	}
	
	@Test
	public void testMinimaResistenzaImpossibile() {
		Difficolta diff = new Impossibile();
		Componente componente = new Componente("Test", 1, 1, 
				diff.getMinProbabiitaGuasto(), diff.getMaxProbabiitaGuasto());
		
		assertEquals(diff.getMaxProbabiitaGuasto(), componente.getProbabilitaGuasto());
	}
	
	@Test
	public void testMassimaResistenzaImpossibile() {
		Difficolta diff = new Impossibile();
		Componente componente = new Componente("Test", 1, Componente.MAX_RESISTENZA, 
				diff.getMinProbabiitaGuasto(), diff.getMaxProbabiitaGuasto());
		
		assertEquals(diff.getMinProbabiitaGuasto(), componente.getProbabilitaGuasto());
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
		Componente componente = new Componente("Test", Componente.MAX_GRADO, 1, 1, 1);
		
		try{
			componente.upgradeGrado();
			fail("Should raise an Exception");
		}catch(ValueNotInRangeException exception){
			return;
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
		Componente componente = new Componente("Test", 1, Componente.MAX_RESISTENZA, 1, 1);
		
		try{
			componente.upgradeResistenza();
			fail("Should raise an Exception");
		}catch(ValueNotInRangeException exception){
			return;
		}
	}
	

}
