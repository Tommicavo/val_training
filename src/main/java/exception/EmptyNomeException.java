package exception;

public class EmptyNomeException extends Exception {

	private static final long serialVersionUID = 1L;
	
	public EmptyNomeException(String msg) {
		super(msg);
	}
}
