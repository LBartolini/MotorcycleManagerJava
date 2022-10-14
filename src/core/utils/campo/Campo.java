package core.utils.campo;

public abstract class Campo {
	
	private int value;
	
	public Campo() {
		value = getMin();
	}
	
	public Campo(int value) {
		set(value);
	}
	
	public int get() {
		return value;
	}
	
	public void set(int newValue){
		if(newValue < getMin()) {
			value = getMin();
		}
		
		if(newValue > getMax()) {
			value = getMax();
		}
		
		value = newValue;
	}
	
	public void increment() {
		set(value+1);
	}
	
	public boolean isMax() {
		return value == getMax();
	}
	
	public boolean isMin() {
		return value == getMin();
	}
	
	public abstract int getMin();
	
	public abstract int getMax();

}
