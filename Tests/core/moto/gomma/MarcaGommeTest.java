package core.moto.gomma;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import core.moto.gomma.Gomma;
import core.moto.gomma.MarcaGomme;
import core.moto.gomma.marche.Dunlop;
import core.moto.gomma.mescole.GommaBagnatoLeggero;
import core.moto.gomma.mescole.GommaHard;
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
	
}
