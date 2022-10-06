package core.utils.funzioni;

public class FunzioneLineare implements Funzione {
	
	private int valoreIniziale, valoreFinale, xFinale;
	
	public FunzioneLineare(int valoreIniziale, int valoreFinale, int xFinale) {
		this.valoreIniziale = valoreIniziale;
		this.valoreFinale = valoreFinale;
		this.xFinale = xFinale;
	}
	
	@Override
	public int getAderenza(int x) {
		double m = (valoreFinale-valoreIniziale)/((double)xFinale-1);
		
		double aderenza = m*(x - 1) + valoreIniziale;
		
		return (int) aderenza;
	}
	
}
