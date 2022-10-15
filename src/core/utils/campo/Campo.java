package core.utils.campo;

public abstract class Campo implements CampoInterface {
	
	private int value;
	
	public Campo() {
		value = getMin();
	}
	
	public Campo(int value) {
		set(value);
	}
	
	@Override
	public final int get() {
		return value;
	}
	
	@Override
	public final double getInPercentuale() {
		return (double) value / getMax();
	}
	
	public final void set(int newValue){
		if(newValue < getMin()) {
			value = getMin();
		}
		
		if(newValue > getMax()) {
			value = getMax();
		}
		
		value = newValue;
	}
	
	public final void increment() {
		set(value+1);
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
	public abstract int getMin();
	
	@Override
	public abstract int getMax();

}
