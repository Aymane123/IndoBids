package com.indoleads.service;

import com.indoleads.domain.catalogus.Catalog;
import com.indoleads.domain.shop.Shop;
import com.indoleads.exception.CommunicationException;
import com.indoleads.exception.FileInputException;
import com.indoleads.repository.ShopRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.indoleads.tools.Formatter;

/**
 * This com.indoleads.service is responsible for the loading of the {@Catalog} into the com.indoleads.domain
 */
@Service
public class CatalogService implements InputService {
    private Logger logger = LoggerFactory.getLogger(CatalogService.class);
    private Formatter formatter;

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

    public void initialize(Formatter formatter) throws FileInputException {
        try {
            this.formatter = formatter;
        } catch (Exception ex) {
            logger.error("Could not initialize CatalogService...");
        }
    }

    @Override
    public Shop getShopById(int shopId) {
        try {
            //return shopRepository.getShopById(shopId);
            return null;
        } catch (CommunicationException ex) {
            logger.error("Could not get catalog from the database...");
        }
        return null;
    }

    @Override
    public Shop getShopFromFile(String inputFile) {
        return convertToShop(inputFile).getShop();
    }

    @Override
    public void shutdown() throws FileInputException {

    }

    /*
    temporary
     */
    public Catalog getCatalogById(int catalogId) {
        try {
            // return shopRepository.getShopById(shopId);
        } catch (CommunicationException ex) {
            logger.error("Could not get catalog from the database...");
        }
        return null;
    }

}
