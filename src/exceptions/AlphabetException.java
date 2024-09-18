package exceptions;

public class AlphabetException extends RuntimeException {

    public AlphabetException (String message) {
        super(message);
    }

    public AlphabetException (String message, Throwable cause) {
        super(message, cause);
    }
}
