package core.moto.gomma.mescole;

import core.moto.gomma.Gomma;
import core.moto.gomma.funzioni_aderenza.FunzioneAderenza;
import core.moto.gomma.funzioni_aderenza.FunzioneLineare;
import core.utils.constants.gomme.Soft;

public class GommaSoft extends Gomma{
	
	public GommaSoft() {
		super(2);
	}

	private FunzioneAderenza funzAderenza;

	@Override
	public int getAderenzaAttuale(int giroAttuale) throws Exception {
		if(funzAderenza == null) throw new Exception("Call initPregara before this method!");
		
		return funzAderenza.getAderenza(giroAttuale);
	}

	@Override
	public void initPreGara(int giriTotali) {
		funzAderenza = new FunzioneLineare(Soft.ADERENZA_INIZIALE, Soft.ADERENZA_FINALE, giriTotali);
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
		return "Gomma Soft";
	}

}
