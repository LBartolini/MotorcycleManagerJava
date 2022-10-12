package core.moto.gomma.mescole;

import java.util.Objects;

import Exceptions.ObjectNotInitializedException;
import core.Meteo;
import core.moto.gomma.Gomma;
import core.utils.funzioni.Funzione;
import core.utils.funzioni.FunzioneLineare;
import core.utils.funzioni.FunzioneParabola;

public class GommaHard extends Gomma{
	
	public static final int ADERENZA_INIZIALE= 30;
	public static final int ADERENZA_FINALE = 80; // 1650
	public static final int RIDUZIONE_ADERENZA_TEMPERATURA = 80;
	
	private Meteo meteo;
	
	private Funzione funzAderenza;
	private Funzione funzTemperaturaAsfalto;
	
	public GommaHard() {
		super(4);
	}

	@Override
	public int getAderenzaAttuale(int giroAttuale) throws ObjectNotInitializedException {
		if(Objects.isNull(funzAderenza) || Objects.isNull(meteo)) throw new ObjectNotInitializedException("Call initPregara before this method!");		
		
		return funzAderenza.getValue(giroAttuale)*funzTemperaturaAsfalto.getValue(meteo.getTemperatura(giroAttuale));
	}

	@Override
	public void initPreGara(int giriTotali, Meteo meteo) {
		funzAderenza = new FunzioneLineare(ADERENZA_INIZIALE, ADERENZA_FINALE, giriTotali);
		funzTemperaturaAsfalto = new FunzioneParabola((Meteo.MAX_TEMPERATURA-Meteo.MIN_TEMPERATURA)/2, 100, Meteo.MAX_TEMPERATURA, RIDUZIONE_ADERENZA_TEMPERATURA);
		
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
