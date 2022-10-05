package core.moto.gomma.mescole;

import core.moto.gomma.Gomma;
import core.moto.gomma.funzioni_aderenza.FunzioneAderenza;
import core.moto.gomma.funzioni_aderenza.FunzioneCostante;
import core.utils.constants.gomme.BagnatoLeggero;

public class GommaBagnatoLeggero extends Gomma{

	public GommaBagnatoLeggero() {
		super(5);
	}

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
