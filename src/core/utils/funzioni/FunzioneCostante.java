package core.utils.funzioni;

public class FunzioneCostante implements Funzione{
	
	private int valore;
	
	public FunzioneCostante(int valore) {
		this.valore = valore;
	}

	@Override
	public int getValue(int x) {
		return valore;
	}

	@Override
	public int getValoreFinale() {
		return valore;
	}

	@Override
	public void setValoreFinale(int nuovoValore) {
		valore = nuovoValore;
	}

}
