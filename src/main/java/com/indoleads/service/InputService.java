package com.indoleads.service;

import com.indoleads.domain.catalogus.Catalog;
import com.indoleads.exception.InputException;
import com.indoleads.tools.Formatter;

/**
 * An async com.indoleads.service that can be used to receive feeds
 */
public interface InputService {
    /**
     * Start the com.indoleads.service with a defined Formatter
     */
    void start(String inputFile) throws InputException;

    /**
     * Setup communication with the com.indoleads.service (new formatter,...)
     */
    void initialize(Formatter formatter) throws InputException;

    /**
     * End communication (release connection,...)
     */
    void shutdown() throws InputException;

    Catalog getCatalog(String inputFile);

}
