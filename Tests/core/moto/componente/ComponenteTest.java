package core.moto.componente;

import static org.junit.Assert.*;

import org.junit.Test;

import core.utils.difficolta.Difficile;
import core.utils.difficolta.Difficolta;
import core.utils.difficolta.Facile;
import core.utils.difficolta.Impossibile;
import core.utils.difficolta.Intermedia;

public class ComponenteTest {

	@Test
	public void testMinimaResistenzaFacile() {
		Difficolta diff = Facile.create();
		ComponenteInterface componente = new Componente("Test", 1, 1, 
				diff.getMinProbabilitaGuasto(), diff.getMaxProbabilitaGuasto());
		
		assertEquals(diff.getMaxProbabilitaGuasto(), componente.getProbabilitaGuasto());
	}
	
	@Test
	public void testMassimaResistenzaFacile() {
		Difficolta diff = Facile.create();
		ComponenteInterface componente = new Componente("Test", 1, Componente.MAX_CAMPO, 
				diff.getMinProbabilitaGuasto(), diff.getMaxProbabilitaGuasto());
		
		assertEquals(diff.getMinProbabilitaGuasto(), componente.getProbabilitaGuasto());
	}
	
	@Test
	public void testMinimaResistenzaIntermedia() {
		Difficolta diff = Intermedia.create();
		ComponenteInterface componente = new Componente("Test", 1, 1, 
				diff.getMinProbabilitaGuasto(), diff.getMaxProbabilitaGuasto());
		
		assertEquals(diff.getMaxProbabilitaGuasto(), componente.getProbabilitaGuasto());
	}
	
	@Test
	public void testMassimaResistenzaIntermedia() {
		Difficolta diff = Intermedia.create();
		ComponenteInterface componente = new Componente("Test", 1, Componente.MAX_CAMPO, 
				diff.getMinProbabilitaGuasto(), diff.getMaxProbabilitaGuasto());
		
		assertEquals(diff.getMinProbabilitaGuasto(), componente.getProbabilitaGuasto());
	}
	
	@Test
	public void testMinimaResistenzaDifficile() {
		Difficolta diff = Difficile.create();
		ComponenteInterface componente = new Componente("Test", 1, 1, 
				diff.getMinProbabilitaGuasto(), diff.getMaxProbabilitaGuasto());
		
		assertEquals(diff.getMaxProbabilitaGuasto(), componente.getProbabilitaGuasto());
	}
	
	@Test
	public void testMassimaResistenzaDifficile() {
		Difficolta diff = Difficile.create();
		ComponenteInterface componente = new Componente("Test", 1, Componente.MAX_CAMPO, 
				diff.getMinProbabilitaGuasto(), diff.getMaxProbabilitaGuasto());
		
		assertEquals(diff.getMinProbabilitaGuasto(), componente.getProbabilitaGuasto());
	}
	
	@Test
	public void testMinimaResistenzaImpossibile() {
		Difficolta diff = Impossibile.create();
		ComponenteInterface componente = new Componente("Test", 1, 1, 
				diff.getMinProbabilitaGuasto(), diff.getMaxProbabilitaGuasto());
		
		assertEquals(diff.getMaxProbabilitaGuasto(), componente.getProbabilitaGuasto());
	}
	
	@Test
	public void testMassimaResistenzaImpossibile() {
		Difficolta diff = Impossibile.create();
		ComponenteInterface componente = new Componente("Test", 1, Componente.MAX_CAMPO, 
				diff.getMinProbabilitaGuasto(), diff.getMaxProbabilitaGuasto());
		
		assertEquals(diff.getMinProbabilitaGuasto(), componente.getProbabilitaGuasto());
	}
	
	@Test
	public void testIncrementoGrado() {
		ComponenteModifiableInterface componente = new Componente("Test", 3, 1, 1, 1);
		
		try{
			componente.upgradeGrado();
		}catch(Exception e) {}
		
		assertEquals(4, componente.getGrado().get());
	}
	
	@Test
	public void testIncrementoResistenza() {
		ComponenteModifiableInterface componente = new Componente("Test", 1, 3, 1, 1);
		
		try{
			componente.upgradeResistenza();
		}catch(Exception e) {}
		
		assertEquals(4, componente.getResistenza().get());
	}
	

}
