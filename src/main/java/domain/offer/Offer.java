package domain.offer;

import domain.category.Category;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.Currency;
import java.util.List;

@Entity
public class Offer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String offerId;
    private String url;
    private double price;
    private double old_price;

    /*@ManyToOne(fetch = FetchType.EAGER)
    @Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)
    @JoinColumn(name = "CURRENCY_ID",nullable = false)
    private Currency currency;*/

    private boolean isDeliverable;
    private String name;
    private String vendor;
    private String vendorCode;
    private String model;
    private String description;
    private boolean hasWarranty;
    private boolean isAvailable;

    @ManyToOne(fetch = FetchType.EAGER)
    @Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)
    @JoinColumn(name = "CATEGORY_ID",nullable = false)
    private Category category;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "offer")
    @Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)
    private List<Picture> pictures;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "offer")
    @Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)
    private List<OfferParameter> offerParameters;


    public Offer() {

    }
/*
    public Currency getCurrency() {
        return currency;
    }

    public void setCurrency(Currency currency) {
        this.currency = currency;
    }
*/
    public void setVendorCode(String vendorCode) {
        this.vendorCode = vendorCode;
    }

    public String getVendorCode() {
        return vendorCode;
    }

    public int getId() {
        return id;
    }

    public String getUrl() {
        return url;
    }

    public double getPrice() {
        return price;
    }

    public double getOld_price() {
        return old_price;
    }

    public boolean isDeliverable() {
        return isDeliverable;
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

    public boolean isHasWarranty() {
        return hasWarranty;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public Category getCategory() {
        return category;
    }

    public List<Picture> getPictures() {
        return pictures;
    }

    public List<OfferParameter> getOfferParameters() {
        return offerParameters;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setOld_price(double old_price) {
        this.old_price = old_price;
    }

    public void setDeliverable(boolean deliverable) {
        isDeliverable = deliverable;
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

    public void setHasWarranty(boolean hasWarranty) {
        this.hasWarranty = hasWarranty;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public void setPictures(List<Picture> pictures) {
        this.pictures = pictures;
    }

    public void setOfferParameters(List<OfferParameter> offerParameters) {
        this.offerParameters = offerParameters;
    }

    public String getOfferId() {
        return offerId;
    }

    public void setOfferId(String offerId) {
        this.offerId = offerId;
    }
}
