package game.moto.gomma.mescole;

import game.moto.gomma.Gomma;
import game.moto.gomma.funzioni_aderenza.FunzioneAderenza;
import game.moto.gomma.funzioni_aderenza.FunzioneCostante;
import game.utils.constants.gomme.BagnatoLeggero;

public class GommaBagnatoLeggero extends Gomma{

	private FunzioneAderenza funzAderenza;
	
	@Override
	public int getAderenzaAttuale(int giroAttuale) throws Exception {
		return funzAderenza.getAderenza(giroAttuale);
	}

	@Override
	public void initPreGara(int giriTotali) {
		this.funzAderenza = new FunzioneCostante(BagnatoLeggero.ADERENZA);
	}

	@Override
	public boolean daAsciutto() {
		return false;
	}

	@Override
	public boolean daBagnato() {
		return true;
	}

	@Override
	public String getNome() {
		return "Gomma da Bagnato Leggero";
	}

}
