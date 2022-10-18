package core.utils.funzioni;

public class FunzioneCostanteInt extends FunzioneLineareInt{
	
	public FunzioneCostanteInt(int valore, int xFinale) {
		super(valore, valore, xFinale);
	}
	
	public FunzioneCostanteInt(int valore, int xIniziale, int xFinale) {
		super(valore, valore, xIniziale, xFinale);
	}

}
