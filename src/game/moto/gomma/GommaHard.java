package game.moto.gomma;

import game.utils.GameConstants;

public class GommaHard implements Gomma{
	
	private FunzioneAderenzaGomma funzAderenza;
	
	public GommaHard() {
		
	}

	@Override
	public int getAderenzaAttuale(int giroAttuale) throws Exception {
		if(funzAderenza == null) throw new Exception("Call initPregara before this method!");
		
		return funzAderenza.getAderenza(giroAttuale);
	}

	@Override
	public void initPreGara(int giriTotali) {
		funzAderenza = new FunzioneLineareAderenzaGomma(GameConstants.ADERENZA_INIZIALE_GOMME_HARD, GameConstants.ADERENZA_FINALE_GOMME_HARD, giriTotali);
	}

	public static void main(String[] args) throws Exception {
		Gomma gomma = new GommaSoft();
		gomma.initPreGara(50);
		System.out.println(gomma.getAderenzaAttuale(50));
	}
	
}
