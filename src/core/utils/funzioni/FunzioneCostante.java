package core.utils.funzioni;

public class FunzioneCostante implements Funzione{
	
	private int valore;
	
	public FunzioneCostante(int valore) {
		this.valore = valore;
	}

	@Override
	public int getAderenza(int x) {
		return valore;
	}

}
