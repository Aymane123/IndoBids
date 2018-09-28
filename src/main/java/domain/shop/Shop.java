package domain.shop;

import domain.category.Category;
import domain.wrappers.CategoryWrapper;
import domain.wrappers.CurrencyWrapper;
import domain.wrappers.OfferWrapper;
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
    private String company;
    private String url;
    private String local_delivery_cost;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "currency")
    @Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)
    private List<Currency> currencyList;
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "category")
    @Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)
    private List<Category> categoryList;

    private CurrencyWrapper currencies;
    private CategoryWrapper categories;
    private OfferWrapper offers;

    public Shop() {

    }

    public String getUrl() {
        return url;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getCompany() {
        return company;
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

    public void setId(int id) {
        this.id = id;
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
/*
    public void setCategories(List<Category> categoryList) {
        this.categoryList = categoryList;
    }
    */
}
