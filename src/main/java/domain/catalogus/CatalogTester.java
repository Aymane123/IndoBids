package domain.catalogus;

import domain.category.Category;
import domain.offer.Offer;
import domain.shop.Currency;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "yml_catalog")
public class CatalogTester {
    private String shop;
    private String name;
    private String company;
    private String url;
    private double local_delivery_cost;
    private List<Currency> currencies;
    private List<Category> categories;
    private List<Offer> offers;

    public CatalogTester() {

    }

    public String getShop() {
        return shop;
    }

    public String getName() {
        return name;
    }

    public String getCompany() {
        return company;
    }

    public String getUrl() {
        return url;
    }

    public double getLocal_delivery_cost() {
        return local_delivery_cost;
    }

    public List<Currency> getCurrencies() {
        return currencies;
    }

    public List<Category> getCategories() {
        return categories;
    }

    public List<Offer> getOffers() {
        return offers;
    }

    public void setShop(String shop) {
        this.shop = shop;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void setLocal_delivery_cost(double local_delivery_cost) {
        this.local_delivery_cost = local_delivery_cost;
    }

    public void setCurrencies(List<Currency> currencies) {
        this.currencies = currencies;
    }

    public void setCategories(List<Category> categories) {
        this.categories = categories;
    }

    public void setOffers(List<Offer> offers) {
        this.offers = offers;
    }
}
