package core.utils.funzioni;

public class FunzioneLineare<T extends Number> implements Funzione<T>{
	
	private double valoreIniziale, valoreFinale, xIniziale, xFinale;
	
	public FunzioneLineare(T valoreIniziale, T valoreFinale, T xFinale) {
		this.valoreIniziale = valoreIniziale.doubleValue();
		this.valoreFinale = valoreFinale.doubleValue();
		this.xIniziale = 1;
		this.xFinale = xFinale.doubleValue();
	}
	
	public FunzioneLineare(T valoreIniziale, T valoreFinale, T xIniziale, T xFinale) {
		this.valoreIniziale = valoreIniziale.doubleValue();
		this.valoreFinale = valoreFinale.doubleValue();
		this.xIniziale = xIniziale.doubleValue();
		this.xFinale = xFinale.doubleValue();
	}
	
	@Override
	public Number getValue(T x) {
		double m = (valoreFinale-valoreIniziale)/(xFinale-xIniziale);
		
		Number valore = m*(x.doubleValue()-xIniziale)+valoreIniziale;
		
		return valore;
	}
}
