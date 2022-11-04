package core.stile_guida;

public class StileConservativo extends StileGuida {
	
	private static StileConservativo obj = null;
	private static final double moltPrestazione = 0.9, moltCaduta = 0.4;

	public static StileConservativo createStile() {
		if(obj == null) {
			obj = new StileConservativo();
		}
		
		return obj;
	}

	private StileConservativo() {
		super(moltPrestazione, moltCaduta);
	}

}
