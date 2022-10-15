package core;

import static org.junit.Assert.*;

import org.junit.Test;

import Exceptions.GommaSceltaNotInMarcaGommeException;
import Exceptions.ObjectNotInitializedException;
import Exceptions.ValueNotInRangeException;
import core.moto.Moto;
import core.moto.gomma.mescole.GommaBagnatoLeggero;
import core.moto.gomma.mescole.GommaMedia;
import core.stile_guida.StileAggressivo;
import core.stile_guida.StileNormale;
import core.utils.TempoSuGiro;
import core.utils.difficolta.Difficile;
import core.utils.difficolta.Facile;

public class PistaTest {

	@Test
	public void testTempoSulGiro() {
		int nGiri = 20;
		
		Pista pista = null;
		try {
			pista = new Pista("Test", 5, 5, 5, 5, nGiri, 100, new TempoSuGiro(1, 30, 0), new Facile());
		} catch (ValueNotInRangeException e2) {
			fail("Errore init Pista");
		}
		Moto moto = null;
		try {
			moto = new Moto(new Scuderia("Pippo Scuderia"), new Facile());
		} catch (ValueNotInRangeException e1) {
			fail("Errore init Moto");
		}
		Pilota pilota = new Pilota("Lorenzo", "Bartolini", moto, 5, 5, 5);
		Meteo meteo = null;
		try {
			meteo = new Meteo(10, 0, nGiri, false);
		} catch (ValueNotInRangeException e1) {
			fail("Errore init Meteo");
		}
		
		pista.initGara(meteo);
		pilota.preGara(new StileNormale());
		try {
			moto.preGara(new GommaMedia(), meteo, nGiri);
		} catch (GommaSceltaNotInMarcaGommeException e) {
			fail("Errore pregara Moto");
		}
		
		
		TempoSuGiro t = null;
		try {
			t = pista.getTempoSulGiro(1, moto, pilota);
		} catch (ObjectNotInitializedException e) {
			fail("Errore getTempoSulGiro");
		}
		
		assertTrue(0 < t.getTempoInMillisecondi());
		assertTrue(pista.getTempoMassimo().compareTo(t) > 0);
	}
	
	@Test
	public void testTempoSulGiroBetweenTwo() {
		int nGiri = 20;
		
		Pista pista = null;
		try {
			pista = new Pista("Test", 5, 5, 5, 5, nGiri, 100, new TempoSuGiro(1, 30, 0), new Facile());
		} catch (ValueNotInRangeException e2) {
			fail("Errore init Pista");
		}
		
		
		Moto moto1 = null;
		try {
			moto1 = new Moto(new Scuderia("Pippo Scuderia"), new Difficile());
		} catch (ValueNotInRangeException e1) {
			fail("Errore init Moto");
		}
		Pilota pilota1 = new Pilota("Lorenzo", "Bartolini", moto1, 5, 5, 5);
		
		
		Moto moto2 = null;
		try {
			moto2 = new Moto(new Scuderia("Pluto Scuderia"), new Facile());
		} catch (ValueNotInRangeException e1) {
			fail("Errore init Moto");
		}
		Pilota pilota2 = new Pilota("Pippo", "Pluto", moto2, 10, 10, 10);
		
		Meteo meteo = null;
		try {
			meteo = new Meteo(10, 0, nGiri, false);
		} catch (ValueNotInRangeException e1) {
			fail("Errore init Meteo");
		}
		
		pista.initGara(meteo);
		pilota1.preGara(new StileNormale());
		pilota2.preGara(new StileAggressivo());
		try {
			moto1.preGara(new GommaBagnatoLeggero(), meteo, nGiri);
			moto2.preGara(new GommaMedia(), meteo, nGiri);
		} catch (GommaSceltaNotInMarcaGommeException e) {
			fail("Errore pregara Moto");
		}
		
		
		TempoSuGiro t1 = null, t2 = null;
		try {
			t1 = pista.getTempoSulGiro(1, moto1, pilota1);
			t2 = pista.getTempoSulGiro(1, moto2, pilota2);
		} catch (ObjectNotInitializedException e) {
			fail("Errore getTempoSulGiro");
		}
		
		System.out.println(t1);
		System.out.println(t2);
		
		assertTrue(0 < t1.getTempoInMillisecondi());
		assertTrue(0 < t2.getTempoInMillisecondi());
		assertTrue(t1.compareTo(t2) > 0);
	}

}
