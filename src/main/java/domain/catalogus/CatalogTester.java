package domain.catalogus;

import domain.category.Category;
import domain.offer.Offer;
import domain.shop.Currency;
import domain.shop.Shop;
import org.hibernate.annotations.Cascade;
import tools.CustomAdapter;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.util.List;

@XmlRootElement(name = "yml_catalog")
public class CatalogTester {
    private Shop shop;
    private String name;
    private String company;
    private String url;
    //@XmlJavaTypeAdapter(CustomAdapter.class)
    private List<Category> categories;
    private List<Offer> offers;

    public CatalogTester() {

    }

    public Shop getShop() {
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

    public List<Category> getCategories() {
        return categories;
    }

    public List<Offer> getOffers() {
        return offers;
    }

    public void setShop(Shop shop) {
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

    public void setCategories(List<Category> categories) {
        this.categories = categories;
    }

    public void setOffers(List<Offer> offers) {
        this.offers = offers;
    }
}
