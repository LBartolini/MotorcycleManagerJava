package Exceptions;


public class ValueNotInRangeException extends Exception {
	
	private static final long serialVersionUID = 1L;

	public ValueNotInRangeException(String messaggio) {
		super(messaggio);
	}
	
	public ValueNotInRangeException() {
		super();
	}
	
}
