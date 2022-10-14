package core.utils.campo;

public class CampoPilota extends Campo {
	
	private static final int MIN=1, MAX=30;
	
	public CampoPilota(int value) {
		super(value);
	}
	
	public CampoPilota() {	
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
