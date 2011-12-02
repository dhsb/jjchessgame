package exception;

public class IsNotYourTurnException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 3972762222201540487L;

	public IsNotYourTurnException() {
		super("Não é sua Vez de jogar!");
	}
}
