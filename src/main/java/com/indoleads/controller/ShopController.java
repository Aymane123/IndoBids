package com.indoleads.controller;


import com.indoleads.domain.DTOs.ShopDTO;
import com.indoleads.domain.catalogus.Catalog;
import com.indoleads.domain.shop.Shop;
import com.indoleads.service.CatalogService;
import com.indoleads.service.ShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * API Controller to handle requests for a {@Shop}
 */
@RestController
@RequestMapping("/shop")
@CrossOrigin(origins = "http://localhost:4200", allowedHeaders = "*")
public class ShopController {
    private final ShopService shopService;
    private final CatalogService catalogService;

    @Autowired
    public ShopController(ShopService shopService, CatalogService catalogService) {
        this.shopService = shopService;
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


    @GetMapping("/getShopTest")
    public ResponseEntity<ShopDTO> getShopTest(){
        Shop shop = shopService.getShop();
        ShopDTO shopDTO;

        if (shop != null) {
            shopDTO = new ShopDTO();
            shopDTO.setId(shop.getId());
            shopDTO.setName(shop.getName());
            shopDTO.setUrl(shop.getUrl());
            shopDTO.setLocal_delivery_cost(shop.getLocal_delivery_cost());
            return new ResponseEntity<ShopDTO>(shopDTO, HttpStatus.OK);
        }
        return new ResponseEntity<ShopDTO>(HttpStatus.NOT_ACCEPTABLE);


    }

}
