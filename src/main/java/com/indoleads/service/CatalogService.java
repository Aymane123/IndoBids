package com.indoleads.service;

import com.indoleads.domain.catalogus.Catalog;
import com.indoleads.exception.InputException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import com.indoleads.tools.Formatter;

/**
 * This com.indoleads.service is responsible for the loading of the {@Catalog} into the com.indoleads.domain
 */
@Service
public class CatalogService implements InputService {
    private Logger logger = LoggerFactory.getLogger(CatalogService.class);
    private Formatter formatter;

    public void start(String inputFile) throws InputException {
        logger.info("IXmlInputService started...");
        Catalog catalog = convertToShop(inputFile);
    }

    public Catalog convertToShop(String inputFile) {
        return this.formatter.formatToObject(inputFile);
    }



    @Override
    public void initialize(Formatter formatter) throws InputException {
        try {
            this.formatter = formatter;
        } catch (Exception ex) {
            logger.error("Could not initialize CatalogService...");
        }
    }

    @Override
    public void shutdown() throws InputException {

    }

    @Override
    public Catalog getCatalog(String inputFile) {
        return convertToShop(inputFile);
    }
}
