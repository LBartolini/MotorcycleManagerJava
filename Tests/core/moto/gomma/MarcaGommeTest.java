package core.moto.gomma;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import core.moto.gomma.marche.Bridgeston;
import core.moto.gomma.marche.Continental;
import core.moto.gomma.marche.Dunlop;
import core.moto.gomma.marche.Michelin;
import core.moto.gomma.marche.Pirelli;
import core.moto.gomma.mescole.GommaBagnatoLeggero;
import core.moto.gomma.mescole.GommaBagnatoPesante;
import core.moto.gomma.mescole.GommaHard;
import core.moto.gomma.mescole.GommaMedia;
import core.moto.gomma.mescole.GommaSoft;
import core.moto.gomma.mescole.GommaStradale;

public class MarcaGommeTest {

	@Test
	public void testGetGommeDisponibiliContainsGomme() {
		MarcaGomme marca = new Dunlop();
		
		List<Gomma> lista = new ArrayList<>();
		lista.add(new GommaStradale());
		lista.add(new GommaBagnatoLeggero());
		
		assertTrue(marca.getGommeDisponibili().containsAll(lista));
		
		lista.add(new GommaHard());
		
		assertFalse(marca.getGommeDisponibili().containsAll(lista));
	}
	
	@Test
	public void testGommaDisponibile() {
		MarcaGomme marca = new Dunlop();
		
		assertTrue(marca.isGommaDisponibile(new GommaStradale()));
		
		assertFalse(marca.isGommaDisponibile(new GommaHard()));
	}
	
	@Test
	public void testBridgestonContainsGomme() {
		MarcaGomme marca = new Bridgeston();
		
		List<Gomma> gomme = new ArrayList<>();
		gomme.add(new GommaStradale());
		gomme.add(new GommaBagnatoLeggero());
		gomme.add(new GommaMedia());
		gomme.add(new GommaHard());
		
		assertTrue(marca.getGommeDisponibili().containsAll(gomme));
		
	}
	
	@Test
	public void testContinentalContainsGomme() {
		MarcaGomme marca = new Continental();
		
		List<Gomma> gomme = new ArrayList<>();
		gomme.add(new GommaStradale());
		gomme.add(new GommaBagnatoLeggero());
		
		assertTrue(marca.getGommeDisponibili().containsAll(gomme));
		
	}
	
	@Test
	public void testPirelliContainsGomme() {
		MarcaGomme marca = new Pirelli();
		
		List<Gomma> gomme = new ArrayList<>();
		gomme.add(new GommaStradale());
		gomme.add(new GommaBagnatoLeggero());
		gomme.add(new GommaMedia());
		gomme.add(new GommaHard());
		gomme.add(new GommaBagnatoPesante());
		gomme.add(new GommaSoft());
		
		assertTrue(marca.getGommeDisponibili().containsAll(gomme));
		
	}
	
	@Test
	public void testDunlopContainsGomme() {
		MarcaGomme marca = new Dunlop();
		
		List<Gomma> gomme = new ArrayList<>();
		gomme.add(new GommaStradale());
		gomme.add(new GommaBagnatoLeggero());
		gomme.add(new GommaMedia());
		
		assertTrue(marca.getGommeDisponibili().containsAll(gomme));
		
	}
	
	@Test
	public void testMetzlerContainsGomme() {
		MarcaGomme marca = new Pirelli();
		
		List<Gomma> gomme = new ArrayList<>();
		gomme.add(new GommaStradale());
		
		assertTrue(marca.getGommeDisponibili().containsAll(gomme));
		
	}
	
	@Test
	public void testMichelinContainsGomme() {
		MarcaGomme marca = new Michelin();
		
		List<Gomma> gomme = new ArrayList<>();
		gomme.add(new GommaStradale());
		gomme.add(new GommaBagnatoLeggero());
		gomme.add(new GommaMedia());
		gomme.add(new GommaHard());
		gomme.add(new GommaBagnatoPesante());
		
		assertTrue(marca.getGommeDisponibili().containsAll(gomme));
		
	}
	
	@Test
	public void testEquals() {
		MarcaGomme pirelli = new Pirelli();
		MarcaGomme dunlop = new Dunlop();
		
		assertTrue(pirelli.equals(pirelli));
		assertFalse(pirelli.equals(dunlop));
		assertTrue(pirelli.equals(new Pirelli()));
		assertFalse(pirelli.equals(null));
		assertFalse(pirelli.equals("Test"));
				
	}
	
}
