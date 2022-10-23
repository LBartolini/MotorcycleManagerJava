package core.utils.tempo;

import Exceptions.ValueNotInRangeException;

public class Tempo implements TempoModifiableInterface{
	
	private static final int SECONDI_IN_MINUTO = 60, MILLISECONDI_IN_SECONDO = 1000;
	
	private long millisecondi;

	public Tempo(int minuti, int secondi, int millisecondi) throws ValueNotInRangeException {
		if(secondi<0 || secondi >= SECONDI_IN_MINUTO) throw new ValueNotInRangeException();
		if(millisecondi<0 || millisecondi >= MILLISECONDI_IN_SECONDO) throw new ValueNotInRangeException();
		
		
		this.millisecondi = minuti*SECONDI_IN_MINUTO*MILLISECONDI_IN_SECONDO 
				+ secondi*MILLISECONDI_IN_SECONDO 
				+ millisecondi;
	}
	
	public Tempo(long totaleMillisecondi) {
		this.millisecondi = totaleMillisecondi;
	}
	
	@Override
	public long getMillisecondi() {
		return millisecondi;
	}
	
	@Override
	public void aggiungiTempo(long millisecondi) {
		this.millisecondi += millisecondi;
	}
	
	@Override
	public String toString() {
		long millisecondi = this.millisecondi%MILLISECONDI_IN_SECONDO;
		
		long totaleSecondi = this.millisecondi/MILLISECONDI_IN_SECONDO;
		long secondi = totaleSecondi%SECONDI_IN_MINUTO;
		
		long minuti = totaleSecondi/SECONDI_IN_MINUTO;
		
		return minuti+":"+String.format("%02d", secondi)+":"+String.format("%03d", millisecondi);
	}

	@Override
	public int compareTo(TempoInterface o) {
		return (int) (getMillisecondi()-o.getMillisecondi());
	}

}
