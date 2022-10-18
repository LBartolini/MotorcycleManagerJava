package core.moto.gomma;

import java.util.Objects;

import Exceptions.ObjectNotInitializedException;
import core.Meteo;

public abstract class Gomma {
	
	public static final double MODIFICATORE_ADERENZA_METEO_SBAGLIATO = 0.3;
	
	public static final double MODIFICATORE_CADUTA_GOMME_SBAGLIATE = 1.25;
	
	private final int id;
	
	public Gomma(int id) {
		this.id = id;
	}
	
	public abstract double getAderenzaAttuale(int giroAttuale) throws ObjectNotInitializedException;
	
	public abstract void preGara(int giriTotali, Meteo meteo);
	
	protected double getModificatoreMeteoCorretto(Meteo meteo) {
		if((meteo.getPioggiaFinale() > 0 && daAsciutto()) 
				|| 
				(meteo.getPioggiaFinale() == 0 && daBagnato())) {
			return MODIFICATORE_ADERENZA_METEO_SBAGLIATO;
		}
		
		return 1;
	}
	
	public abstract String getNome();
	
	public abstract boolean daAsciutto();
	
	public abstract boolean daBagnato();
	
	@Override
	public boolean equals(Object other) {
		if(Objects.isNull(other)) return false;
		
		Gomma other_gomma;
		
		try {
			other_gomma = (Gomma) other;
		}catch(ClassCastException exc) {
			return false;
		}
		
		return getId() == other_gomma.getId();
	}
	
	public int getId() {
		return id;
	}
	
	public int hashCode() {
		return id;
	}
	
}
