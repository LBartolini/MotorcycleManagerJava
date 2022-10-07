package core.moto.gomma.mescole;

import java.util.Objects;

import Exceptions.ObjectNotInitializedException;
import core.Meteo;
import core.moto.gomma.Gomma;
import core.utils.funzioni.Funzione;
import core.utils.funzioni.FunzioneCostante;
import core.utils.funzioni.FunzioneParabola;

public class GommaMedia extends Gomma{
	
	public static final int ADERENZA= 45; // 1350
	
	private Funzione funzAderenza;
	private Funzione funzTemperaturaAsfalto;
	
	public GommaMedia() {
		super(3);
	}

	@Override
	public int getAderenzaAttuale(int giroAttuale) throws ObjectNotInitializedException {
		if(Objects.isNull(funzAderenza) || Objects.isNull(meteo)) throw new ObjectNotInitializedException("Call initPregara before this method!");
		
		return funzAderenza.getValue(giroAttuale)*funzTemperaturaAsfalto.getValue(meteo.getTemperatura());
	}

	@Override
	public void initPreGara(int giriTotali, Meteo meteo) {
		funzAderenza = new FunzioneCostante(ADERENZA, giriTotali);
		funzTemperaturaAsfalto = new FunzioneParabola((Meteo.MAX_TEMPERATURA-Meteo.MIN_TEMPERATURA)/2, 100, Meteo.MAX_TEMPERATURA, RIDUZIONE_ADERENZA_CAUSA_TEMPERATURA);
		
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
