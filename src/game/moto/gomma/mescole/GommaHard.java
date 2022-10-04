package game.moto.gomma.mescole;

import game.moto.gomma.Gomma;
import game.moto.gomma.funzioni_aderenza.FunzioneAderenza;
import game.moto.gomma.funzioni_aderenza.FunzioneLineare;
import game.utils.constants.gomme.Hard;

public class GommaHard extends Gomma{
	
	private FunzioneAderenza funzAderenza;

	@Override
	public int getAderenzaAttuale(int giroAttuale) throws Exception {
		if(funzAderenza == null) throw new Exception("Call initPregara before this method!");
		
		return funzAderenza.getAderenza(giroAttuale);
	}

	@Override
	public void initPreGara(int giriTotali) {
		funzAderenza = new FunzioneLineare(Hard.ADERENZA_INIZIALE, Hard.ADERENZA_FINALE, giriTotali);
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
		return "Gomma Hard";
	}
	
}
