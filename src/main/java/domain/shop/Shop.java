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
    @XmlElement(name="name")
    private String name;
    @XmlElement(name="url")
    private String url;
    @XmlElement(name="local_delivery_cost")
    private double deliveryCost;
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "currency")
    @Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)
    @XmlElement(name="currencies")
    private List<Currency> currencies;
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "category")
    @Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)
    @XmlElement(name="categories")
    private List<Category> categories;

    public Shop() {

    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getDeliveryCost() {
        return deliveryCost;
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

    public void setDeliveryCost(double deliveryCost) {
        this.deliveryCost = deliveryCost;
    }

    public void setCurrencies(List<Currency> currencies) {
        this.currencies = currencies;
    }

    public void setCategories(List<Category> categories) {
        this.categories = categories;
    }
}
