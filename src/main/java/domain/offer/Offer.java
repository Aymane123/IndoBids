package domain.offer;

import domain.category.Category;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import java.util.List;

@Entity
public class Offer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int offer_id;
    private String id;
    private String url;
    private double price;
    private double oldprice;
    private String currencyId;
    private String categoryId;

    /*@ManyToOne(fetch = FetchType.EAGER)
    @Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)
    @JoinColumn(name = "CURRENCY_ID",nullable = false)
    private Currency currency;*/

    private boolean delivery;
    private String name;
    private String vendor;
    private String vendorCode;
    private String model;
    private String description;
    private boolean manufacturer_warranty;
    private String available;

    @ManyToOne(fetch = FetchType.EAGER)
    @Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)
    @JoinColumn(name = "CATEGORY_ID", nullable = false)
    private Category category;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "offer")
    @Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)
    private List<Picture> pictures;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "offer")
    @Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)
    private List<OfferParameter> offerParameters;


    public Offer() {

    }

    public void setVendorCode(String vendorCode) {
        this.vendorCode = vendorCode;
    }

    public String getVendorCode() {
        return vendorCode;
    }

    @XmlAttribute
    public String getId() {
        return id;
    }

    public String getUrl() {
        return url;
    }

    public double getPrice() {
        return price;
    }

    public double getOldprice() {
        return oldprice;
    }

    public boolean isDelivery() {
        return delivery;
    }

    public String getName() {
        return name;
    }

    public String getVendor() {
        return vendor;
    }

    public String getModel() {
        return model;
    }

    public String getDescription() {
        return description;
    }

    public boolean isManufacturer_warranty() {
        return manufacturer_warranty;
    }

    @XmlAttribute
    public String getAvailable() {
        return available;
    }

    @XmlElement(name = "picture")
    public List<Picture> getPictures() {
        return pictures;
    }

    @XmlElement(name = "param")
    public List<OfferParameter> getOfferParameters() {
        return offerParameters;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setOldprice(double oldprice) {
        this.oldprice = oldprice;
    }

    public void setDelivery(boolean delivery) {
        this.delivery = delivery;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setVendor(String vendor) {
        this.vendor = vendor;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setManufacturer_warranty(boolean manufacturer_warranty) {
        this.manufacturer_warranty = manufacturer_warranty;
    }

    public void setAvailable(String available) {
        this.available = available;
    }

    /*
        public void setCategory(Category category) {
            this.category = category;
        }
    */
    public void setPictures(List<Picture> pictures) {
        this.pictures = pictures;
    }

    public void setOfferParameters(List<OfferParameter> offerParameters) {
        this.offerParameters = offerParameters;
    }

    public String getOfferId() {
        return id;
    }
/*
    public void setOfferId(String offerId) {
        this.id = id;
    }
    */

    public void setCurrencyId(String currencyId) {
        this.currencyId = currencyId;
    }

    public void setCategoryId(String categoryId) {
        this.categoryId = categoryId;
    }

    public String getCurrencyId() {
        return currencyId;
    }

    public String getCategoryId() {
        return categoryId;
    }

    public int getOffer_id() {
        return offer_id;
    }

    public void setOffer_id(int offer_id) {
        this.offer_id = offer_id;
    }
}
