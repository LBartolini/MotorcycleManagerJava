package core.moto.gomma;

import java.util.Objects;

import Exceptions.ObjectNotInitializedException;
import core.Meteo;

public abstract class Gomma {
	
	public static final double MODIFICATORE_MESCOLA_METEO_SBAGLIATO = 0.5;
	public static final int RIDUZIONE_ADERENZA_CAUSA_TEMPERATURA = 70;
	
	private final int id;
	protected Meteo meteo;
	
	public Gomma(int id) {
		this.id = id;
	}
	
	public abstract int getAderenzaAttuale(int giroAttuale) throws ObjectNotInitializedException;
	
	public abstract void initPreGara(int giriTotali, Meteo meteo);
	
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
