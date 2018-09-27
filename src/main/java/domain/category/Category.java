package domain.category;

import domain.offer.Offer;
import domain.shop.Shop;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlElement;
import java.util.List;

@Entity
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String categoryId;

    private String parent_category;

    //@OneToMany(fetch = FetchType.EAGER, mappedBy = "category")
    //@Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)
    //private List<Subcategory> subcategories;

    //@OneToMany(fetch = FetchType.EAGER, mappedBy = "offer")
    //@Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)
    //private List<Offer> offers;

    @ManyToOne(fetch = FetchType.EAGER)
    @Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)
    @JoinColumn(name = "CATEGORY_ID",nullable = false)
    private Shop shop;

    public Category() {

    }

    public int getId() {
        return id;
    }

    public Shop getShop() {
        return shop;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCategoryId() {
        return categoryId;
    }

    public String getParent_category() {
        return parent_category;
    }

    public void setCategoryId(String categoryId) {
        this.categoryId = categoryId;
    }

    public void setParent_category(String parent_category) {
        this.parent_category = parent_category;
    }

    public void setShop(Shop shop) {
        this.shop = shop;
    }
}
