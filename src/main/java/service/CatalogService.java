package service;

import domain.catalogus.Catalog;
import exception.CommunicationException;
import exception.FileInputException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import repository.CatalogRepository;
import tools.Formatter;

/**
 * This service is responsible for the loading of the {@Catalog} into the domain
 */
@Service
public class CatalogService implements InputService {
    private Logger logger = LoggerFactory.getLogger(CatalogService.class);
    private Formatter formatter;
    private CatalogRepository catalogRepository;

    public void start(String inputFile) throws FileInputException {
        logger.info("CatalogService started...");
        Catalog catalog = convertToShop(inputFile);
        printShop(catalog);
    }

    public Catalog convertToShop(String inputFile) {
        return this.formatter.formatToObject(inputFile);
    }

    public void printShop(Catalog catalog) {
        System.out.println(catalog.getShop().getId() + " " + catalog.getShop().getName());
    }

    @Override
    public void initialize(Formatter formatter, CatalogRepository catalogRepository) throws FileInputException {
        try {
            this.formatter = formatter;
            this.catalogRepository = catalogRepository;
        } catch (Exception ex) {
            logger.error("Could not initialize CatalogService...");
        }
    }

    @Override
    public void shutdown() throws FileInputException {

    }

    @Override
    public Catalog getCatalogFromFile(String inputFile) {
        return convertToShop(inputFile);
    }

    @Override
    public Catalog getCatalogById(int catalogId) {
        try {
            return catalogRepository.getCatalogById(catalogId);
        } catch (CommunicationException ex) {
            logger.error("Could not get catalog from the database...");
        }
        return null;
    }
}
