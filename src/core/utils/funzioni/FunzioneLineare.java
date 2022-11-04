package core.utils.funzioni;

public class FunzioneLineare implements Funzione{
	
	private double valoreIniziale, valoreFinale, xIniziale, xFinale;
	
	public FunzioneLineare(Number valoreIniziale, Number valoreFinale, Number xFinale) {
		this(valoreIniziale, valoreFinale, 1, xFinale);
	}
	
	public FunzioneLineare(Number valoreIniziale, Number valoreFinale, Number xIniziale, Number xFinale) {
		this.valoreIniziale = valoreIniziale.doubleValue();
		this.valoreFinale = valoreFinale.doubleValue();
		this.xIniziale = xIniziale.doubleValue();
		this.xFinale = xFinale.doubleValue();
	}
	
	@Override
	public Number getValue(Number x) {
		double m = (valoreFinale-valoreIniziale)/(xFinale-xIniziale);
		
		Number valore = m*(x.doubleValue()-xIniziale)+valoreIniziale;
		
		return valore;
	}
}
