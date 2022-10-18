package core;

import java.util.Random;

import Exceptions.ValueNotInRangeException;
import core.utils.funzioni.Funzione;
import core.utils.funzioni.FunzioneLineareInt;

public class Meteo {
	
	public static final int MIN_PIOGGIA = 0, MAX_PIOGGIA = 100;
	public static final int MIN_TEMPERATURA = 0, MAX_TEMPERATURA = 50;
	public static final int MASSIMA_VARIAZIONE_METEO = 30;
	
	public static final double MODIFICATORE_PROB_CADUTA_CON_PIOGGIA = 1.1;
	
	private int temperaturaFinale, pioggiaFinale;
	
	private Funzione<Integer> variazioneTemperatura, variazionePioggia;
	
	public Meteo(int temperaturaAriaIniziale, int quantitaPioggiaIniziale, int nGiri, boolean meteoVariabile) throws ValueNotInRangeException {
		if(temperaturaAriaIniziale < MIN_TEMPERATURA || temperaturaAriaIniziale > MAX_TEMPERATURA) throw new ValueNotInRangeException("tempAria not in range");
		if(quantitaPioggiaIniziale < MIN_PIOGGIA || quantitaPioggiaIniziale > MAX_PIOGGIA) throw new ValueNotInRangeException("Pioggia not in range");
		
		Random r = new Random();
		
		if(meteoVariabile) {
			this.temperaturaFinale = temperaturaAriaIniziale*(100 - r.nextInt(MASSIMA_VARIAZIONE_METEO)+1)/100;
			this.pioggiaFinale = quantitaPioggiaIniziale*(100 - r.nextInt(MASSIMA_VARIAZIONE_METEO)+1)/100;
		}else {
			this.temperaturaFinale = temperaturaAriaIniziale;
			this.pioggiaFinale = quantitaPioggiaIniziale;
		}
		
		variazioneTemperatura = new FunzioneLineareInt(temperaturaAriaIniziale, temperaturaFinale, nGiri);
		variazionePioggia = new FunzioneLineareInt(quantitaPioggiaIniziale, pioggiaFinale, nGiri);
		
	}

	public int getTemperatura(int giro) {
		return variazioneTemperatura.getValue(giro);
	}

	public int getPioggia(int giro) {
		return variazionePioggia.getValue(giro);
	}
	
	public int getTemperaturaFinale() {
		return temperaturaFinale;
	}
	
	public int getPioggiaFinale() {
		return pioggiaFinale;
	}
	
}
