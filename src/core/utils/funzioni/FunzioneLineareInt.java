package core.utils.funzioni;

public class FunzioneLineareInt implements Funzione<Integer> {
	
	private int valoreIniziale, valoreFinale, xIniziale, xFinale;
	
	public FunzioneLineareInt(int valoreIniziale, int valoreFinale, int xFinale) {
		this.valoreIniziale = valoreIniziale;
		this.valoreFinale = valoreFinale;
		this.xIniziale = 1;
		this.xFinale = xFinale;
	}
	
	public FunzioneLineareInt(int valoreIniziale, int valoreFinale, int xIniziale, int xFinale) {
		this.valoreIniziale = valoreIniziale;
		this.valoreFinale = valoreFinale;
		this.xIniziale = xIniziale;
		this.xFinale = xFinale;
	}
	
	@Override
	public Integer getValue(Integer x) {
		double m = (valoreFinale-valoreIniziale)/((double)xFinale-xIniziale);
		
		double valore = m*(x-xIniziale)+valoreIniziale;
		
		return (int) valore;
	}
	
}
