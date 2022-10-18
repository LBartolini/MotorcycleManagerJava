package core.moto.gomma.mescole;

import java.util.Objects;

import Exceptions.ObjectNotInitializedException;
import core.meteo.Meteo;
import core.meteo.MeteoInterface;
import core.moto.gomma.Gomma;
import core.utils.funzioni.Funzione;
import core.utils.funzioni.FunzioneCostanteInt;
import core.utils.funzioni.FunzioneParabolaInt;

public class GommaMedia extends Gomma{
	
	public static final int ADERENZA= 45; // 1350
	public static final int RIDUZIONE_ADERENZA_TEMPERATURA = 70;
	
	private MeteoInterface meteo;
	
	private Funzione<Integer> funzAderenza;
	private Funzione<Integer> funzTemperaturaAsfalto;
	
	public GommaMedia() {
		super(3);
	}

	@Override
	public double getAderenzaAttuale(int giroAttuale) throws ObjectNotInitializedException {
		if(Objects.isNull(funzAderenza) || Objects.isNull(meteo)) throw new ObjectNotInitializedException("Call initPregara before this method!");
		
		return funzAderenza.getValue(giroAttuale)*funzTemperaturaAsfalto.getValue(meteo.getTemperatura(giroAttuale))/100*getModificatoreMeteoCorretto(meteo)/100.0;
	}

	@Override
	public void preGara(int giriTotali, MeteoInterface meteo) {
		funzAderenza = new FunzioneCostanteInt(ADERENZA, giriTotali);
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
		return "Gomma Media";
	}

}
