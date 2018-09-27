package service;

import domain.shop.Shop;
import exception.InputException;
import jdk.internal.util.xml.impl.Input;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import tools.Formatter;

/**
 * This service is responsible for the loading of the {@Offer} into the domain
 */
public class XmlInputService implements InputService {
    private Logger logger = LoggerFactory.getLogger(XmlInputService.class);
    private Formatter formatter;

    public void start(String inputFile) throws InputException{
        Shop shop = convertToShop(inputFile);
        printShop(shop);
    }

    public Shop convertToShop(String inputFile) {
        return this.formatter.formatToObject(inputFile);
    }

    public void printShop(Shop shop) {
        System.out.println(shop.getId() + " " + shop.getName());
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
