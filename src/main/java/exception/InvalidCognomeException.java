package exception;

public class InvalidCognomeException extends Exception {

	private static final long serialVersionUID = 1L;

	public InvalidCognomeException(String msg) {
		super(msg);
	}
}
