package core;

import Exceptions.ValueNotInRangeException;

public class Meteo {
	
	public static final int MIN_PIOGGIA = 0, MAX_PIOGGIA = 100;
	public static final int MIN_TEMPERATURA = 0, MAX_TEMPERATURA = 50;
	
	private int temperaturaAria;
	private int quantitaPioggia;
	
	public Meteo(int temperaturaAria, int quantitaPioggia) throws ValueNotInRangeException {
		if(temperaturaAria < MIN_TEMPERATURA || temperaturaAria > MAX_TEMPERATURA) throw new ValueNotInRangeException("tempAria not in range");
		if(quantitaPioggia < MIN_PIOGGIA || quantitaPioggia > MAX_PIOGGIA) throw new ValueNotInRangeException("Pioggia not in range");
		
		this.temperaturaAria = temperaturaAria;
		this.quantitaPioggia = quantitaPioggia;
	}

	public int getTemperatura() {
		return temperaturaAria;
	}

	public int getQuantitaPioggia() {
		return quantitaPioggia;
	}
	
}
