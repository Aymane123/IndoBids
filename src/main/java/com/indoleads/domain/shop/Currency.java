package com.indoleads.domain.shop;

import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;

@Entity
@XmlAccessorType(XmlAccessType.NONE)
public class Currency {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @XmlAttribute(name = "id")
    private String currencyId;

    private String rate;

    @ManyToOne(fetch = FetchType.EAGER)
    @Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)
    @JoinColumn(name = "SHOP_ID", nullable = false)
    private Shop shop;

    public Currency() {
    }

    @XmlAttribute
    public int getId() {
        return id;
    }

    @XmlAttribute
    public String getRate() {
        return rate;
    }

    public Shop getShop() {
        return shop;
    }

    public void setRate(String rate) {
        this.rate = rate;
    }

    public void setShop(Shop shop) {
        this.shop = shop;
    }


    public String getCurrencyId() {
        return currencyId;
    }

    public void setCurrencyId(String currencyId) {
        this.currencyId = currencyId;
    }
}
