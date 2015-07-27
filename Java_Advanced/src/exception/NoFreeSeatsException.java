package exception;

public class NoFreeSeatsException extends Exception {

	public NoFreeSeatsException() {
	}
	
	public NoFreeSeatsException(String message) {
		super(message);
		
	}

}
