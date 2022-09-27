package game.moto.gomma;

public class FunzioneLineareAderenzaGomma extends FunzioneAderenzaGomma {
	
	private int aderenzaIniziale, aderenzaFinale, nGiriTotali;
	
	public FunzioneLineareAderenzaGomma(int aderenzaIniziale, int aderenzaFinale, int nGiriTotali) {
		this.aderenzaIniziale = aderenzaIniziale;
		this.aderenzaFinale = aderenzaFinale;
		this.nGiriTotali = nGiriTotali;
	}
	
	public int getAderenza(int giroAttuale) {
		double m = (aderenzaIniziale-aderenzaFinale)/(1-nGiriTotali);
		double q = (aderenzaFinale-nGiriTotali*aderenzaIniziale)/(1-nGiriTotali);
		
		// TODO bug non funziona gomme soft
		
		double aderenza = m*giroAttuale+q;
		
		return (int) aderenza;
	}
	
}
