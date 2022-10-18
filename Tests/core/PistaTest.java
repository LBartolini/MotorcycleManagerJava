package core;

import static org.junit.Assert.*;

import org.junit.Test;

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
		
		Scuderia s = new Scuderia("Scuderia", new Facile());
		Moto moto = s.getMoto(0);
		Pilota pilota = new Pilota("Lorenzo", "Bartolini", moto, 5, 5, 5);
		moto.setPilota(pilota);
		
		Meteo meteo = null;
		try {
			meteo = new Meteo(10, 0, nGiri, false);
		} catch (ValueNotInRangeException e1) {
			fail("Errore init Meteo");
		}
		
		pista.preGara(meteo);
		pilota.preGara(new StileNormale());
		try {
			moto.preGara(new GommaMedia(), meteo, nGiri);
		} catch (Exception e) {
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
		
		Scuderia scuderiaDifficile = new Scuderia("Pippo Scuderia", new Difficile());
		Scuderia scuderiaFacile = new Scuderia("Pluto Scuderia", new Facile());
		
		Moto moto1 = scuderiaDifficile.getMoto(0);
		Pilota pilota1 = new Pilota("Lorenzo", "Bartolini", moto1, 5, 5, 5);
		moto1.setPilota(pilota1);
		
		
		Moto moto2 = scuderiaFacile.getMoto(0);
		Pilota pilota2 = new Pilota("Pippo", "Pluto", moto2, 10, 10, 10);
		moto2.setPilota(pilota2);
		
		Meteo meteo = null;
		try {
			meteo = new Meteo(10, 0, nGiri, false);
		} catch (ValueNotInRangeException e1) {
			fail("Errore init Meteo");
		}
		
		pista.preGara(meteo);
		pilota1.preGara(new StileNormale());
		pilota2.preGara(new StileAggressivo());
		try {
			moto1.preGara(new GommaBagnatoLeggero(), meteo, nGiri);
			moto2.preGara(new GommaMedia(), meteo, nGiri);
		} catch (Exception e) {
			fail("Errore pregara Moto");
		}
		
		
		TempoSuGiro t1 = null, t2 = null;
		try {
			t1 = pista.getTempoSulGiro(1, moto1, pilota1);
			t2 = pista.getTempoSulGiro(1, moto2, pilota2);
		} catch (ObjectNotInitializedException e) {
			fail("Errore getTempoSulGiro");
		}
		
		assertTrue(0 < t1.getTempoInMillisecondi());
		assertTrue(0 < t2.getTempoInMillisecondi());
		assertTrue(t1.compareTo(t2) > 0);
	}

}
