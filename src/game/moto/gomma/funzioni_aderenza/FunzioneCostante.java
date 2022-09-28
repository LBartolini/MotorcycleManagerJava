package game.moto.gomma.funzioni_aderenza;

import game.moto.gomma.FunzioneAderenza;

public class FunzioneCostante implements FunzioneAderenza{
	
	private int aderenza;
	
	public FunzioneCostante(int aderenza) {
		this.aderenza = aderenza;
	}

	@Override
	public int getAderenza(int giroAttuale) {
		return aderenza;
	}

}
