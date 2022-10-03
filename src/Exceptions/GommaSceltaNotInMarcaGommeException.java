package Exceptions;

public class GommaSceltaNotInMarcaGommeException extends Exception {
	
	private static final long serialVersionUID = 1L;

	public GommaSceltaNotInMarcaGommeException(String messaggio) {
		super(messaggio);
	}
	
	public GommaSceltaNotInMarcaGommeException() {
		super();
	}
}
