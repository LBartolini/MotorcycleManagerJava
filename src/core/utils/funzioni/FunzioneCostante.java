package core.utils.funzioni;

public class FunzioneCostante extends FunzioneLineare{
	
	public FunzioneCostante(Number valore, Number xFinale) {
		super(valore, valore, xFinale);
	}
	
	public FunzioneCostante(Number valore, Number xIniziale, Number xFinale) {
		super(valore, valore, xIniziale, xFinale);
	}

}
