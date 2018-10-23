package com.indoleads.controller;


import com.indoleads.domain.DTOs.CategoryDTO;
import com.indoleads.domain.DTOs.OfferDTO;
import com.indoleads.domain.DTOs.ShopDTO;
import com.indoleads.domain.category.Category;
import com.indoleads.domain.offer.Offer;
import com.indoleads.domain.offer.Picture;
import com.indoleads.domain.shop.Shop;
import com.indoleads.service.ShopService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * API Controller to handle requests for a {@Shop}
 */
@RestController
@RequestMapping("/shop")
@CrossOrigin(origins = "http://localhost:4200", allowedHeaders = "*")
public class ShopController {
    private Logger logger = LoggerFactory.getLogger(ShopController.class);
    private final ShopService shopService;

    @Autowired
    public ShopController(ShopService shopService) {
        this.shopService = shopService;
    }

    @GetMapping("/getShop")
    public ResponseEntity<ShopDTO> getShop() {
        Shop shop = shopService.getShop();
        ShopDTO shopDTO;
        if (shop != null) {
            shopDTO = makeShopDTO(shop);
            return new ResponseEntity<ShopDTO>(shopDTO, HttpStatus.OK);
        }
        return new ResponseEntity<ShopDTO>(HttpStatus.NOT_ACCEPTABLE);
    }

    @RequestMapping(value = "/getShopOffers/{amount}", method = RequestMethod.GET)
    public ResponseEntity<List<OfferDTO>> getShopOffers(@PathVariable int amount) {
        List<OfferDTO> offerDTOS = new ArrayList<>();
        List<Offer> offers = shopService.getRandomOffers(amount);
        for (Offer offer : offers) {
            List<Category> categories = shopService.getParentAndChildCategoriesOfOffer(offer.getId());
            List<CategoryDTO> categoryDTOList = makeCategoryDTOs(categories);
            OfferDTO dto = makeOfferDTO(offer, categoryDTOList);
            offerDTOS.add(dto);
        }

        if (offers.size() != 0) {
            return new ResponseEntity<List<OfferDTO>>(offerDTOS, HttpStatus.OK);
        }
        return new ResponseEntity<List<OfferDTO>>(HttpStatus.NOT_ACCEPTABLE);
    }

    @RequestMapping(value = {"/getOfferById/{id}"}, method = RequestMethod.GET)
    public ResponseEntity<OfferDTO> getOfferById(@PathVariable String id) {
        Offer offer = shopService.getOfferById(id);
        OfferDTO offerDTO;
        if (offer != null) {
            List<Category> categories = shopService.getParentAndChildCategoriesOfOffer(offer.getId());
            List<CategoryDTO> categoryDTOList = makeCategoryDTOs(categories);

            offerDTO = makeOfferDTO(offer, categoryDTOList);
            return new ResponseEntity<OfferDTO>(offerDTO, HttpStatus.OK);
        }
        return new ResponseEntity<OfferDTO>(HttpStatus.NOT_ACCEPTABLE);
    }

    @RequestMapping(value = "/getCategories", method = RequestMethod.GET)
    public ResponseEntity<List<CategoryDTO>> getCategories() {
        List<CategoryDTO> categoryDTOS = new ArrayList<>();
        List<Category> categories = shopService.getMainCategories();
        if (categories != null) {
            categoryDTOS = makeCategoryDTOs(categories);
            return new ResponseEntity<List<CategoryDTO>>(categoryDTOS, HttpStatus.OK);
        }
        return new ResponseEntity<List<CategoryDTO>>(HttpStatus.NOT_ACCEPTABLE);
    }

/*    @RequestMapping(value = "/getAllCategoriesOfOffer/{id}")
    public ResponseEntity<List<CategoryDTO>> getAllCategoriesOfOffer(@PathVariable String id) {
        List<CategoryDTO> categoryDTOS = new ArrayList<>();
        List<Category> categories = shopService.getCategoriesOfOffer(id);
        if (categories != null) {
            categoryDTOS = makeCategoryDTOs(categories);
            return new ResponseEntity<List<CategoryDTO>>(categoryDTOS, HttpStatus.OK);
        }
        return new ResponseEntity<List<CategoryDTO>>(HttpStatus.NOT_ACCEPTABLE);
    }*/

    @GetMapping("/getOffersBySearch/{input}")
    public ResponseEntity<List<OfferDTO>> getSearchedOffers(@PathVariable String input) {
        List<OfferDTO> offerDTOS = new ArrayList<>();
        List<Offer> offers = shopService.getSearchedOffers(input);
        if (offers != null) {
            for (Offer offer : offers) {
                List<Category> categories = shopService.getParentAndChildCategoriesOfOffer(offer.getId());
                List<CategoryDTO> categoryDTOList = makeCategoryDTOs(categories);

                OfferDTO offerDTO = makeOfferDTO(offer, categoryDTOList);
                offerDTOS.add(offerDTO);
            }
            return new ResponseEntity<List<OfferDTO>>(offerDTOS, HttpStatus.OK);
        }
        return new ResponseEntity<List<OfferDTO>>(HttpStatus.NOT_ACCEPTABLE);
    }

