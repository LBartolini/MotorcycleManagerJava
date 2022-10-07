package Exceptions;

public class ObjectNotInitializedException extends Exception{

	private static final long serialVersionUID = 1L;

	public ObjectNotInitializedException() {
		super();
	}
	
	public ObjectNotInitializedException(String message) {
		super(message);
	}
	
}
