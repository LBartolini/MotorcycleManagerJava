package core.moto.gomma.mescole;

import java.util.Objects;

import Exceptions.ObjectNotInitializedException;
import core.Meteo;
import core.moto.gomma.Gomma;
import core.utils.funzioni.Funzione;
import core.utils.funzioni.FunzioneLineareInt;

public class GommaBagnatoPesante extends Gomma{
	
	public static final int ADERENZA_BASE = 30;
	public static final int ADERENZA_INIZIALE = 5, ADERENZA_FINALE = 30;
	
	private Meteo meteo;
	
	public GommaBagnatoPesante() {
		super(6);
	}

	private Funzione<Integer> funzAderenza;
	
	@Override
	public double getAderenzaAttuale(int giroAttuale) throws ObjectNotInitializedException {
		if(Objects.isNull(funzAderenza) || Objects.isNull(meteo)) throw new ObjectNotInitializedException("Call initPregara before this method!");
		
		return (ADERENZA_BASE+funzAderenza.getValue(meteo.getQuantitaPioggia(giroAttuale))*getModificatoreMeteoCorretto(meteo))/100.0;
	}

	@Override
	public void initPreGara(int giriTotali, Meteo meteo) {
		this.funzAderenza = new FunzioneLineareInt(ADERENZA_INIZIALE, ADERENZA_FINALE, Meteo.MAX_PIOGGIA);
		this.meteo = meteo;
	}

	@Override
	public boolean daAsciutto() {
		return false;
	}

	@Override
	public boolean daBagnato() {
		return true;
	}

	@Override
	public String getNome() {
		return "Gomma da Bagnato Pesante";
	}
	
}