    @GetMapping("/getOffersByCategoryId/{id}")
    public ResponseEntity<List<OfferDTO>> getOffersByCategoryId(@PathVariable String id) {
        List<OfferDTO> offerDTOS = new ArrayList<>();
        List<Offer> offers = shopService.getOffersByCategoryId(id);
        if (offers != null) {
            for (Offer offer : offers) {
                List<Category> categories = shopService.getParentAndChildCategoriesOfOffer(offer.getId());
                List<CategoryDTO> categoryDTOList = makeCategoryDTOs(categories);
                OfferDTO offerDTO = makeOfferDTO(offer, categoryDTOList);
                offerDTOS.add(offerDTO);
            }
            return new ResponseEntity<List<OfferDTO>>(offerDTOS, HttpStatus.OK);
        }
        return new ResponseEntity<List<OfferDTO>>(HttpStatus.NOT_ACCEPTABLE);
    }

    @GetMapping("/getParentAndChildCategoriesOfOffer/{id}")
    public ResponseEntity<List<CategoryDTO>> getParentAndChildCategoriesOfOffer(@PathVariable String id) {
        List<CategoryDTO> categoryDTOS = new ArrayList<>();
        List<Category> parentAndChildCategoriesOfOffer = shopService.getParentAndChildCategoriesOfOffer(id);
        if (parentAndChildCategoriesOfOffer != null) {
            categoryDTOS = makeCategoryDTOs(parentAndChildCategoriesOfOffer);
            return new ResponseEntity<List<CategoryDTO>>(categoryDTOS, HttpStatus.OK);
        }
        return new ResponseEntity<List<CategoryDTO>>(HttpStatus.NOT_ACCEPTABLE);
    }

    /**
     * Method converts a shop to ShopDTO
     */
    private ShopDTO makeShopDTO(Shop shop) {
        try {
            ShopDTO shopDTO = new ShopDTO();
            shopDTO.setId(shop.getId());
            shopDTO.setName(shop.getName());
            shopDTO.setUrl(shop.getUrl());
            shopDTO.setLocal_delivery_cost(shop.getLocal_delivery_cost());
            return shopDTO;
        } catch (Exception ex) {
            logger.error("Could not convert to ShopDTO");
        }
        return null;
    }

    /**
     * Method converts an Offer to an OfferDTO
     */
/*    private OfferDTO makeOfferDTO(Offer offer) {
        try {
            List<String> pictureUrls = new ArrayList<>();
            for (Picture picture : offer.getPictures()) {
                String url = picture.getUrl();
                pictureUrls.add(url);
            }
            double priceDiscount = (1 - (offer.getPrice() / offer.getOldprice())) * 100;
            double roundOff = Math.round(priceDiscount) / 100.0;
            return new OfferDTO(offer.getOfferId(), offer.getId(), offer.getUrl(), offer.getPrice(), offer.getOldprice(), offer.getCurrencyId(), offer.getCategoryId(), offer.isDelivery(), offer.getName(), offer.getVendor(), offer.getVendorCode(), offer.getModel(), offer.getDescription(), offer.isManufacturer_warranty(), offer.getAvailable(), pictureUrls, roundOff);
        } catch (Exception ex) {
            logger.error("Could not convert to OfferDTO");
        }
        return null;
    }*/
    private OfferDTO makeOfferDTO(Offer offer, List<CategoryDTO> categoryDTOS) {
        try {
            List<String> pictureUrls = new ArrayList<>();
            for (Picture picture : offer.getPictures()) {
                String url = picture.getUrl();
                pictureUrls.add(url);
            }
            double priceDiscount = (1 - (offer.getPrice() / offer.getOldprice())) * 100;
            DecimalFormat f = new DecimalFormat("##,00");
            double roundFormatted = Double.parseDouble(f.format(priceDiscount));
            return new OfferDTO(offer.getOfferId(), offer.getId(), offer.getUrl(), offer.getPrice(), offer.getOldprice(), offer.getCurrencyId(), offer.getCategoryId(), offer.isDelivery(), offer.getName(), offer.getVendor(), offer.getVendorCode(), offer.getModel(), offer.getDescription(), offer.isManufacturer_warranty(), offer.getAvailable(), pictureUrls, roundFormatted, categoryDTOS);
        } catch (Exception ex) {
            logger.error("Could not convert to OfferDTO");
        }
        return null;
    }

    private OfferDTO makeOfferDTOWithCategories(Offer offer) {
        try {
            List<String> pictureUrls = new ArrayList<>();
            for (Picture picture : offer.getPictures()) {
                String url = picture.getUrl();
                pictureUrls.add(url);
            }
            double priceDiscount = (1 - (offer.getPrice() / offer.getOldprice())) * 100;
            double roundOff = Math.round(priceDiscount) / 100.0;
            List<CategoryDTO> categoryDTOS = makeCategoryDTOs(offer.getCategories());
            return new OfferDTO(offer.getOfferId(), offer.getId(), offer.getUrl(), offer.getPrice(), offer.getOldprice(), offer.getCurrencyId(), offer.getCategoryId(), offer.isDelivery(), offer.getName(), offer.getVendor(), offer.getVendorCode(), offer.getModel(), offer.getDescription(), offer.isManufacturer_warranty(), offer.getAvailable(), pictureUrls, roundOff, categoryDTOS);
        } catch (Exception ex) {
            logger.error("Could not convert to OfferDTO");
        }
        return null;
    }

    /**
     * Method converts a Categories to cCategoryDTO's
     */
    private List<CategoryDTO> makeCategoryDTOs(List<Category> categories) {
        List<CategoryDTO> categoryDTOS = new ArrayList<>();
        if (categories != null) {
            for (Category category : categories) {
                CategoryDTO categoryDTO = new CategoryDTO();
                categoryDTO.setId(category.getId());
                categoryDTO.setCategoryId(category.getCategoryId());
                categoryDTO.setValue(category.getValue());
                categoryDTOS.add(categoryDTO);
            }
        }
        return categoryDTOS;
    }
}
