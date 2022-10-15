package core.stile_guida;

public class StileConservativo extends StileGuida {
	
	private static final double moltPrestazione = 0.9, moltCaduta = 0.4;

	public StileConservativo() {
		super(moltPrestazione, moltCaduta);
	}

}
