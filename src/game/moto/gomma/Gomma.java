package game.moto.gomma;

public interface Gomma {
	
	public static final double MODIFICATORE_MESCOLA_SBAGLIATA = 0.3;
	
	public int getAderenzaAttuale(int giroAttuale) throws Exception;
	
	public void initPreGara(int giriTotali);
	
	public String getNome();
	
	public boolean daAsciutto();
	
	public boolean daBagnato();
	
	public default boolean equalsTo(Gomma other) {
		return getNome().equals(other.getNome());
	}
	
}
