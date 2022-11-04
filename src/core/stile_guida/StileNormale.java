package core.stile_guida;

public class StileNormale extends StileGuida{
	
	private static StileNormale obj = null;
	private static final double moltPrestazione = 1, moltCaduta = 0.7;

	public static StileNormale createStile() {
		if(obj == null) {
			obj = new StileNormale();
		}
		
		return obj;
	}

	private StileNormale() {
		super(moltPrestazione, moltCaduta);
	}

}
