package core.meteo;

import java.util.Random;

import Exceptions.ValueNotInRangeException;
import core.utils.funzioni.Funzione;
import core.utils.funzioni.FunzioneLineare;

public class Meteo implements MeteoInterface {
	
	public static final int MIN_PIOGGIA = 0, MAX_PIOGGIA = 100;
	public static final int MIN_TEMPERATURA = 0, MAX_TEMPERATURA = 50;
	public static final int MASSIMA_VARIAZIONE_METEO = 30;
	
	public static final double MODIFICATORE_PROB_CADUTA_CON_PIOGGIA = 1.1;
	
	public static Meteo create(int temperaturaIniziale, int pioggiaIniziale, int nGiri, boolean meteoVariabile)
			throws ValueNotInRangeException {
		return new Meteo(temperaturaIniziale, pioggiaIniziale, nGiri, meteoVariabile);
	}

	private int temperaturaFinale, pioggiaFinale;
	
	private Funzione variazioneTemperatura, variazionePioggia;
	
	private Meteo(int temperaturaIniziale, int pioggiaIniziale, int nGiri, boolean meteoVariabile) throws ValueNotInRangeException {
		if(temperaturaIniziale < MIN_TEMPERATURA || temperaturaIniziale > MAX_TEMPERATURA) throw new ValueNotInRangeException("tempAria not in range");
		if(pioggiaIniziale < MIN_PIOGGIA || pioggiaIniziale > MAX_PIOGGIA) throw new ValueNotInRangeException("Pioggia not in range");
		
		Random r = new Random();
		
		if(meteoVariabile) {
			this.temperaturaFinale = temperaturaIniziale*(100 - r.nextInt(MASSIMA_VARIAZIONE_METEO)+1)/100;
			this.pioggiaFinale = pioggiaIniziale*(100 - r.nextInt(MASSIMA_VARIAZIONE_METEO)+1)/100;
		}else {
			this.temperaturaFinale = temperaturaIniziale;
			this.pioggiaFinale = pioggiaIniziale;
		}
		
		variazioneTemperatura = new FunzioneLineare(temperaturaIniziale, temperaturaFinale, nGiri);
		variazionePioggia = new FunzioneLineare(pioggiaIniziale, pioggiaFinale, nGiri);
		
	}

	@Override
	public int getTemperatura(int giro) {
		return variazioneTemperatura.getValue(giro).intValue();
	}

	@Override
	public int getPioggia(int giro) {
		return variazionePioggia.getValue(giro).intValue();
	}
	
	@Override
	public int getTemperaturaFinale() {
		return temperaturaFinale;
	}
	
	@Override
	public int getPioggiaFinale() {
		return pioggiaFinale;
	}
	
}
