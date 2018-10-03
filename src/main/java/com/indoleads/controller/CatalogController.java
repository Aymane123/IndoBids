package com.indoleads.controller;


import com.indoleads.domain.catalogus.Catalog;
import com.indoleads.domain.shop.Shop;
import com.indoleads.service.CatalogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * API Controller to handle requests for a {@Catalog}
 */
@RestController
@RequestMapping("/api/catalog")
public class CatalogController {
    private final CatalogService catalogService;

    @Autowired
    public CatalogController(CatalogService catalogService) {
        this.catalogService = catalogService;
    }

    @RequestMapping(value = "/getCatalog", method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    public ResponseEntity<Catalog> getCatalog() {
        Catalog catalog = catalogService.getCatalogById(1);
        if (catalog != null) {
            return ResponseEntity.ok(catalog);
        } else {
            return ResponseEntity.ok(catalog);
        }
    }

    /**
     * Testmethod
     */
    @RequestMapping(value = "/getShop/", method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    public ResponseEntity<Shop> getShop() {
        //replace with different catalog ID
        String inputFile = "D:\\stageProject\\Indobids\\src\\main\\resources\\2018-08-26_gear_best_5b3b041a7c4b9622d4722ebd.xml";
        Shop shop = catalogService.getShopFromFile(inputFile);
        return ResponseEntity.ok(shop);
    }

    @RequestMapping(value = "/getShopName/", method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    public ResponseEntity<String> getShopName() {
        //shopRepo.getShopName
        String inputFile = "D:\\stageProject\\Indobids\\src\\main\\resources\\2018-08-26_gear_best_5b3b041a7c4b9622d4722ebd.xml";
        Shop shop = catalogService.getShopFromFile(inputFile);
        return ResponseEntity.ok(shop.getName());
    }

    @RequestMapping(value = "/getTargetUrl/", method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    public ResponseEntity<String> getTargetUrl() {
        //shopRepo.getShopName
        String inputFile = "D:\\stageProject\\Indobids\\src\\main\\resources\\2018-08-26_gear_best_5b3b041a7c4b9622d4722ebd.xml";
        Shop shop = catalogService.getShopFromFile(inputFile);
        Catalog catalog = catalogService.getCatalogById(1);
        //String target = catalogService.getTargetUrlForOffer()
        //String target = shop.getOffers().getOffers().
        return ResponseEntity.ok(shop.getName());
    }

}
