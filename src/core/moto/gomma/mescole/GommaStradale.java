package core.moto.gomma.mescole;

import java.util.Objects;

import Exceptions.ObjectNotInitializedException;
import core.Meteo;
import core.moto.gomma.Gomma;
import core.utils.funzioni.Funzione;
import core.utils.funzioni.FunzioneLineareInt;

public class GommaStradale extends Gomma {
	
	public static final int ADERENZA_INIZIALE = 35;
	public static final int ADERENZA_FINALE = 20; // 750
	
	private Meteo meteo;
	
	private Funzione<Integer> funzAderenza;
	
	public GommaStradale() {
		super(1);
	}

	@Override
	public double getAderenzaAttuale(int giroAttuale) throws ObjectNotInitializedException {
		if(Objects.isNull(funzAderenza) || Objects.isNull(meteo)) throw new ObjectNotInitializedException("Call initPregara before this method!");
		
		return funzAderenza.getValue(giroAttuale)/100.0;
	}

	@Override
	public void preGara(int giriTotali, Meteo meteo) {
		funzAderenza = new FunzioneLineareInt(ADERENZA_INIZIALE, ADERENZA_FINALE, giriTotali);
		this.meteo = meteo;
	}

	@Override
	public boolean daAsciutto() {
		return true;
	}

	@Override
	public boolean daBagnato() {
		return true;
	}

	@Override
	public String getNome() {
		return "Gomma Stradale";
	}

}
