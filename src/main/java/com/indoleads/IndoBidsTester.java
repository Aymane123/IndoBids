package com.indoleads;


import com.indoleads.domain.catalogus.Catalog;
import com.indoleads.repository.ShopRepository;
import com.indoleads.service.CatalogService;
import com.indoleads.service.InputService;
import com.indoleads.tools.Formatter;
import com.indoleads.tools.XmlFormatter;

public class IndoBidsTester {
    public static void main(String[] args) {

        /*String inputFile = "C:\\Users\\School\\Desktop\\SCHOOL jaar 4\\STAGEPROJECT\\stageProject\\Indobids\\src\\main\\resources\\2018-08-26_gear_best_5b3b041a7c4b9622d4722ebd.xml";
        Formatter xmlFormatter = new XmlFormatter();
        ShopRepository shopRepository;
        InputService xmlInputService = new CatalogService();
        IndoBidsController indoBidsController = new IndoBidsController(xmlInputService, xmlFormatter);
        indoBidsController.startConverting(inputFile);
        Catalog catalog = indoBidsController.getCatalog(inputFile);*/




/*
        String inputFile = "D:\\stageProject\\Indobids\\src\\main\\resources\\2018-08-26_gear_best_5b3b041a7c4b9622d4722ebd.xml";
        XmlFormatterCatalog xmlFormatterCatalog = new XmlFormatterCatalog();
        //System.setProperty("javax.xml.accessExternalDTD", "all");
        Catalog catalog = xmlFormatterCatalog.formatToObject(inputFile);
        System.out.println(" Shopname: " + catalog.getShop().getName()+".");
*/
    }

}
