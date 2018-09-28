package exception;

/**
 * Wrapper for anything that goes wrong during conversions to Domain Entitiies
 */
public class FileInputException extends RuntimeException {
    public FileInputException(String message, Exception cause) {
        super(message, cause);
    }
}
