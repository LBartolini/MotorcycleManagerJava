package game.moto.gomma;

public interface Gomma {
	
	public int getAderenzaAttuale(int giroAttuale) throws Exception;
	
	public void initPreGara(int giriTotali);
	
	public boolean daAsciutto();
	
	public boolean daBagnato();
	
}
