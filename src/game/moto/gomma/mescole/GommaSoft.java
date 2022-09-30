package game.moto.gomma.mescole;

import game.moto.gomma.FunzioneAderenza;
import game.moto.gomma.Gomma;
import game.moto.gomma.funzioni_aderenza.FunzioneLineare;
import game.utils.GameConstants;

public class GommaSoft implements Gomma{
	
	private FunzioneAderenza funzAderenza;

	@Override
	public int getAderenzaAttuale(int giroAttuale) throws Exception {
		if(funzAderenza == null) throw new Exception("Call initPregara before this method!");
		
		return funzAderenza.getAderenza(giroAttuale);
	}

	@Override
	public void initPreGara(int giriTotali) {
		funzAderenza = new FunzioneLineare(GameConstants.gomme.ADERENZA_INIZIALE_GOMME_SOFT, GameConstants.gomme.ADERENZA_FINALE_GOMME_SOFT, giriTotali);
	}

	@Override
	public boolean daAsciutto() {
		return true;
	}

	@Override
	public boolean daBagnato() {
		return false;
	}

	@Override
	public String getNome() {
		return "Gomma da Soft";
	}

}
