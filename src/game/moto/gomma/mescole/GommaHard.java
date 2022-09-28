package game.moto.gomma.mescole;

import game.moto.gomma.FunzioneAderenza;
import game.moto.gomma.Gomma;
import game.moto.gomma.funzioni_aderenza.FunzioneLineare;
import game.utils.GameConstants;

public class GommaHard implements Gomma{
	
	private FunzioneAderenza funzAderenza;

	@Override
	public int getAderenzaAttuale(int giroAttuale) throws Exception {
		if(funzAderenza == null) throw new Exception("Call initPregara before this method!");
		
		return funzAderenza.getAderenza(giroAttuale);
	}

	@Override
	public void initPreGara(int giriTotali) {
		funzAderenza = new FunzioneLineare(GameConstants.gomme.ADERENZA_INIZIALE_GOMME_HARD, GameConstants.gomme.ADERENZA_FINALE_GOMME_HARD, giriTotali);
	}

	public static void main(String[] args) throws Exception {
		Gomma gomma = new GommaSoft();
		gomma.initPreGara(30);
		System.out.println(gomma.getAderenzaAttuale(30));
	}

	@Override
	public boolean daAsciutto() {
		return true;
	}

	@Override
	public boolean daBagnato() {
		return false;
	}
	
}
