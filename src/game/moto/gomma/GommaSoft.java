package game.moto.gomma;

import game.utils.GameConstants;

public class GommaSoft implements Gomma{
	
	private FunzioneAderenzaGomma funzAderenza;
	
	public GommaSoft() {
		
	}

	@Override
	public int getAderenzaAttuale(int giroAttuale) throws Exception {
		if(funzAderenza == null) throw new Exception("Call initPregara before this method!");
		
		return funzAderenza.getAderenza(giroAttuale);
	}

	@Override
	public void initPreGara(int giriTotali) {
		funzAderenza = new FunzioneLineareAderenzaGomma(GameConstants.ADERENZA_INIZIALE_GOMME_SOFT, GameConstants.ADERENZA_FINALE_GOMME_SOFT, giriTotali);
	}

}
