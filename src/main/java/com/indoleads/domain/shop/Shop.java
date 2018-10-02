package com.indoleads.domain.shop;

import com.indoleads.domain.catalogus.Catalog;
import com.indoleads.domain.category.Category;
import com.indoleads.domain.wrappers.CategoryWrapper;
import com.indoleads.domain.wrappers.CurrencyWrapper;
import com.indoleads.domain.wrappers.OfferWrapper;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlElement;
import java.util.List;

@Entity
public class Shop {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String name;

    @Transient
    private String company;

    private String url;
    private String local_delivery_cost;

    /*@OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "CAT_ID")
    private Catalog catalog;*/

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "shop")
    @Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)
    private List<Currency> currencyList;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "shop")
    @Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)
    private List<Category> categoryList;

    @Transient
    private CurrencyWrapper currencies;
    @Transient
    private CategoryWrapper categories;
    @Transient
    private OfferWrapper offers;

    public Shop() {

    }

    public String getUrl() {
        return url;
    }


    public void setUrl(String url) {
        this.url = url;
    }


    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getLocal_delivery_cost() {
        return local_delivery_cost;
    }

    @XmlElement(name = "currencies")
    public CurrencyWrapper getCurrencies() {
        return currencies;
    }

    @XmlElement(name = "categories")
    public CategoryWrapper getCategories() {
        return categories;
    }

    @XmlElement(name = "offers")
    public OfferWrapper getOffers() {
        return offers;
    }

    public void setOffers(OfferWrapper offers) {
        this.offers = offers;
    }

    public void setCategories(CategoryWrapper categories) {
        this.categories = categories;
    }


    public void setName(String name) {
        this.name = name;
    }

    public void setLocal_delivery_cost(String local_delivery_cost) {
        this.local_delivery_cost = local_delivery_cost;
    }

    public void setCurrencies(CurrencyWrapper currencies) {
        this.currencies = currencies;
    }

    public List<Category> getCategoryList() {
        return categoryList;
    }

    public void setCategoryList(List<Category> categoryList) {
        this.categoryList = categoryList;
    }

    public List<Currency> getCurrencyList() {
        return currencyList;
    }

    public void setCurrencyList(List<Currency> currencyList) {
        this.currencyList = currencyList;
    }
}
