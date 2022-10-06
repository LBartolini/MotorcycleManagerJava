package core.moto.gomma;

import java.util.Objects;

public abstract class Gomma {
	
	public static final double MODIFICATORE_MESCOLA_SBAGLIATA = 0.3;
	
	private final int id;
	
	public Gomma(int id) {
		this.id = id;
	}
	
	public abstract int getAderenzaAttuale(int giroAttuale) throws Exception;
	
	public abstract void initPreGara(int giriTotali);
	
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
