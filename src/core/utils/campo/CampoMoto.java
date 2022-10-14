package core.utils.campo;

public class CampoMoto extends Campo {
	
	private static final int MIN=1, MAX=30;
	
	public CampoMoto(int value) {
		super(value);
	}
	
	public CampoMoto() {	
		super();
	}

	@Override
	public int getMin() {
		return MIN;
	}

	@Override
	public int getMax() {
		return MAX;
	}

}
