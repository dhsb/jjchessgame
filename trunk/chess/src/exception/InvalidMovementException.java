package exception;

public class InvalidMovementException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7215721451194517311L;

	public InvalidMovementException() {
		super("Movimento inválido");
	}

	/**
	 * 
	 * @param cause
	 *            - a causa domovimento inválido
	 */
	public InvalidMovementException(String cause) {
		super("Movimento inválido - " + cause);
	}
}
