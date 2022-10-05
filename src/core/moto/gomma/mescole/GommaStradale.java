package core.moto.gomma.mescole;

import core.moto.gomma.Gomma;
import core.moto.gomma.funzioni_aderenza.FunzioneAderenza;
import core.moto.gomma.funzioni_aderenza.FunzioneLineare;
import core.utils.constants.gomme.Stradale;

public class GommaStradale extends Gomma {
	
	private FunzioneAderenza funzAderenza;
	
	public GommaStradale() {
		super(1);
	}

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
