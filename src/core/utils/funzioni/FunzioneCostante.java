package core.utils.funzioni;

public class FunzioneCostante extends FunzioneLineare{
	
	public FunzioneCostante(int valore, int xFinale) {
		super(valore, valore, xFinale);
	}
	
	public FunzioneCostante(int valore, int xIniziale, int xFinale) {
		super(valore, valore, xIniziale, xFinale);
	}

}
