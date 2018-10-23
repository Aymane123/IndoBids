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
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Class is responsible for all transactions that include {@Offer}
 */
@Service
public class ShopService {
    private ShopRepository shopRepository;
    private OfferRepository offerRepository;
    private CategoryRepository categoryRepository;
    private List<Offer> allOffers;
    private Logger logger = LoggerFactory.getLogger(XmlFormatter.class);

    @Autowired
    public ShopService(ShopRepository shopRepository, OfferRepository offerRepository, CategoryRepository categoryRepository) {
        this.shopRepository = shopRepository;
        this.offerRepository = offerRepository;
        this.categoryRepository = categoryRepository;
        this.allOffers = this.offerRepository.findAll();
    }

    /**
     * Method gets the shop with details
     */
    public Shop getShop() {
        Shop shop = shopRepository.findFirstByOrderByIdAsc();
        if (shop != null) {
            return shop;
        }
        return null;
    }

    /**
     * Gets a random amount of offers
     */
    public List<Offer> getRandomOffers(int amount) {
        List<Offer> discountedOffers = offerRepository.findDiscountedOffers(amount);
        if (discountedOffers == null) {
            return null;
        }
        return discountedOffers;
    }

    /**
     * Method gets the offer by the ID
     */
    public Offer getOfferById(String id) {
        Offer offer = offerRepository.findById(id);
        if (offer != null) {
            return offer;
        }
        return null;
    }

    /**
     * Method gets all parent categories
     */
    public List<Category> getMainCategories() {
        List<Category> mainCategories = categoryRepository.findMainCategories("0");
        if (mainCategories != null) {
            return mainCategories;
        } else {
            return null;
        }
    }

    /**
     * Method gets all the categories that are used by offers
     */
    public List<Category> getMainCategoriesUsedByOffers() {
        List<Category> mainCategories = categoryRepository.findMainCategories("0");

        if (mainCategories != null) {
            return mainCategories;
        } else {
            return null;
        }
    }

    /**
     * Method gets all the categories of an offer
     */
    public List<Category> getCategoriesOfOffer(String id) {
        List<Category> categoriesOfOffer = categoryRepository.findCategoriesOfOffer(id);
        List<Category> parentCategory = categoryRepository.findParentCategoryForOffer(id);
        categoriesOfOffer.addAll(parentCategory);
        if (categoriesOfOffer != null) {
            return categoriesOfOffer;
        } else {
            return null;
        }
    }

    /**
     * Method gets parent & child categories for an Offer
     */
    public List<Category> getParentAndChildCategoriesOfOffer(String id) {
        Offer offer = offerRepository.findById(id);
        List<Category> parentAndChildCategories = new ArrayList<>();
        if (offer != null) {
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

    /**
     * Method gets offers filtered by name
     */
    public List<Offer> getSearchedOffers(String input) {
        List<Offer> searchedOffers = offerRepository.findSearchedOffers(input);
        if (searchedOffers != null) {
            return searchedOffers;
        } else {
            return null;
        }
    }

    /**
     * Method gets al amount of offers filtered by category ID
     */
    public List<Offer> getOffersByCategoryId(String id) {
        List<Offer> filteredOffers = new ArrayList<>();
        List<Offer> offers = offerRepository.findOffersByCategoryId(id);
        List<Category> categoriesOfSearchedOffer = categoryRepository.findByCategoryId(id);
        List<Category> childCategories = new ArrayList<>();
        for (Offer offer : offers) {
            for (Category category : categoriesOfSearchedOffer) {
                if (category.getParent_category().equals("0")) { //if its a parent, get the child category
                    childCategories = categoryRepository.findChildCategory(category.getCategoryId());
                }
                if (childCategories != null) {
                    for (Category childCategory : childCategories) {
                        if (offer.getCategoryId().equals(category.getCategoryId()) || offer.getCategoryId().equals(category.getParent_category()) || offer.getCategoryId().equals(childCategory.getCategoryId())) {
                            filteredOffers.add(offer);
                        }
                    }
                } else if (childCategories == null) {
                    if (offer.getCategoryId().equals(category.getCategoryId()) || offer.getCategoryId().equals(category.getParent_category())) {
                        filteredOffers.add(offer);
                    }
                }
                childCategories = null;
            }
        }
        return filteredOffers;
    }

    /**
     * Method gets the offers filtered by search & category ID
     */
    public List<Offer> getOffersByCategoryAndBySearch(String categoryId, String input) {
        List<Offer> filteredOffers = new ArrayList<>();
        List<Offer> searchedOffers = offerRepository.findSearchedOffers(input);
        List<Category> categoriesOfSearchedOffer = categoryRepository.findByCategoryId(categoryId);
        List<Category> childCategories = new ArrayList<>();
        for (Offer searchedOffer : searchedOffers) {
            for (Category category : categoriesOfSearchedOffer) {
                if (category.getParent_category().equals("0")) { //if its a parent, get the child category
                    childCategories = categoryRepository.findChildCategory(category.getCategoryId());
                }
                for (Category childCategory : childCategories) {
                    if (searchedOffer.getCategoryId().equals(category.getCategoryId()) || searchedOffer.getCategoryId().equals(category.getParent_category()) || searchedOffer.getCategoryId().equals(childCategory.getCategoryId())) {
                        filteredOffers.add(searchedOffer);
                    }
                }
                childCategories = null;
            }
        }
        return filteredOffers;
    }

}
