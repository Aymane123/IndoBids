package domain.shop;

import domain.category.Category;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.util.List;

@Entity
public class Shop {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String name;
    private double deliveryCost;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "currency")
    @Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)
    private List<Currency> currencies;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "category")
    @Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)
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
}
