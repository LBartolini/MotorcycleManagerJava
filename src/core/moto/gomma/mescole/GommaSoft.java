package core.moto.gomma.mescole;

import java.util.Objects;

import Exceptions.ObjectNotInitializedException;
import core.Meteo;
import core.moto.gomma.Gomma;
import core.utils.funzioni.Funzione;
import core.utils.funzioni.FunzioneLineareInt;
import core.utils.funzioni.FunzioneParabolaInt;

public class GommaSoft extends Gomma{
	
	public static final int ADERENZA_INIZIALE = 100;
	public static final int ADERENZA_FINALE = 30; // 1950
	public static final int RIDUZIONE_ADERENZA_TEMPERATURA = 65;
	
	private Meteo meteo;
	
	private Funzione<Integer> funzAderenza;
	private Funzione<Integer> funzTemperaturaAsfalto;
	
	public GommaSoft() {
		super(2);
	}	

	@Override
	public double getAderenzaAttuale(int giroAttuale) throws ObjectNotInitializedException {
		if(Objects.isNull(funzAderenza) || Objects.isNull(meteo)) throw new ObjectNotInitializedException("Call initPregara before this method!");
		
		return funzAderenza.getValue(giroAttuale)*funzTemperaturaAsfalto.getValue(meteo.getTemperatura(giroAttuale))/100*getModificatoreMeteoCorretto(meteo)/100.0;
	}

	@Override
	public void preGara(int giriTotali, Meteo meteo) {
		funzAderenza = new FunzioneLineareInt(ADERENZA_INIZIALE, ADERENZA_FINALE, giriTotali);
		funzTemperaturaAsfalto = new FunzioneParabolaInt((Meteo.MAX_TEMPERATURA-Meteo.MIN_TEMPERATURA)/2, 100, Meteo.MAX_TEMPERATURA, RIDUZIONE_ADERENZA_TEMPERATURA);
		
		this.meteo = meteo;
	}

	@Override
	public boolean daAsciutto() {
		return true;
	}

	@Override
	public boolean daBagnato() {
		return false;
	}

	@Override
	public String getNome() {
		return "Gomma Soft";
	}

}
