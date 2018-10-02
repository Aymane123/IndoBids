package com.indoleads.domain.catalogus;

import com.indoleads.domain.shop.Shop;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Catalog of the {@Shop} provided by the client
 */
@XmlRootElement(name = "yml_catalog")
public class Catalog {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Transient
    @OneToOne(mappedBy = "catalog", cascade = CascadeType.ALL,
            fetch = FetchType.EAGER, optional = false)
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
