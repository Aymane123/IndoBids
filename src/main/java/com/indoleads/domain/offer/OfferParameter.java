package com.indoleads.domain.offer;

import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlValue;

@Entity
@XmlAccessorType(XmlAccessType.NONE)
public class OfferParameter {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String name;
    private String value;

    @ManyToOne(fetch = FetchType.EAGER)
    @Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)
    @JoinColumn(name = "OFFER_PARAMETER_ID", nullable = false)
    private Offer offer;

    public OfferParameter() {

    }

    @XmlAttribute
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public Offer getOffer() {
        return offer;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setOffer(Offer offer) {
        this.offer = offer;
    }

    @XmlValue
    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
