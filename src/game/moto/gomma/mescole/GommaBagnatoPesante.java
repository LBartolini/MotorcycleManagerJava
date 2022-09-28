package game.moto.gomma.mescole;

import game.moto.gomma.FunzioneAderenza;
import game.moto.gomma.Gomma;
import game.moto.gomma.funzioni_aderenza.FunzioneCostante;
import game.utils.GameConstants;

public class GommaBagnatoPesante implements Gomma{
	
	private FunzioneAderenza funzAderenza;
	
	@Override
	public int getAderenzaAttuale(int giroAttuale) throws Exception {
		return funzAderenza.getAderenza(giroAttuale);
	}

	@Override
	public void initPreGara(int giriTotali) {
		this.funzAderenza = new FunzioneCostante(GameConstants.gomme.ADERENZA_GOMME_BAGNATO_PESANTE);
	}

	@Override
	public boolean daAsciutto() {
		return false;
	}

	@Override
	public boolean daBagnato() {
		return true;
	}
}
