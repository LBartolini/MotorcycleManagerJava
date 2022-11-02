package core.utils.funzioni;

public class FunzioneCostante<T extends Number> extends FunzioneLineare<T>{
	
	public FunzioneCostante(T valore, T xFinale) {
		super(valore, valore, xFinale);
	}
	
	public FunzioneCostante(T valore, T xIniziale, T xFinale) {
		super(valore, valore, xIniziale, xFinale);
	}

}
