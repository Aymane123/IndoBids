package com.indoleads.domain.category;

import com.indoleads.domain.offer.Offer;
import com.indoleads.domain.shop.Shop;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlValue;
import java.util.List;

@Entity
@XmlAccessorType(XmlAccessType.NONE)
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String categoryId; //nodig, deze ID wordt uit de XML file gehaald
    private String parent_category;
    private String value;

    //@OneToMany(fetch = FetchType.EAGER, mappedBy = "category")
    //@Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)
    //private List<Subcategory> subcategories;

    /*@OneToMany(fetch = FetchType.EAGER, mappedBy = "category") //DIT VERANDEREN!!!
    @Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)
    private List<Offer> offers;*/

    @ManyToMany(mappedBy = "categories")
    @Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)
    private List<Offer> offers;

    @ManyToOne(fetch = FetchType.EAGER)
    @Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)
    @JoinColumn(name = "SHOP_ID", nullable = false)
    private Shop shop;

    public Category() {

    }

    public int getId() {
        return id;
    }

    public Shop getShop() {
        return shop;
    }


    @XmlAttribute(name = "id")
    public String getCategoryId() {
        return categoryId;
    }

    @XmlAttribute(name = "parent_id")
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

    @XmlValue
    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public List<Offer> getOffers() {
        return offers;
    }

    public void setOffers(List<Offer> offers) {
        this.offers = offers;
    }


}
