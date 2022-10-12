package core.stile_guida;

public abstract class StileGuida {
	
	private final double moltiplicatoreCaduta, moltiplicatorePrestazione;
	
	public StileGuida(double moltiplicatoreCaduta, double moltiplicatorePrestazione) {
		this.moltiplicatoreCaduta = moltiplicatoreCaduta;
		this.moltiplicatorePrestazione = moltiplicatorePrestazione;
	}
	
	public final double getMoltiplicatoreCaduta() {
		return moltiplicatoreCaduta;
	}
	
	public final double getMoltiplicatorePrestazione() {
		return moltiplicatorePrestazione;
	}
	
}
