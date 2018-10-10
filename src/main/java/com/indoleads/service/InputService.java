package com.indoleads.service;

import com.indoleads.domain.catalogus.Catalog;
import com.indoleads.domain.shop.Shop;
import com.indoleads.exception.FileInputException;
import com.indoleads.exception.InputException;
import com.indoleads.tools.Formatter;

/**
 * An async com.indoleads.service that can be used to receive feeds
 */
public interface InputService {
    /**
     * Start the service with a defined Formatter
     */
    void start(String inputFile) throws FileInputException;

    /**
     * Setup communication with the service (new formatter,...)
     */
    void initialize(Formatter formatter) throws FileInputException;

    /**
     * End communication (release connection,...)
     */
    void shutdown() throws FileInputException;

    /**
     * Gets the shop from the catalog by ID
     */
    Shop getShopById(int id);

    /**
     * Gets the Shop from the catalog via a file
     */
    Shop getShopFromFile(String inputFile);

}
