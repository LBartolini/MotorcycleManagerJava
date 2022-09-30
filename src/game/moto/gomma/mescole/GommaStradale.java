package game.moto.gomma.mescole;

import game.moto.gomma.FunzioneAderenza;
import game.moto.gomma.Gomma;
import game.moto.gomma.funzioni_aderenza.FunzioneLineare;
import game.utils.GameConstants;

public class GommaStradale implements Gomma {
	
	private FunzioneAderenza funzAderenza;

	@Override
	public int getAderenzaAttuale(int giroAttuale) throws Exception {
		return funzAderenza.getAderenza(giroAttuale);
	}

	@Override
	public void initPreGara(int giriTotali) {
		funzAderenza = new FunzioneLineare(GameConstants.gomme.ADERENZA_INIZIALE_GOMME_STRADALI, GameConstants.gomme.ADERENZA_FINALE_GOMME_STRADALI, giriTotali);
	}

	@Override
	public boolean daAsciutto() {
		return true;
	}

	@Override
	public boolean daBagnato() {
		return true;
	}

	@Override
	public String getNome() {
		return "Gomma da Stradale";
	}

}
