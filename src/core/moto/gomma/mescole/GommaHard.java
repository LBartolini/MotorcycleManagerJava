package core.moto.gomma.mescole;

import java.util.Objects;

import Exceptions.ObjectNotInitializedException;
import core.meteo.Meteo;
import core.meteo.MeteoInterface;
import core.moto.gomma.Gomma;
import core.utils.funzioni.Funzione;
import core.utils.funzioni.FunzioneLineareInt;
import core.utils.funzioni.FunzioneParabolaInt;

public class GommaHard extends Gomma{
	
	public static final int ADERENZA_INIZIALE= 30;
	public static final int ADERENZA_FINALE = 80;
	public static final int RIDUZIONE_ADERENZA_TEMPERATURA = 80;
	
	private MeteoInterface meteo;
	
	private Funzione<Integer> funzAderenza;
	private Funzione<Integer> funzTemperaturaAsfalto;
	
	public GommaHard() {
		super(4);
	}

	@Override
	public double getAderenzaAttuale(int giroAttuale) throws ObjectNotInitializedException {
		if(Objects.isNull(funzAderenza) || Objects.isNull(meteo)) throw new ObjectNotInitializedException("Call initPregara before this method!");		
		
		return (funzAderenza.getValue(giroAttuale) / 100.0) 
				* 
				(funzTemperaturaAsfalto.getValue(meteo.getTemperatura(giroAttuale))/100.0)
				*
				getModificatoreMeteoCorretto(meteo);
	}

	@Override
	public void preGara(int giriTotali, MeteoInterface meteo) {
		funzAderenza = new FunzioneLineareInt(ADERENZA_INIZIALE, ADERENZA_FINALE, giriTotali);
		funzTemperaturaAsfalto = new FunzioneParabolaInt(
				(Meteo.MAX_TEMPERATURA+Meteo.MIN_TEMPERATURA)/2, 
				100, 
				Meteo.MAX_TEMPERATURA, 
				RIDUZIONE_ADERENZA_TEMPERATURA);
		
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
		return "Gomma Hard";
	}
	
}
