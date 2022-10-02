package Exceptions;

public class LivelloMassimoDelParametroException extends Exception{
	
	private static final long serialVersionUID = 1L;

	public LivelloMassimoDelParametroException(String messaggio) {
		super(messaggio);
	}
	
	public LivelloMassimoDelParametroException() {
		super();
	}
}
