package service;

import domain.catalogus.Catalog;
import exception.InputException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import tools.Formatter;

/**
 * This service is responsible for the loading of the {@Catalog} into the domain
 */
public class XmlInputService implements InputService {
    private Logger logger = LoggerFactory.getLogger(XmlInputService.class);
    private Formatter formatter;

    public void start(String inputFile) throws InputException {
        logger.info("IXmlInputService started...");
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
    public void initialize(Formatter formatter) throws InputException {
        try {
            this.formatter = formatter;
        } catch (Exception ex) {
            logger.error("Could not initialize XmlInputService...");
        }
    }

    @Override
    public void shutdown() throws InputException {

    }
}
