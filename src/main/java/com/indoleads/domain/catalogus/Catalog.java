package com.indoleads.domain.catalogus;

import com.indoleads.domain.shop.Shop;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Catalog of the {@Shop} provided by the client
 */
@XmlRootElement(name = "yml_catalog")
@Entity
public class Catalog {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private Shop shop;

    public Catalog() {

    }

    public Shop getShop() {
        return shop;
    }

    public void setShop(Shop shop) {
        this.shop = shop;
    }
}
