package core.utils.funzioni;

public class FunzioneLineareDouble implements Funzione<Double>{
	
	private double valoreIniziale, valoreFinale, xIniziale, xFinale;
	
	public FunzioneLineareDouble(double valoreIniziale, double valoreFinale, double xFinale) {
		this.valoreIniziale = valoreIniziale;
		this.valoreFinale = valoreFinale;
		this.xIniziale = 1;
		this.xFinale = xFinale;
	}
	
	public FunzioneLineareDouble(double valoreIniziale, double valoreFinale, double xIniziale, double xFinale) {
		this.valoreIniziale = valoreIniziale;
		this.valoreFinale = valoreFinale;
		this.xIniziale = xIniziale;
		this.xFinale = xFinale;
	}
	
	@Override
	public Double getValue(Double x) {
		double m = (valoreFinale-valoreIniziale)/(xFinale-xIniziale);
		
		double valore = m*(x-xIniziale)+valoreIniziale;
		
		return valore;
	}
}
