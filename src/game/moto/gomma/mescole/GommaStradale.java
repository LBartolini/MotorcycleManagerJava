package game.moto.gomma.mescole;

import game.moto.gomma.Gomma;
import game.moto.gomma.funzioni_aderenza.FunzioneAderenza;
import game.moto.gomma.funzioni_aderenza.FunzioneLineare;
import game.utils.constants.gomme.Stradale;

public class GommaStradale extends Gomma {
	
	private FunzioneAderenza funzAderenza;

	@Override
	public int getAderenzaAttuale(int giroAttuale) throws Exception {
		return funzAderenza.getAderenza(giroAttuale);
	}

	@Override
	public void initPreGara(int giriTotali) {
		funzAderenza = new FunzioneLineare(Stradale.ADERENZA_INIZIALE, Stradale.ADERENZA_FINALE, giriTotali);
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
		return "Gomma Stradale";
	}

}
