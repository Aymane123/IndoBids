package domain.shop;

import domain.category.Category;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@Entity
public class Shop {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String name;
    private String company;
    private String url;
    private double local_delivery_cost;
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "currency")
    @Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)
    private List<Currency> currencies;
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "category")
    @Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)
    private List<Category> categories;

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

    public double getLocal_delivery_cost() {
        return local_delivery_cost;
    }

    public List<Currency> getCurrencies() {
        return currencies;
    }

    public List<Category> getCategories() {
        return categories;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
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
}
