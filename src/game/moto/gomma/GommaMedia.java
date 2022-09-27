package game.moto.gomma;

import game.utils.GameConstants;

public class GommaMedia implements Gomma{
	
	private FunzioneAderenzaGomma funzAderenza;
	
	public GommaMedia() {
		
	}

	@Override
	public int getAderenzaAttuale(int giroAttuale) throws Exception {
		if(funzAderenza == null) throw new Exception("Call initPregara before this method!");
		
		return funzAderenza.getAderenza(giroAttuale);
	}

	@Override
	public void initPreGara(int giriTotali) {
		funzAderenza = new FunzioneLineareAderenzaGomma(GameConstants.ADERENZA_INIZIALE_GOMME_MEDIE, GameConstants.ADERENZA_FINALE_GOMME_MEDIE, giriTotali);
	}

}
