package com.indoleads.service;

import com.indoleads.domain.catalogus.Catalog;
import com.indoleads.domain.category.Category;
import com.indoleads.domain.offer.Offer;
import com.indoleads.domain.offer.OfferParameter;
import com.indoleads.domain.offer.Picture;
import com.indoleads.domain.shop.Currency;
import com.indoleads.domain.shop.Shop;
import com.indoleads.repository.*;
import com.indoleads.tools.Formatter;
import com.indoleads.tools.XmlFormatter;
import org.hibernate.Hibernate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;

import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@PersistenceContext(type= PersistenceContextType.EXTENDED)
public class PersistenceService {
    private Logger logger = LoggerFactory.getLogger(XmlFormatter.class);

    private Formatter formatter;
    private ShopRepository shopRepository;
    private CategoryRepository categoryRepository;
    private CurrencyRepository currencyRepository;
    private OfferParameterRepository offerParameterRepository;
    private OfferRepository offerRepository;
    private PictureRepository pictureRepository;

    Catalog catalog;
    String inputFile = "C:\\Users\\School\\Desktop\\SCHOOL jaar 4\\STAGEPROJECT\\stageProject\\Indobids\\src\\main\\resources\\2018-08-26_gear_best_5b3b041a7c4b9622d4722ebd.xml";
    Shop shop;
    @Autowired
    public PersistenceService(Formatter formatter, ShopRepository shopRepository, CategoryRepository categoryRepository, CurrencyRepository currencyRepository, OfferParameterRepository offerParameterRepository, OfferRepository offerRepository, PictureRepository pictureRepository) {
        this.formatter = formatter;
        this.shopRepository = shopRepository;
        this.categoryRepository = categoryRepository;
        this.currencyRepository = currencyRepository;
        this.offerParameterRepository = offerParameterRepository;
        this.offerRepository = offerRepository;
        this.pictureRepository = pictureRepository;

        catalog = formatter.formatToObject(inputFile);
        shop = createShop();
        fillShopTable();
        fillCurrencyTable();
        fillCategoryTable();
        fillOfferTable();
        fillPictureTable();
        fillOfferParameterTable();
    }


    private void fillShopTable(){
        shopRepository.save(shop);
    }
    private void fillCurrencyTable(){
        List<Currency> currencies = catalog.getShop().getCurrencies().getCurrencies();
        for (int i = 0; i < currencies.size(); i++) {
            Currency currency = new Currency();
            currency.setShop(shop);
            currency.setRate(catalog.getShop().getCurrencies().getCurrencies().get(i).getRate());
            currency.setCurrencyId(catalog.getShop().getCurrencies().getCurrencies().get(i).getCurrencyId());
            currencyRepository.save(currency);


        }
        currencyRepository.flush();
    }

    private void fillCategoryTable(){
        List<Category> allCategories = catalog.getShop().getCategories().getCategories();
        List<Category> categories = new ArrayList<>();
        for (int i = 0; i < allCategories.size(); i++) {
            Category category = new Category();
            category.setShop(shop);
            category.setCategoryId(catalog.getShop().getCategories().getCategories().get(i).getCategoryId());
            category.setParent_category(catalog.getShop().getCategories().getCategories().get(i).getParent_category());
            category.setValue(catalog.getShop().getCategories().getCategories().get(i).getValue());
            category.setOffers(catalog.getShop().getOffers().getOffers());
            categories.add(category);
        }
        categoryRepository.save(categories);
        categoryRepository.flush();
    }

    private void fillOfferTable(){
        List<Offer> offers = new ArrayList<>();
        //catalog.getShop().getOffers().getOffers().size()
        for (int i = 0; i < catalog.getShop().getOffers().getOffers().size(); i++) {
            Offer offer = new Offer();
            offer.setId(catalog.getShop().getOffers().getOffers().get(i).getId());
            offer.setVendorCode(catalog.getShop().getOffers().getOffers().get(i).getVendorCode());
            offer.setVendor(catalog.getShop().getOffers().getOffers().get(i).getVendor());
            offer.setUrl(catalog.getShop().getOffers().getOffers().get(i).getUrl());
            offer.setPrice(catalog.getShop().getOffers().getOffers().get(i).getPrice());
            offer.setOldprice(catalog.getShop().getOffers().getOffers().get(i).getOldprice());
            offer.setName(catalog.getShop().getOffers().getOffers().get(i).getName());
            offer.setModel(catalog.getShop().getOffers().getOffers().get(i).getModel());
            offer.setDescription(catalog.getShop().getOffers().getOffers().get(i).getDescription());
            offer.setManufacturer_warranty(catalog.getShop().getOffers().getOffers().get(i).isManufacturer_warranty());
            offer.setAvailable(catalog.getShop().getOffers().getOffers().get(i).getAvailable());
            offer.setCategoryId(catalog.getShop().getOffers().getOffers().get(i).getCategoryId());
            offer.setCurrencyId(catalog.getShop().getOffers().getOffers().get(i).getCurrencyId());
            offer.setDelivery(catalog.getShop().getOffers().getOffers().get(i).isDelivery());

            offer.setPictures(catalog.getShop().getOffers().getOffers().get(i).getPictures());
            offer.setOfferParameters(catalog.getShop().getOffers().getOffers().get(i).getOfferParameters());

            Category category = categoryRepository.findByCategoryId(offer.getCategoryId());
            offer.setCategory(category);

            offers.add(offer);
        }
        offerRepository.save(offers);
        offerRepository.flush();
    }


    private void fillPictureTable(){
        List<Picture> pictureList = new ArrayList<>();
        List<Offer> offers = offerRepository.findAll();


        for (Offer offer : offers) {
            for (Offer o : catalog.getShop().getOffers().getOffers()) {
                if (offer.getId().equals(o.getId())){

                    if (o.getPictures() != null){
                        for (Picture picture : o.getPictures()) {
                            Picture p = new Picture();
                            p.setUrl(picture.getUrl());
                            p.setOffer(offer);
                            pictureList.add(p);
                        }
                    }
                }
            }
            logger.info("Pictures toegevoegd voor offer id" + offer.getId());

        }
        pictureRepository.save(pictureList);
        pictureRepository.flush();
    }

    private void fillOfferParameterTable(){
        List<OfferParameter> offerParameterList = new ArrayList<>();
        List<Offer> offers = offerRepository.findAll();

        for (Offer offer : offers) {
            for (Offer o : catalog.getShop().getOffers().getOffers()) {
                if (offer.getId().equals(o.getId())){

                    if (o.getOfferParameters() != null){
                        for (OfferParameter offerParameter : o.getOfferParameters()) {
                            OfferParameter op = new OfferParameter();
                            op.setName(offerParameter.getName());
                            op.setValue(offerParameter.getValue());
                            op.setOffer(offer);
                            offerParameterList.add(op);
                        }
                    }

                }
            }

        }

        offerParameterRepository.save(offerParameterList);
        offerParameterRepository.flush();
    }


    private Shop createShop(){
        Shop shop = new Shop();
        shop.setName(catalog.getShop().getName());
        shop.setCategoryList(catalog.getShop().getCategories().getCategories());
        shop.setCurrencyList(catalog.getShop().getCurrencies().getCurrencies());
        shop.setLocal_delivery_cost(catalog.getShop().getLocal_delivery_cost());
        shop.setUrl(catalog.getShop().getUrl());

        return shop;
    }
}
