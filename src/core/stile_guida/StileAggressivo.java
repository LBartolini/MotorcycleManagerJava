package core.stile_guida;

public class StileAggressivo extends StileGuida {
	
	private static final double moltPrestazione = 1.25, moltCaduta = 0.9;
	
	public StileAggressivo() {
		super(moltPrestazione, moltCaduta);
	}
}