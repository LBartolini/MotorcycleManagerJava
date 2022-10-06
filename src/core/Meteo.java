package core;

import Exceptions.ValueNotInRangeException;

public class Meteo {
	
	public static final int MIN_PIOGGIA = 0, MAX_PIOGGIA = 100;
	public static final int MIN_TEMP_ARIA = -20, MAX_TEMP_ARIA = 50;
	public static final double RAPPORTO_TEMPERATURA_ARIA_ASFALTO = 1.2;
	
	private int temperaturaAria;
	private int quantitaPioggia;
	
	public Meteo(int temperaturaAria, int quantitaPioggia) throws ValueNotInRangeException {
		if(temperaturaAria < MIN_TEMP_ARIA || temperaturaAria > MAX_TEMP_ARIA) throw new ValueNotInRangeException("tempAria not in range");
		if(quantitaPioggia < MIN_PIOGGIA || quantitaPioggia > MAX_PIOGGIA) throw new ValueNotInRangeException("Pioggia not in range");
		
		this.temperaturaAria = temperaturaAria;
		this.quantitaPioggia = quantitaPioggia;
	}

	public int getTemperaturaAria() {
		return temperaturaAria;
	}

	public int getTemperaturaAsfalto() {
		return (int) (RAPPORTO_TEMPERATURA_ARIA_ASFALTO*temperaturaAria);
	}

	public int getQuantitaPioggia() {
		return quantitaPioggia;
	}
	
}
