package exception;

/**
 * Wrapper for anything that goes wrong during the reading of a feed
 */
public class InputReaderException extends RuntimeException {
    public InputReaderException(String message, Exception cause) {
        super(message, cause);
    }
}