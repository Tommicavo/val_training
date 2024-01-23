package exception;

public class InvalidNomeException extends Exception {

	private static final long serialVersionUID = 1L;

	public InvalidNomeException(String msg) {
		super(msg);
	}
}
