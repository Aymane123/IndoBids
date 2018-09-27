package service;

import exception.InputException;
import tools.Formatter;

/**
 * An async service that can be used to receive feeds
 */
public interface InputService {
    /**
     * Start the service with a defined Formatter
     */
    void start(String inputFile) throws InputException;

    /**
     * Setup communication with the service (new formatter,...)
     */
    void initialize(Formatter formatter) throws InputException;

    /**
     * End communication (release connection,...)
     */
    void shutdown() throws InputException;

}
