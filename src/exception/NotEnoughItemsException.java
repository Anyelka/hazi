package exception;

public class NotEnoughItemsException extends Exception {

	public NotEnoughItemsException() {
	}

	public NotEnoughItemsException(String message) {
		super(message);
	}

//	public NotEnoughItemsException(Throwable cause) {
//		super(cause);
//	}
//
//	public NotEnoughItemsException(String message, Throwable cause) {
//		super(message, cause);
//	}
//
//	public NotEnoughItemsException(String message, Throwable cause,
//			boolean enableSuppression, boolean writableStackTrace) {
//		super(message, cause, enableSuppression, writableStackTrace);
//	}
}
