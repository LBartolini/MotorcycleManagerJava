package core.moto.gomma;

import static org.junit.Assert.*;

import org.junit.Test;

import Exceptions.ObjectNotInitializedException;
import Exceptions.ValueNotInRangeException;
import core.meteo.Meteo;
import core.meteo.MeteoInterface;
import core.moto.gomma.mescole.GommaBagnatoLeggero;
import core.moto.gomma.mescole.GommaBagnatoPesante;
import core.moto.gomma.mescole.GommaHard;
import core.moto.gomma.mescole.GommaMedia;
import core.moto.gomma.mescole.GommaSoft;
import core.moto.gomma.mescole.GommaStradale;

public class GommaTest {

	@Test
	public void testGommeEqualsStradaleStradale() {
		Gomma stradale1 = new GommaStradale();
		Gomma stradale2 = new GommaStradale();
		
		assertTrue(stradale1.equals(stradale2));
	}
	
	@Test
	public void testGommeEqualsStradaleSoft() {
		Gomma stradale = new GommaStradale();
		Gomma soft = new GommaSoft();
		
		assertFalse(stradale.equals(soft));
	}
	
	@Test
	public void testGommeEqualsNull() {
		Gomma stradale = new GommaStradale();
		
		assertFalse(stradale.equals(null));
	}
	
	@Test
	public void testGommeEqualsDifferentObject() {
		Gomma stradale = new GommaStradale();
		
		assertFalse(stradale.equals("Gomma Stradale"));
	}
	
	@Test
	public void testGommaBagnatoLeggero() {
		Gomma bagnato_leggero = new GommaBagnatoLeggero();
		
		try {
			bagnato_leggero.preGara(20, Meteo.create(0, 1, 100, false));
		} catch (ValueNotInRangeException e) {fail();}
		
		double valore_pioggia_leggera=0;
		try {
			valore_pioggia_leggera = bagnato_leggero.getAderenzaAttuale(10);
		} catch (Exception e) {fail();}
		
		try {
			bagnato_leggero.preGara(20, Meteo.create(0, 100, 100, false));
		} catch (ValueNotInRangeException e) {fail();}
		
		double valore_pioggia_pesante=0;
		try {
			valore_pioggia_pesante = bagnato_leggero.getAderenzaAttuale(10);
		} catch (Exception e) {fail();}
		
		assertTrue(valore_pioggia_leggera > valore_pioggia_pesante);
	}
	
	@Test
	public void testGommaBagnatoPesante() {
		Gomma bagnato_pesante = new GommaBagnatoPesante();
		
		try {
			bagnato_pesante.preGara(20, Meteo.create(0, 1, 100, false));
		} catch (ValueNotInRangeException e) {fail();}
		
		double valore_pioggia_leggera=0;
		try {
			valore_pioggia_leggera = bagnato_pesante.getAderenzaAttuale(10);
		} catch (Exception e) {fail();}
		
		try {
			bagnato_pesante.preGara(20, Meteo.create(0, 100, 100, false));
		} catch (ValueNotInRangeException e) {fail();}
		
		double valore_pioggia_pesante=0;
		try {
			valore_pioggia_pesante = bagnato_pesante.getAderenzaAttuale(10);
		} catch (Exception e) {fail();}
		
		assertTrue(valore_pioggia_leggera+" "+valore_pioggia_pesante, valore_pioggia_leggera < valore_pioggia_pesante);
	}
	
	@Test
	public void testTemperaturaGommaSoft() throws ValueNotInRangeException, ObjectNotInitializedException {
		MeteoInterface meteo_temp_minima = Meteo.create(Meteo.MIN_TEMPERATURA, 0, 20, false);
		Gomma gomme_temp_minima = new GommaSoft();
		gomme_temp_minima.preGara(20, meteo_temp_minima);
		
		MeteoInterface meteo_temp_media = Meteo.create((Meteo.MIN_TEMPERATURA+Meteo.MAX_TEMPERATURA)/2, 0, 20, false);
		Gomma gomme_temp_media = new GommaSoft();
		gomme_temp_media.preGara(20, meteo_temp_media);
		
		assertTrue(gomme_temp_media.getAderenzaAttuale(3) > gomme_temp_minima.getAderenzaAttuale(3));
	}
	
	@Test
	public void testTemperaturaGommaHard() throws ValueNotInRangeException, ObjectNotInitializedException {
		MeteoInterface meteo_temp_minima = Meteo.create(Meteo.MIN_TEMPERATURA, 0, 20, false);
		Gomma gomme_temp_minima = new GommaHard();
		gomme_temp_minima.preGara(20, meteo_temp_minima);
		
		MeteoInterface meteo_temp_media = Meteo.create((Meteo.MIN_TEMPERATURA+Meteo.MAX_TEMPERATURA)/2, 0, 20, false);
		Gomma gomme_temp_media = new GommaHard();
		gomme_temp_media.preGara(20, meteo_temp_media);
		
		assertTrue(gomme_temp_media.getAderenzaAttuale(3) > gomme_temp_minima.getAderenzaAttuale(3));
	}
	
	@Test
	public void testTemperaturaGommaMedia() throws ValueNotInRangeException, ObjectNotInitializedException {
		MeteoInterface meteo_temp_minima = Meteo.create(Meteo.MIN_TEMPERATURA, 0, 20, false);
		Gomma gomme_temp_minima = new GommaMedia();
		gomme_temp_minima.preGara(20, meteo_temp_minima);
		
		MeteoInterface meteo_temp_media = Meteo.create((Meteo.MIN_TEMPERATURA+Meteo.MAX_TEMPERATURA)/2, 0, 20, false);
		Gomma gomme_temp_media = new GommaMedia();
		gomme_temp_media.preGara(20, meteo_temp_media);
		
		assertTrue(gomme_temp_media.getAderenzaAttuale(3) > gomme_temp_minima.getAderenzaAttuale(3));
	}
	
	@Test
	public void testTemperaturaGommaStradale() throws ValueNotInRangeException, ObjectNotInitializedException {
		MeteoInterface meteo_temp_minima = Meteo.create(Meteo.MIN_TEMPERATURA, 0, 20, false);
		Gomma gomme_temp_minima = new GommaStradale();
		gomme_temp_minima.preGara(20, meteo_temp_minima);
		
		MeteoInterface meteo_temp_media = Meteo.create((Meteo.MIN_TEMPERATURA+Meteo.MAX_TEMPERATURA)/2, 0, 20, false);
		Gomma gomme_temp_media = new GommaStradale();
		gomme_temp_media.preGara(20, meteo_temp_media);
		
		assertEquals(gomme_temp_media.getAderenzaAttuale(3), gomme_temp_minima.getAderenzaAttuale(3), 0.01);
	}
	
}
