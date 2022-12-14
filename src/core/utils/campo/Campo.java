package core.utils.campo;

public class Campo implements CampoModifiableInterface {
	
	public static Campo createCampoMinDefault(int MIN, int MAX) {
		return new Campo(MIN, MIN, MAX);
	}

	public static Campo createCampo(int value, int MIN, int MAX) {
		return new Campo(value, MIN, MAX);
	}

	private int value;
	private final int MIN, MAX;
	
	private Campo(int value, int MIN, int MAX) {
		this.MIN = MIN;
		this.MAX = MAX;
		set(value);
	}
	
	@Override
	public final int get() {
		return value;
	}
	
	@Override
	public final double getPercentuale() {
		return (double) value / getMax();
	}
	
	@Override
	public final void set(int newValue){
		if(newValue < getMin()) {
			value = getMin();
		}
		
		if(newValue > getMax()) {
			value = getMax();
		}
		
		value = newValue;
	}
	
	@Override
	public final void increment() {
		set(value+1);
	}
	
	@Override
	public final void decrement() {
		set(value-1);
	}
	
	@Override
	public final boolean isMax() {
		return value == getMax();
	}
	
	@Override
	public final boolean isMin() {
		return value == getMin();
	}
	
	@Override
	public final int getMin() {
		return MIN;
	}
	
	@Override
	public final int getMax() {
		return MAX;
	}

}
