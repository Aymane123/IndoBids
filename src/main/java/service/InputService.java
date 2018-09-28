package service;

import domain.catalogus.Catalog;
import exception.FileInputException;
import repository.CatalogRepository;
import tools.Formatter;

/**
 * An async service that can be used to receive feeds
 */
public interface InputService {
    /**
     * Start the service with a defined Formatter
     */
    void start(String inputFile) throws FileInputException;

    /**
     * Setup communication with the service (new formatter,...)
     */
    void initialize(Formatter formatter, CatalogRepository catalogRepository) throws FileInputException;

    /**
     * End communication (release connection,...)
     */
    void shutdown() throws FileInputException;

    Catalog getCatalogById(int id);

    Catalog getCatalogFromFile(String inputFile);

}
