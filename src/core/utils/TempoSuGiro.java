package core.utils;

import Exceptions.ValueNotInRangeException;

public class TempoSuGiro implements Comparable<TempoSuGiro>{
	
	private static final int SECONDI_IN_MINUTO = 60, MILLISECONDI_IN_SECONDO = 1000;
	
	private int minuti, secondi, millisecondi;

	public TempoSuGiro(int minuti, int secondi, int millisecondi) throws ValueNotInRangeException {
		if(secondi<0 || secondi >= SECONDI_IN_MINUTO) throw new ValueNotInRangeException();
		if(millisecondi<0 || millisecondi >= MILLISECONDI_IN_SECONDO) throw new ValueNotInRangeException();
		
		this.minuti = minuti;
		this.secondi = secondi;
		this.millisecondi = millisecondi;
	}
	
	public TempoSuGiro(long totaleMillisecondi) {
		this.millisecondi = (int) (totaleMillisecondi%MILLISECONDI_IN_SECONDO);
		
		int totaleSecondi = (int) (totaleMillisecondi/MILLISECONDI_IN_SECONDO);
		this.secondi = totaleSecondi%SECONDI_IN_MINUTO;
		
		this.minuti = totaleSecondi/SECONDI_IN_MINUTO;
	}
	
	public int getTempoInMillisecondi() {
		return (minuti*SECONDI_IN_MINUTO*MILLISECONDI_IN_SECONDO)+(secondi*MILLISECONDI_IN_SECONDO)+millisecondi;
	}
	
	@Override
	public String toString() {
		return minuti+":"+String.format("%02d", secondi)+":"+String.format("%03d", millisecondi);
	}

	@Override
	public int compareTo(TempoSuGiro o) {
		return getTempoInMillisecondi()-o.getTempoInMillisecondi();
	}
}
