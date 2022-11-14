package core.utils.campo;

public interface CampoInterface {
	
	// TODO rendere questa classe generica con parametro figlio di Number probabilmente

	int get();

	double getPercentuale();
	
	default double getPercentualeInversa() {
		return 1 - getPercentuale();
	}

	boolean isMax();

	boolean isMin();

	int getMin();

	int getMax();

}