package game.moto.gomma.funzioni_aderenza;

import game.moto.gomma.FunzioneAderenza;

public class FunzioneLineare implements FunzioneAderenza {
	
	private int aderenzaIniziale, aderenzaFinale, nGiriTotali;
	
	public FunzioneLineare(int aderenzaIniziale, int aderenzaFinale, int nGiriTotali) {
		this.aderenzaIniziale = aderenzaIniziale;
		this.aderenzaFinale = aderenzaFinale;
		this.nGiriTotali = nGiriTotali;
	}
	
	@Override
	public int getAderenza(int giroAttuale) {
		double m = (aderenzaFinale-aderenzaIniziale)/((double)nGiriTotali-1);
		
		double aderenza = m*(giroAttuale - 1) + aderenzaIniziale;
		
		return (int) aderenza;
	}
	
}
