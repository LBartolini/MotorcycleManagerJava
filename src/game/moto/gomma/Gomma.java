package game.moto.gomma;

public abstract class Gomma {
	
	public static final double MODIFICATORE_MESCOLA_SBAGLIATA = 0.3;
	
	public abstract int getAderenzaAttuale(int giroAttuale) throws Exception;
	
	public abstract void initPreGara(int giriTotali);
	
	public abstract String getNome();
	
	public abstract boolean daAsciutto();
	
	public abstract boolean daBagnato();
	
	@Override
	public boolean equals(Object other) {
		Gomma other_gomma;
		
		try {
			other_gomma = (Gomma) other;
		}catch(ClassCastException exc) {
			return false;
		}
		
		return getNome().equals(other_gomma.getNome());
	}
	
}
