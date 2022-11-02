package core.moto.gomma.mescole;

import java.util.Objects;

import Exceptions.ObjectNotInitializedException;
import core.meteo.Meteo;
import core.meteo.MeteoInterface;
import core.moto.gomma.Gomma;
import core.utils.funzioni.Funzione;
import core.utils.funzioni.FunzioneLineare;

public class GommaBagnatoLeggero extends Gomma{
	
	public static final int ADERENZA_BASE = 20;
	public static final int ADERENZA_INIZIALE = 20, ADERENZA_FINALE = 5;
	
	private MeteoInterface meteo;

	public GommaBagnatoLeggero() {
		super(5);
	}

	private Funzione<Integer> funzAderenza;
	
	@Override
	public double getAderenzaAttuale(int giroAttuale) throws ObjectNotInitializedException {
		if(Objects.isNull(funzAderenza) || Objects.isNull(meteo)) throw new ObjectNotInitializedException("Call initPregara before this method!");

		return (ADERENZA_BASE + funzAderenza.getValue(meteo.getPioggia(giroAttuale)).doubleValue()
				* getModificatoreMeteoCorretto(meteo)) / 100.0;
	}

	@Override
	public void preGara(int giriTotali, MeteoInterface meteo) {
		this.funzAderenza = new FunzioneLineare<>(ADERENZA_INIZIALE, ADERENZA_FINALE, Meteo.MAX_PIOGGIA);
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
		return "Gomma da Bagnato Leggero";
	}

}
