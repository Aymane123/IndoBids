package exception;

/**
 * Wrapper for anything that goes wrong during de communication with external services
 */
public class CommunicationException extends RuntimeException {
    public CommunicationException(String message, Exception cause) {
        super(message, cause);
    }
}