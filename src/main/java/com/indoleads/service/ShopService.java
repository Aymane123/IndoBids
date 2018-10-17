package com.indoleads.service;

import com.indoleads.domain.category.Category;
import com.indoleads.domain.offer.Offer;
import com.indoleads.domain.shop.Shop;
import com.indoleads.repository.CategoryRepository;
import com.indoleads.repository.OfferRepository;
import com.indoleads.repository.ShopRepository;
import com.indoleads.tools.XmlFormatter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ShopService {
    private ShopRepository shopRepository;
    private OfferRepository offerRepository;
    private CategoryRepository categoryRepository;
    private Logger logger = LoggerFactory.getLogger(XmlFormatter.class);

    @Autowired
    public ShopService(ShopRepository shopRepository, OfferRepository offerRepository, CategoryRepository categoryRepository) {
        this.shopRepository = shopRepository;
        this.offerRepository = offerRepository;
        this.categoryRepository = categoryRepository;
    }

    public Shop getShop() {
        Shop shop = shopRepository.findFirstByOrderByIdAsc();
        if (shop != null) {
            return shop;
        }
        return null;
    }

    /**
     * Gets amount of orders for the shop
     */
    public List<Offer> getShopOffers(int amount) {
        try {
            Shop shop = shopRepository.findFirstByOrderByIdAsc();
            if (shop != null) {
                //return this.offerRepository.findFirst(amount);
            }
        } catch (Exception ex) {
            logger.error("Could not get offers for shop.");
        }
        return null;
    }

    public Offer getOfferById(String id) {
        Offer offer = offerRepository.findById(id);
        if (offer != null){
            return offer;
        }
        return null;
    }

    public List<Offer> getRandomOffers(int amount) {
        ArrayList<Offer> offers = new ArrayList<>();
        Long qty = offerRepository.count();
        for (int i = 0; i < amount; i++) {
            int idx = (int)(Math.random() * qty);
            Page<Offer> offerPage = offerRepository.findAll(new PageRequest(idx, 1));
            Offer o = null;
            if (offerPage.hasContent()) {
                o = offerPage.getContent().get(0);
                offers.add(o);
            }
        }
        return offers;
    }

    public List<Offer> get20ShopOffer() {
        List<Offer> offers = offerRepository.findAll();
        List<Offer> offerList = new ArrayList<>();
        if (offers.size() != 0){
            for (int i = 0; i < 20; i++) {
                offerList.add(offers.get(i));
            }
        }
        return offerList;

    }

    public List<Category> getMainCategories() {
        List<Category> mainCategories = categoryRepository.findMainCategories("0");
        if (mainCategories != null){
            return mainCategories;
        }
        else{
            return null;
        }
    }

    public List<Category> getCategoriesOfOffer(String id) {
        List<Category> categoriesOfOffer = categoryRepository.findByCategoryId(id);
        if (categoriesOfOffer != null){
            return categoriesOfOffer;
        }
        else{
            return null;
        }
    }

    public List<Offer> getSearchedOffers(String input) {
        List<Offer> searchedOffers = offerRepository.findSearchedOffers(input);
        if (searchedOffers != null){
            return searchedOffers;
        }
        else{
            return null;
        }
    }

    public List<Category> getParentAndChildCategoriesOfOffer(String id) {
        Offer offer = offerRepository.findById(id);
        List<Category> parentAndChildCategories = new ArrayList<>();



        if (offer != null){
            List<Category> categoriesOfOffer = categoryRepository.findCategoriesOfOfferByCategoryId(offer.getCategoryId());
            List<Category> parentCategoriesOfOffer = new ArrayList<>();
            for (Category category : categoriesOfOffer) {
                parentCategoriesOfOffer = categoryRepository.findCategoriesOfOfferByCategoryId(category.getParent_category());
            }
            parentAndChildCategories.addAll(categoriesOfOffer);
            parentAndChildCategories.addAll(parentCategoriesOfOffer);
        }
        return parentAndChildCategories;
    }
}
