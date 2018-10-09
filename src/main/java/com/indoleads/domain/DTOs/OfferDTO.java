package com.indoleads.domain.DTOs;

import javax.persistence.Column;
import java.util.Collection;
import java.util.List;

public class OfferDTO {
    private int offerId;
    private String id;
    private String url;
    private double price;
    private double oldprice;
    private String currencyId;
    private String categoryId;
    private boolean delivery;
    private String name;
    private String vendor;
    private String vendorCode;
    private String model;
    private String description;
    private boolean manufacturer_warranty;
    private String available;
    private Collection<String> picturesUrls;

    public OfferDTO(int offerId, String id, String url, double price, double oldprice, String currencyId, String categoryId, boolean delivery, String name, String vendor, String vendorCode, String model, String description, boolean manufacturer_warranty, String available, Collection<String> picturesUrls) {
        this.offerId = offerId;
        this.id = id;
        this.url = url;
        this.price = price;
        this.oldprice = oldprice;
        this.currencyId = currencyId;
        this.categoryId = categoryId;
        this.delivery = delivery;
        this.name = name;
        this.vendor = vendor;
        this.vendorCode = vendorCode;
        this.model = model;
        this.description = description;
        this.manufacturer_warranty = manufacturer_warranty;
        this.available = available;
        this.picturesUrls = picturesUrls;
    }


    public OfferDTO() {
    }

    public int getOfferId() {
        return offerId;
    }

    public void setOfferId(int offerId) {
        this.offerId = offerId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getOldprice() {
        return oldprice;
    }

    public void setOldprice(double oldprice) {
        this.oldprice = oldprice;
    }

    public String getCurrencyId() {
        return currencyId;
    }

    public void setCurrencyId(String currencyId) {
        this.currencyId = currencyId;
    }

    public String getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(String categoryId) {
        this.categoryId = categoryId;
    }

    public boolean isDelivery() {
        return delivery;
    }

    public void setDelivery(boolean delivery) {
        this.delivery = delivery;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getVendor() {
        return vendor;
    }

    public void setVendor(String vendor) {
        this.vendor = vendor;
    }

    public String getVendorCode() {
        return vendorCode;
    }

    public void setVendorCode(String vendorCode) {
        this.vendorCode = vendorCode;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isManufacturer_warranty() {
        return manufacturer_warranty;
    }

    public void setManufacturer_warranty(boolean manufacturer_warranty) {
        this.manufacturer_warranty = manufacturer_warranty;
    }

    public String getAvailable() {
        return available;
    }

    public void setAvailable(String available) {
        this.available = available;
    }

    public Collection<String> getPicturesUrls() {
        return picturesUrls;
    }

    public void setPicturesUrls(Collection<String> picturesUrls) {
        this.picturesUrls = picturesUrls;
    }
}
