package core.stile_guida;

public class StileAggressivo extends StileGuida {
	
	private static StileAggressivo obj = null;
	private static final double moltPrestazione = 1.15, moltCaduta = 0.9;
	
	public static StileAggressivo createStile() {
		if(obj == null) {
			obj = new StileAggressivo();
		}
		
		return obj;
	}

	private StileAggressivo() {
		super(moltPrestazione, moltCaduta);
	}
}
