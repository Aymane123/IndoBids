package domain.category;

import domain.offer.Offer;
import domain.shop.Shop;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.util.List;

@Entity
public class Category {
    @Id
    private int id;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "category")
    @Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)
    private List<Subcategory> subcategories;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "offer")
    @Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)
    private List<Offer> offers;

    @ManyToOne(fetch = FetchType.EAGER)
    @Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)
    @JoinColumn(name = "CATEGORY_ID",nullable = false)
    private Shop shop;



    public Category() {
    }
}
