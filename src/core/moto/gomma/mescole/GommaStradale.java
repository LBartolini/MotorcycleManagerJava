package core.moto.gomma.mescole;

import java.util.Objects;

import Exceptions.ObjectNotInitializedException;
import core.meteo.MeteoInterface;
import core.moto.gomma.Gomma;
import core.utils.funzioni.Funzione;
import core.utils.funzioni.FunzioneLineare;

public class GommaStradale extends Gomma {
	
	public static final int ADERENZA_INIZIALE = 35;
	public static final int ADERENZA_FINALE = 20;
	
	private MeteoInterface meteo;
	
	private Funzione funzAderenza;
	
	public GommaStradale() {
		super(1);
	}

	@Override
	public double getAderenzaAttuale(int giroAttuale) throws ObjectNotInitializedException {
		if(Objects.isNull(funzAderenza) || Objects.isNull(meteo)) throw new ObjectNotInitializedException("Call initPregara before this method!");
		
		return funzAderenza.getValue(giroAttuale).doubleValue() / 100.0;
	}

	@Override
	public void preGara(int giriTotali, MeteoInterface meteo) {
		funzAderenza = new FunzioneLineare(ADERENZA_INIZIALE, ADERENZA_FINALE, giriTotali);
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
